package object.entity.ai;

import core.GameMain;
import object.entity.Entity;

import java.awt.*;

public abstract class AI extends Entity {


    public AI(double x, double y, Color color, double width, double height) {
        super(x, y, color, width, height);
    }

    public AI(double x, double y, Color color, Dimension size) {
        super(x, y, color, size);
    }

    public AI(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
    }

    public AI(double x, double y, Color color, Dimension size, boolean fill) {
        super(x, y, color, size, fill);
    }

    double movingTime = 0;
    double movingTimeMax = 0;
    double movingVelocity = 2;

    @Override
    public void tick() {
        super.tick();
        if(movingTime == movingTimeMax){
            movingTimeMax = GameMain.core.getRandom().nextInt(100);
            resetVelocity();
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
        }else {
            movingTime += 1;
        }
    }
}