package C18430304;

import processing.core.PApplet;

public class Stars { // Spherically represented stars which move from the center of the screen in an explosion of colour. A bit like the big bang.

    MainVisual mv;
    float cx, cy;
    int starMax = 120;
    int cycle;
    float posX, posY;
    float rotY, rotX;

    Star[] stars = new Star[starMax];

    public Stars(MainVisual mv)
    {
        this.mv = mv;
        this.initialize();
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;
        mv.sphereDetail(15);
    }

    public void initialize()
    {   

        for (int i = 0; i < starMax; i++) { // Create stars 
            
            stars[i] = new Star();

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

            if (stars[i].angX > cx || stars[i].angX < (0-cx) || stars[i].angY > cy || stars[i].angY < (0 - cy)) { // When spheres reach edge of screen
                stars[i].reset();
            }

            mv.pushMatrix();

            mv.translate(stars[i].angX, stars[i].angY, stars[i].angZ);
            mv.rotateY(rotY);
            mv.rotateX(rotX);
            mv.stroke(stars[i].colour, 255, 255, 150); // Each star has a unique outline to spice it up a bit
            mv.fill(cycle, 255, 255, 150);
            mv.scale(PApplet.map(mv.getSmoothedAmplitude(), 0, 200, 0, 100)); // Scale the spheres with volume
            mv.sphere(70);  
            
            mv.popMatrix();

            /*if (i != starMax - 1) // Lines between nth star to the n+1th star, actually doesn't look great so I'm commenting it out for now
            {
                //mv.stroke(stars[i].colour, 255, 255, 150);
                mv.stroke(cycle, 255, 255, 150);
                mv.line(stars[i].angX, stars[i].angY, stars[i].angZ, 0, 0, 0);
                mv.line(stars[i].angX, stars[i].angY, stars[i].angZ, stars[i+1].angX, stars[i+1].angY, stars[i+1].angZ);
            } */
            
            // Continue on the trajectory with speed that is related to the current volume of the song
            stars[i].angX += stars[i].angX * (mv.getAmplitude() / 3);
            stars[i].angY += stars[i].angY * (mv.getAmplitude() / 3);  
            stars[i].angZ += stars[i].angZ * (mv.getAmplitude() / 3); 

        }

     }

}