package C18430304;

import processing.core.PApplet;

public class Star { // A spherical star which floats around the screen
    
    float posX, posY;
    float theta;
    float pi = (float)Math.PI;
    float randAng;
    float angX, angY, angZ, rotY, rotX;
    int colour;
    
    public Star()
    {
        this.randAng = PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi); // Generate a random angle for the star to travel along
        this.angX = (float)Math.cos(randAng);
        this.angY = (float)Math.sin(randAng); 
        this.angZ = (float)Math.cos(PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi)); 
        this.colour = (int)(Math.random() * 255);
    }

    public void reset() 
    {
        randAng = PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi);
        angX = (float)Math.cos(randAng);
        angY = (float)Math.sin(randAng); 
        angZ = (float)Math.cos(PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi));
        this.colour = (int)(Math.random() * 255);
    }

}