package object.enviroment;

import core.Core;
import object.DimensionalObject;

import java.awt.*;

public class Text extends DimensionalObject {

    private String text;
    private Font font;

    public Text(double x, double y, Color color, String text) {
        super(x, y, color, 0, 0);
        this.text = text;
    }

    public Text(double x, double y, Color color, String text, Font font) {
        this(x, y, color, text);
        this.font = font;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(getColor());
        if(this.font != null) {
            g.setFont(font);
        }
        g.drawString(text, (int)getX(), (int)getY());
        g.setFont(Core.defaultFont);
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Shape getShape(Graphics2D g) {
        return null;
    }
}
