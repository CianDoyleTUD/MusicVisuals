package C18430304;

import processing.core.*;

public class Star {
    
    float posX, posY;
    float theta;
    float pi = (float)Math.PI;
    float randAng;
    float angX, angY, angZ, rotY, rotX;
    
    public Star()
    {
        this.reset();
    }

    public void reset() 
    {

        randAng = PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi);
        angX = (float)Math.cos(randAng);
        angY = (float)Math.sin(randAng); 
        angZ = (float)Math.cos(PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi));

    }

}