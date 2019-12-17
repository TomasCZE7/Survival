package helper;

import core.Core;
import core.GameMain;
import object.entity.ai.AI;
import object.entity.ai.BasicZombie;

import java.awt.*;
import java.util.Random;

public class EnvironmentGenerator {

    public Random random;

    public EnvironmentGenerator(){
        this.random = new Random();
    }

    public double[] getRandomLocationOnScreen(){
        double randomX = GameMain.core.getSettings().getWidth() * random.nextDouble();
        double randomY =  GameMain.core.getSettings().getHeight() * random.nextDouble();
        return new double[] {randomX, randomY};
    }

    public void generateAI(int count){
        for(int i = 0; i <= count; i++){
            double[] random = getRandomLocationOnScreen();
            new BasicZombie(random[0], random[0], Color.RED, 30, 30);
        }
    }

}
