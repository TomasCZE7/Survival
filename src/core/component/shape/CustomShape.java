package core.component.shape;

import javax.swing.*;
import java.awt.*;

public abstract class CustomShape {

    private double xPos, yPos, width, height;
    private Color color;
    private boolean filled;

    public CustomShape(double xPos, double yPos, double width, double height, Color color, boolean filled){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
        this.filled = filled;
    }

    public CustomShape(double xPos, double yPos, double width, double height, Color color){
        this(xPos, yPos, width, height, color, false);
    }

    public CustomShape(double xPos, double yPos, double width, double height){
        this(xPos, yPos, width, height, false);
    }


    public CustomShape(double xPos, double yPos, double width, double height, boolean filled){
        this(xPos, yPos, width, height, Color.BLACK, filled);
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
}
