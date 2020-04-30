package C18430304;

import processing.core.*;
import ie.tudublin.*;

public class Stars extends Visual {

    MainVisual mv;
    float cx, cy;
    int starMax = 50;
    int cycle = 0;
    float posX, posY;
    float theta;
    float pi = (float)Math.PI;
    float randAng;
    float angX, angY, angZ, rotY, rotX;
    float timer = 0;

    float[] boxAngsX = new float[starMax];
    float[] boxAngsY = new float[starMax];
    

    public Stars(MainVisual mv)
    {
        this.mv = mv;
        this.initialize();
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;

    }

    public void initialize()
    {   

        for (int i = 0; i < starMax; i++) { 

            boxAngsX[i] = 0;
            boxAngsY[i] = 0;

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

        }

    }

    public void render() 
    {   

        rotY += 0.01;
        rotX += 0.01;
        
        if (cycle == 255) 
        {
            cycle = 0;
        }
        else {
            cycle++;
        }

        for (int i = 0; i < starMax; i++) {

            mv.pushMatrix();

            mv.translate(cx + boxAngsX[i], cy + boxAngsY[i], angZ);
            mv.rotateY(rotY);
            mv.rotateX(rotX);
            mv.stroke(cycle, 255, 255, 50);
            //mv.stroke(140, 255, 255);
            mv.fill(0,0,0);
            mv.box(200);   

            mv.popMatrix();

            boxAngsX[i] += boxAngsX[i] / 100;
            boxAngsY[i] += boxAngsY[i] / 100;

        }


    }
}