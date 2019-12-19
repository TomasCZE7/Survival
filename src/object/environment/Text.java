package object.environment;

import core.Core;
import core.component.shape.CustomShape;
import object.DimensionalObject;

import java.awt.*;

public class Text extends DimensionalObject {

    private String text;
    private Font font;
    private boolean fixedOnScreen;

    public Text(double x, double y, Color color, String text, boolean fixedOnScreen) {
        super(x, y, color, 0, 0);
        this.text = text;
        this.fixedOnScreen = fixedOnScreen;
    }

    public Text(double x, double y, Color color, String text, Font font, boolean fixedOnScreen) {
        this(x, y, color, text, fixedOnScreen);
        this.font = font;
    }

    public Text(double x, double y, Color color, String text) {
        super(x, y, color, 0, 0, false);
    }

    public Text(double x, double y, Color color, String text, Font font) {
        this(x, y, color, text, font, false);
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

    public boolean isFixedOnScreen() {
        return fixedOnScreen;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return font;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public CustomShape getCustomShape() {
        return null;
    }
}
