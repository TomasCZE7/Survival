package object.entity;

import object.ObjectToRender;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager implements ObjectToRender {

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

    @Override
    public void render(Graphics2D g) {
        entities.forEach((entity -> render(g)));
    }

    @Override
    public void tick() {
        entities.forEach(Entity::tick);
    }
}
