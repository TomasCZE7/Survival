package object.environment;

import core.Core;
import core.component.shape.CustomShape;
import object.GameObject;

import java.awt.*;

public class Text /*extends GameObject */ {
/*
    private String text;
    private Font font;
    private boolean fixedOnScreen;

    public Text(double x, double y, Color color, String text, boolean fixedOnScreen) {
        super(x, y, color, 0, 0);
        this.text = text;
        this.fixedOnScreen = fixedOnScreen;
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(getColor());
        if (this.font != null) {
            g.setFont(font);
        }
        g.drawString(text, (int) getX(), (int) getY());
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
*/
}