package object;

import core.GameMain;
import core.component.shape.TextShape;
import object.entity.ally.Player;
import object.environment.Wall;

import java.awt.*;
import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<GameObject> objects = new ArrayList<>();
    private ArrayList<TextShape> texts = new ArrayList<>();

    //Main objects
    private Player player;
    private TextShape fpsText;

    public void initialize() {
        player = (Player)new Player(( GameMain.core.getSettings().getWidth()+20)/2.0, (GameMain.core.getSettings().getHeight()+20)/2.0, 20, 20).setColor(Color.GREEN).setFill(true);
        fpsText = (TextShape) new TextShape(10, 20, "FPS: ").setFont(new Font("default", Font.BOLD, 15)).setSticky(true).setColor(Color.GRAY);
        new Wall(50, 50, 90, 60).setColor(Color.BLUE).setFill(true).setFill(true);
        new TextShape(100, 100, "Test").setSticky(false);
    }

    public Player getPlayer() {
        return player;
    }

    public void render(Graphics2D g){
        for(GameObject object : objects){
            object.render(g);
        }
        for(TextShape text : texts){
            text.render(g);
        }
    }

    public void tick() {
        for (GameObject object : objects) {
            object.tick();
        }
    }

    public void addText(TextShape text){
        texts.add(text);
    }

    public void addObject(GameObject object){
        objects.add(object);
    }

    public ArrayList<GameObject> getObjects(){
        return objects;
    }

    public TextShape getFpsText() {
        return fpsText;
    }

    public ArrayList<TextShape> getTexts() {
        return texts;
    }
}
