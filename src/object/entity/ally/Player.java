package object.entity.ally;

import core.GameMain;
import object.MovingObject;
import object.entity.Entity;
import object.enviroment.PlayerMovementArea;
import object.Coordinates;
import object.enviroment.Text;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends Entity {

    public Player(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
    }

    @Override
    public Shape getShape(Graphics2D g) {
        return new Rectangle2D.Double(getX(), getY(), getHeight(), getWidth());
    }

    @Override
    public void tick() {
        super.tick();
        checkCollision();
        checkMovement();
    }

    public void checkCollision(){

    }

    private void checkMovement(){
        PlayerMovementArea area = GameMain.core.getObjectManager().getPlayerMovementArea();
        double xDestination = getX(), yDestination = getY();
        double xDifference = 0, yDifference = 0;
        if(getX() < area.getX()){
            xDifference = area.getX()-getX();
            xDestination = area.getX();
        }
        if(getX()+getHeight() > area.getX() + area.getHeight()){
            xDifference = getX()+getHeight() - area.getX() + area.getHeight();
            xDestination = area.getX()+area.getWidth()-getWidth();
        }
        if(getY() < area.getY()){
            yDifference = area.getY() - getY();
            yDestination = area.getY();
        }
        if(getY()+getWidth() > area.getY() + area.getWidth()){
            yDifference = getY()+getWidth() - area.getY() + area.getWidth();
            yDestination = area.getY()+area.getHeight()-getHeight();
        }

        teleport(xDestination, yDestination);
        for(Coordinates object : GameMain.core.getObjectManager().getAllObjects()){
            if(object instanceof Text){
                Text text = (Text) object;
                if(text.isFixedOnScreen()){
                    continue;
                }
            }
            object.move(xDifference, yDifference);
        }
    }

    @Override
    public double getDefaultDamage() {
        return 3;
    }

    @Override
    public double getMaxHealth() {
        return 100;
    }
}
