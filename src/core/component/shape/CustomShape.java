package core.component.shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class CustomShape {

    private double xPos, yPos, width, height;
    private Color color;
    private boolean filled;
    //Should the shape be attached to the screen after player being moved outside its area?
    private boolean sticky;

    public CustomShape(double xPos, double yPos, double width, double height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK;
        this.filled = false;
        this.sticky = false;
    }

    public CustomShape(double xPos, double yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = Color.BLACK;
        this.filled = false;
        this.sticky = false;
    }

    public CustomShape setSticky(boolean sticky) {
        this.sticky = sticky;
        return this;
    }

    public CustomShape setColor(Color color) {
        this.color = color;
        return this;
    }

    public CustomShape setFilled(boolean filled) {
        this.filled = filled;
        return this;
    }


    public abstract Shape getShape();

    public void draw(Graphics2D g){
        g.setColor(getColor());
        if (isFilled()){
            g.fill(getShape());
        } else {
            g.draw(getShape());
        }
    }

    public void render(Graphics2D g){
        draw(g);
    }

    public Point2D getPositionPoint(){
        return new Point2D.Double(getYPos(), getXPos());
    }

    public Point2D getSizePoint(){
        return new Point2D.Double(getWidth(), getHeight());
    }

    public double getWidth() {
        return width;
    }


    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public Color getColor() {
        return color;
    }

    public double getHeight() {
        return height;
    }

    public boolean isFilled() {
        return filled;
    }

    public boolean isSticky() {
        return sticky;
    }
}
