package C18430304;

import processing.core.*;
import ie.tudublin.*;

public class Stars extends Visual {

    MainVisual mv;
    float cx, cy;
    int starMax = 100;
    float posX, posY;
    float theta;
    float pi = (float)Math.PI;
    float randAng;
    float angX, angY, angZ;

    float[] boxAngsX = new float[starMax];
    float[] boxAngsY = new float[starMax];

    public Stars(MainVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;
    }

    public void reset() 
    {
        for (int i = 0; i < starMax; i++) {

            boxAngsX[i] = 0;
            boxAngsY[i] = 0;

        }
    }

    public void render() 
    {   

        for (int i = 0; i < starMax; i++) {

            randAng = PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi);
            angX = (float)Math.cos(randAng);
            angY = (float)Math.sin(randAng); 

            if(boxAngsX[i] == 0) 
            {
                boxAngsX[i] = angX;
            }

            if(boxAngsY[i] == 0) 
            {
                boxAngsY[i] = angY;
            }

            mv.pushMatrix();
            mv.translate(cx + boxAngsX[i], cy + boxAngsY[i], angZ); 
            //mv.rotateY(0.5f);
            mv.stroke(140, 255, 255);
            mv.fill(140, 255, 255, 255);
            mv.box(5);
            boxAngsX[i] += boxAngsX[i] / 100;
            boxAngsY[i] += boxAngsY[i] / 100;
            angZ += angZ / 100;
            mv.popMatrix();

        }
      
    }
}