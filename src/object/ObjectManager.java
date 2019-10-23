package object;

import core.Core;
import object.ally.Player;
import object.enviroment.PlayerMovementArea;
import object.enviroment.Text;
import object.template.BasicObject;
import object.template.DimensionalObject;
import object.template.MovingObject;
import object.template.ObjectToShow;

import java.awt.*;
import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<BasicObject> basicObjects = new ArrayList<>();
    private ArrayList<DimensionalObject> dimensionalObjects = new ArrayList<>();
    private ArrayList<MovingObject> movingObjects = new ArrayList<>();

    //Main objects
    private Player player;
    private PlayerMovementArea playerMovementArea;
    private Text fpsText;

    public void initialize() {
        player = new Player((Core.WIDTH+20)/2.0, (Core.HEIGHT+20)/2.0, Color.GRAY, 20, 20, true);
        fpsText = new Text(10, 20, Color.GRAY, "FPS", new Font("default", Font.BOLD, 15));
        playerMovementArea = new PlayerMovementArea(Core.WIDTH/3.0, Core.HEIGHT/4.5);
    }

    public Player getPlayer() {
        return player;
    }

    public void render(Graphics2D g){
        for(ObjectToShow object : getObjectsToShow()){
            object.render(g);
        }
    }

    public void tick() {
        for (ObjectToShow object : getObjectsToShow()) {
            object.tick();
        }
    }

    public void addBasicObject(BasicObject object){
        basicObjects.add(object);
    }

    public void addMovingObject(MovingObject object){
        movingObjects.add(object);
    }

    public void addDimensionalObject(DimensionalObject object){
        dimensionalObjects.add(object);
    }

    public ArrayList<DimensionalObject> getDimensionalObjects() {
        return dimensionalObjects;
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    public ArrayList<ObjectToShow> getObjectsToShow() {
        ArrayList<ObjectToShow> list = new ArrayList<>();
        for(BasicObject object : getAllObjects()){
            if(object instanceof ObjectToShow){
                ObjectToShow objectToShow = (ObjectToShow) object;
                list.add(objectToShow);
            }
        }
        return list;
    }


    public ArrayList<BasicObject> getAllObjects(){
        ArrayList<BasicObject> list = new ArrayList<>();
        list.addAll(getMovingObjects());
        list.addAll(getDimensionalObjects());
        return list;
    }

    public ArrayList<BasicObject> getBasicObjects() {
        return basicObjects;
    }

    public Text getFpsText() {
        return fpsText;
    }

    public PlayerMovementArea getPlayerMovementArea() {
        return playerMovementArea;
    }
}
