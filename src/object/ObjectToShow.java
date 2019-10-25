package object;

import java.awt.*;

public interface ObjectToShow {

    void render(Graphics2D g);
    void tick();
    Shape getShape(Graphics2D g);

}
