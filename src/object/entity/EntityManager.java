package object.entity;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private ArrayList<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity){
        entities.add(entity);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }

    public void render(Graphics2D g) {
        for(Entity entity : entities){
            entity.render(g);
        }
    }

    public void tick() {
        for(Entity entity : entities){
            entity.tick();
        }
    }
}
