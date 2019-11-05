package object.entity.ally;

import core.GameMain;
import object.entity.Entity;
import object.environment.PlayerMovementArea;
import object.Coordinates;
import object.environment.Text;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends Entity {

    public double realX, realY;

    public Player(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
        realX = getX();
        realY = getY();
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
        //LEFT
        if(getX() < area.getX()){
            xDifference = area.getX()-getX();
            xDestination = area.getX();
        }
        //RIGHT
        if(getX()+getHeight() > area.getX() + area.getHeight()){
            xDifference =  (area.getX() + area.getHeight()) - (getX()+getHeight());
            xDestination = area.getX()+area.getWidth()-getWidth();
        }
        //UP
        if(getY() < area.getY()){
            yDifference = area.getY() - getY();
            yDestination = area.getY();
        }
        //DOWN
        if(getY()+getWidth() > area.getY() + area.getWidth()){
            yDifference = (area.getY() + area.getWidth()) - (getY() + getWidth());
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

        for(Entity entity : GameMain.core.getEntityManager().getEntities()){
            if(entity == this) continue;
            entity.move(xDifference, yDifference);
        }
    }

    public double getRealX() {
        return realX;
    }

    public double getRealY() {
        return realY;
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
