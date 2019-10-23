package object.ally;

import core.GameMain;
import object.enviroment.PlayerMovementArea;
import object.template.MovingObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends MovingObject {

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

    public void checkMovement(){
        PlayerMovementArea area = GameMain.core.getObjectManager().getPlayerMovementArea();
        double xDestination = getX(), yDestination = getY();

        if(getX() < area.getX()){
            xDestination = area.getX();
        }
        if(getX()+getHeight() > area.getX() + area.getHeight()){
            xDestination = area.getX()+area.getWidth()-getWidth();
        }
        if(getY() < area.getY()){
            yDestination = area.getY();
        }
        if(getY()+getWidth() > area.getY() + area.getWidth()){
            yDestination = area.getY()+area.getHeight()-getHeight();
        }
        teleport(xDestination, yDestination);
    }

}
