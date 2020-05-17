package C18430304;

import processing.core.PApplet;

public class Spiral {

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

        if (h < 200) {
          mv.pushMatrix();    // Save the current state of transformation (i.e. where are we now)
          mv.rotate(theta);   // Rotate by theta
          mv.sphere(h/5);  // Draw the branch
          mv.translate(0, h); // Move to the end of the branch
          spiral(h);
          mv.popMatrix();     // Whenever we get back here, we "pop" in order to restore the previous matrix state
          
        }

    }

    void render() {

        cycle += 0.05;

        if (cycle > 255)
            cycle = 0;

        mv.fill(cycle, 255, 255);
        mv.stroke(cycle+20, 255, 255);

        a += 0.25;
        theta = PApplet.radians(a);

        spiral(5);
        mv.rotate(pi/2);
        spiral(5);
        mv.rotate(pi/2);
        spiral(5);
        mv.rotate(pi/2);
        spiral(5);
    
    }
}