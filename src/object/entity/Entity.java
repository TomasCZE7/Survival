package object.entity;

import core.GameMain;
import object.Registrable;
import object.MovingObject;

import java.awt.*;

public abstract class Entity extends MovingObject implements Registrable, Health, Damage {

    private double health;

    public Entity(double x, double y, Color color, double width, double height) {
        this(x, y, color, width, height, true);
    }

    public Entity(double x, double y, Color color, Dimension size) {
        this(x, y, color, size.getWidth(), size.getHeight(), true);
    }

    public Entity(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
        health = getMaxHealth();
    }

    public Entity(double x, double y, Color color, Dimension size, boolean fill) {
        this(x, y, color, size.getWidth(), size.getHeight(), fill);
    }

   @Override
    public void register() {
        GameMain.core.getEntityManager().addEntity(this);
    }

    public double getHealth() {
        return health;
    }


    public void damageEntity(double damage){
        health -= damage;
        if(health <= 0){
            die();
        }
    }

    public void die(){
        GameMain.core.getEntityManager().removeEntity(this);
    }
}
