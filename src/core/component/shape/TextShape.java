package core.component.shape;

import core.Core;
import core.GameMain;
import object.GameObject;
import object.Registrable;

import java.awt.*;

public class TextShape extends CustomShape implements Registrable{

    private String text = "";
    private Font font;

    public TextShape(double xPos, double yPos, String text) {
        super(xPos, yPos);
        this.text = text;
        this.font = Core.defaultFont;
        register();
    }

    public TextShape setFont(Font font) {
        this.font = font;
        return this;
    }

    @Override
    public Shape getShape() {
        return null;
    }


    @Override
    public void render(Graphics2D g) {
        g.setColor(getColor());
        g.setFont(getFont());
        g.drawString(text, (float) getXPos(), (float) getYPos());
        g.setFont(Core.defaultFont);
    }

    public String getText() {
        return text;
    }

    public TextShape setText(String text) {
        this.text = text;
        return this;
    }

    public Font getFont() {
        return font;
    }

    @Override
    public void register() {
        GameMain.core.getObjectManager().addText(this);
    }
}
