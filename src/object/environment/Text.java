package object.environment;

import core.component.shape.TextShape;
import object.Registrable;

public class Text extends TextShape implements Registrable {

    public Text(double xPos, double yPos, String text) {
        super(xPos, yPos, text);
        register();
    }

    @Override
    public void register() {

    }

}
