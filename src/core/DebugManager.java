package core;

import core.component.shape.CustomShape;
import core.component.shape.TextShape;

import java.awt.*;
import java.util.HashMap;

public class DebugManager {

    private HashMap<String, TextShape> debugs = new HashMap<>();

    public void addDebug(String name, Object object){
        addDebug(name, object, false);
    }

    public void addDebug(String name, Object object, boolean showUpperCase){
        if(!GameMain.core.getSettings().isDebug())
            return;
        TextShape text = (TextShape) new TextShape(5, 30+(20.0*(debugs.size()+1)), showUpperCase ? name.toUpperCase() : name+": "+object).setFont(new Font("default", Font.PLAIN, 17)).setSticky(false).setColor(Color.RED);
        debugs.put(name, text);
    }

    public void update(String name, Object object){
        TextShape text = debugs.get(name);
        text.setText(name+": "+object);
        text.setFont(new Font("default", Font.BOLD, 17));
    }


}
