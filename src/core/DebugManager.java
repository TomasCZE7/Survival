package core;

import object.ObjectManager;
import object.ObjectToRender;
import object.enviroment.Text;

import java.awt.*;
import java.util.HashMap;

public class DebugManager {

    private HashMap<String, Text> debugs = new HashMap<>();

    public void addDebug(String name, Object object){
        addDebug(name, object, false);
    }

    public void addDebug(String name, Object object, boolean showUpperCase){
        if(!Core.DEBUG)
            return;
        Text text = new Text(5, 30+(20.0*(debugs.size()+1)), Color.RED, showUpperCase ? name.toUpperCase() : name+": "+object,
                new Font("default", Font.PLAIN, 17), true);
        debugs.put(name, text);
    }

    public void update(String name, Object object){
        Text text = debugs.get(name);
        text.setText(name+": "+object);
        text.setFont(new Font("default", Font.BOLD, 17));
    }


}
