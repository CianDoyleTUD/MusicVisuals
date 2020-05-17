package C18430304;

import processing.core.PApplet;

public class Spiral { // Infinitely looping spiral effect made up of spheres

    MainVisual mv;
    float theta;  
    float a;
    float pi = (float)Math.PI;
    float cycle;

    public Spiral(MainVisual mv) 
    {
        this.mv = mv;
    }

    public void spiral(float h) {
        
        h *= 1.2;

        if (h < 200) { // Spiral while spheres are below a certain size
          mv.pushMatrix();    
          mv.rotate(theta);  
          mv.sphere(h/6);  
          mv.translate(0, h); 
          spiral(h);
          mv.popMatrix();    
          
        }

    }

    void render() {

        cycle += 0.05;

        if (cycle > 255)
            cycle = 0;

        mv.fill(cycle, 255, 255, 150);
        mv.stroke(cycle+20, 255, 255);

        a += 0.25;
        theta = PApplet.radians(a);

        spiral(5);
        mv.rotate(pi/4);
        spiral(5);
        mv.rotate(pi/4);
        spiral(5);
        mv.rotate(pi/4);
        spiral(5);
        mv.rotate(pi/4);
        spiral(5);
        mv.rotate(pi/4);
        spiral(5);
        mv.rotate(pi/4);
        spiral(5);
        mv.rotate(pi/4);
        spiral(5);
    
    }
}