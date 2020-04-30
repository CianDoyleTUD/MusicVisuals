package C18430304;

import processing.core.*;
import ie.tudublin.*;

public class Stars extends Visual {

    MainVisual mv;
    float cx, cy;
    int starMax = 10;
    int cycle;
    int bgCycle = 127;
    float posX, posY;
    float rotY, rotX;

    Star[] stars = new Star[starMax];


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
            
            stars[i] = new Star();

        }

    }

    public void render() 
    {   

        rotY += 0.01;
        rotX += 0.01;

        //mv.background(bgCycle, 120, 255);
        
        if (cycle == 255) 
        {
            cycle = 0;
        }  
        else if (bgCycle == 255)
        {
            bgCycle = 0;
        }
        else {
            cycle++;
            bgCycle++;
        }

        for (int i = 0; i < starMax; i++) {

            if (stars[i].angX > cx || stars[i].angX < (0-cx) || stars[i].angY > cy || stars[i].angY < (0 - cy)) {
                stars[i].reset();
            }

            mv.pushMatrix();

            mv.translate(stars[i].angX, stars[i].angY, stars[i].angZ);
            mv.rotateY(rotY);
            mv.rotateX(rotX);
            mv.stroke(cycle, 255, 255, 150);
            mv.noFill();
            mv.sphere(50);     

            mv.popMatrix();

            stars[i].angX += stars[i].angX * (mv.getAmplitude() / 3);
            stars[i].angY += stars[i].angY * (mv.getAmplitude() / 3);  
            stars[i].angZ += stars[i].angZ * (mv.getAmplitude() / 3); 

        }

    }
}