package object.entity;

import core.GameMain;

public interface Health {

    double getMaxHealth();

    default void checkHealth(double health, Entity entity){
        if(health < 0){
            die(entity);
        }
    }

    default void die(Entity entity){
        GameMain.core.getEntityManager().removeEntity(entity);
    }

}
