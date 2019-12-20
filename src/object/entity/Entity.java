package object.entity;

import core.GameMain;
import object.Registrable;
import object.GameObject;

import java.awt.*;

public abstract class Entity extends GameObject implements Registrable {

    private double health;

    public Entity(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

   @Override
    public void register() {
        GameMain.core.getEntityManager().addEntity(this);
    }

    public double getHealth() {
        return health;
    }

    public abstract double getDamage();

    public abstract double getMaxHealth();

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
