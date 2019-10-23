package object.template;

import java.awt.*;

public abstract class DimensionalObject extends BasicObject implements ObjectToShow {

    private double width, height;
    private Color color;

    private boolean fill;

    public DimensionalObject(double x, double y, Color color, double width, double height, boolean fill) {
        super(x, y);
        this.color = color;
        this.width = width;
        this.height = height;
        this.fill = fill;
    }

    public DimensionalObject(double x, double y, Color color, Dimension size, boolean fill) {
        this(x, y, color, size.getWidth(), size.getHeight());
    }


    public DimensionalObject(double x, double y, Color color, double width, double height) {
        this(x, y, color, width, height, false);
    }

    public DimensionalObject(double x, double y, Color color, Dimension size) {
        this(x, y, color, size.getWidth(), size.getHeight(), false);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(getColor());
        if(isFill())
            g.fill(getShape(g));
        else
            g.draw(getShape(g));
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public boolean isFill() {
        return fill;
    }

    public void teleport(double xDestination, double yDestination){
        setX(xDestination);
        setY(yDestination);
    }

}