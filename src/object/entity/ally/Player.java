package object.entity.ally;

import core.GameMain;
import object.entity.Entity;
import object.environment.PlayerMovementArea;
import object.Coordinates;
import object.environment.Text;

import java.awt.*;
import java.awt.geom.*;

public class Player extends Entity {

    public double realX, realY;
    public PlayerMovementArea area;

    public Player(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y, color, width, height, fill);
        realX = getX();
        realY = getY();
        area = new PlayerMovementArea();

    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getX(), getY(), getHeight(), getWidth());
    }

    @Override
    public void tick() {
        super.tick();
        checkCollision();
        checkMovement();
    }

    @Override
    public void die() {
      //  GameMain.restart();
    }

    private void checkCollision(){

    }

    private void checkMovement(){
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

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        Shape circle = new Ellipse2D.Double(10, 10, 350, 350);
        g.draw(circle);
    }

    public double getRealX() {
        return realX;
    }

    public double getRealY() {
        return realY;
    }

    @Override
    public double getDamage() {
        return 3;
    }

    @Override
    public double getMaxHealth() {
        return 100;
    }
}
