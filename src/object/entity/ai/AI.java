package object.entity.ai;

import core.GameMain;
import object.entity.Entity;
import object.entity.ally.Player;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class AI extends Entity {


    public AI(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    private int movingTime = 0;
    private int movingTimeMax = 0;

    @Override
    public void tick() {
        super.tick();
        Player player = GameMain.core.getObjectManager().getPlayer();
        if(getCenter().distance(player.getCenter()) < 150 && getCenter().distance(player.getCenter()) > 1){
            resetVelocity();
            moveToward(GameMain.core.getObjectManager().getPlayer().getCenter(), 1.25F);
        } else if(movingTime >= movingTimeMax){
            movingTimeMax = GameMain.core.getRandom().nextInt(100)+50;
            resetVelocity();
            double movingVelocity = 0.75;
            switch(GameMain.core.getRandom().nextInt(4)){
                case 0:
                    setXVelocity(movingVelocity);
                    break;
                case 1:
                    setXVelocity(-movingVelocity);
                    break;
                case 2:
                    setYVelocity(movingVelocity);
                    break;
                case 3:
                    setYVelocity(-movingVelocity);
                    break;
            }
            movingTime = 0;
        }
        if(getCustomShape().getShape().intersects((Rectangle2D) player.getCustomShape().getShape())){
            player.damageEntity(getDamage());
        }
        movingTime += 1;
    }

}