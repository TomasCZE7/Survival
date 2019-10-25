package object;

import core.Core;
import object.ally.Player;
import object.enviroment.PlayerMovementArea;
import object.enviroment.Text;

import java.awt.*;
import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<Coordinates> objects = new ArrayList<>();

    //Main objects
    private Player player;
    private PlayerMovementArea playerMovementArea;
    private Text fpsText;

    public void initialize() {
        player = new Player((Core.WIDTH+20)/2.0, (Core.HEIGHT+20)/2.0, Color.GRAY, 20, 20, true);
        fpsText = new Text(10, 20, Color.GRAY, "FPS: ", new Font("default", Font.BOLD, 15));
        playerMovementArea = new PlayerMovementArea();
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

    public void addObject(Coordinates object){
        objects.add(object);
    }

    public void addMovingObject(MovingObject object){
        addObject(object);
    }

    public void addDimensionalObject(DimensionalObject object){
        addObject(object);
    }

    public ArrayList<DimensionalObject> getDimensionalObjects() {
        ArrayList<DimensionalObject> objects = new ArrayList<>();
        for(Coordinates bs : getAllObjects()){
            if(bs instanceof DimensionalObject){
                objects.add((DimensionalObject) bs);
            }
        }
        return objects;
    }

    public ArrayList<MovingObject> getMovingObjects() {
        ArrayList<MovingObject> objects = new ArrayList<>();
        for (Coordinates bs : getAllObjects()) {
            if (bs instanceof MovingObject) {
                objects.add((MovingObject) bs);
            }
        }
        return objects;
    }

    public ArrayList<ObjectToShow> getObjectsToShow() {
        ArrayList<ObjectToShow> list = new ArrayList<>();
        for(Coordinates object : getAllObjects()){
            if(object instanceof ObjectToShow){
                ObjectToShow objectToShow = (ObjectToShow) object;
                list.add(objectToShow);
            }
        }
        return list;
    }


    public ArrayList<Coordinates> getAllObjects(){
        return objects;
    }

    public Text getFpsText() {
        return fpsText;
    }

    public PlayerMovementArea getPlayerMovementArea() {
        return playerMovementArea;
    }
}
