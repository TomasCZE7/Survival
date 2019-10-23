package object.enviroment;

import object.template.BasicObject;
import object.template.DimensionalObject;
import object.template.MovingObject;
import object.template.ObjectToShow;

import java.awt.*;

public class Text extends MovingObject {

    private String text;

    public Text(double x, double y, Color color, String text) {
        super(x, y, color, 0, 0);
        this.text = text;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(getColor());
        g.drawString(text, (int)getX(), (int)getY());
    }

    @Override
    public Shape getShape(Graphics2D g) {
        return null;
    }
}
