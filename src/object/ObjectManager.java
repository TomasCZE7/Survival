package object;

import object.ally.Player;
import object.enviroment.Text;
import object.template.BasicObject;
import object.template.DimensionalObject;
import object.template.MovingObject;
import object.template.ObjectToShow;

import java.awt.*;
import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<DimensionalObject> dimensionalObjects = new ArrayList<>();
    private ArrayList<MovingObject> movingObjects = new ArrayList<>();

    //Main objects
    private Player player;
    private Text fpsText;

    public ObjectManager(){
        initialize();
    }

    public void initialize() {
        player = new Player(0, 0, Color.GRAY, 30, 30, true);
        addMovingObject(player);
        fpsText = new Text(0, 0, Color.GRAY, 30, 30, "FPS");
        addMovingObject(fpsText);
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

    public void addMovingObject(MovingObject object){
        movingObjects.add(object);
    }

    public void addDimensionalObject(DimensionalObject object){
        dimensionalObjects.add(object);
    }

    public ArrayList<DimensionalObject> getDimensionalObjects() {
        return dimensionalObjects;
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

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    public ArrayList<BasicObject> getAllObjects(){
        ArrayList<BasicObject> list = new ArrayList<>();
        list.addAll(getMovingObjects());
        list.addAll(getDimensionalObjects());
        return list;
    }


}
