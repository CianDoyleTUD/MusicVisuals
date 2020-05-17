package C18430304;

import processing.core.PApplet;

public class Tree {

    MainVisual mv;
    float theta;  
    float a;
    float pi = (float)Math.PI;
    float branchSize;
    float cycle;

    public Tree(MainVisual mv) 
    {
        this.mv = mv;
    }

    public void branch(float h) {
        
        h *= 0.66;

        if (h > 2) {
          mv.pushMatrix();    // Save the current state of transformation (i.e. where are we now)
          mv.rotate(theta);   // Rotate by theta
          mv.line(0, 0, 0, -h);  // Draw the branch
          mv.translate(0, -h); // Move to the end of the branch
          branch(h);       // Ok, now call myself to draw two new branches!!
          mv.popMatrix();     // Whenever we get back here, we "pop" in order to restore the previous matrix state
          
          // Repeat the same thing, only branch off to the "left" this time!
          mv.pushMatrix();
          mv.rotate(-theta);
          mv.line(0, 0, 0, -h);
          mv.translate(0, -h);
          branch(h);
          mv.popMatrix();
        }

    }

    public void fractal(float h) {
        
        h *= 1.2;

        if (h < 200) {

          mv.pushMatrix();   
          mv.rotate(theta);   
          mv.sphere(h/5);  
          mv.translate(0, h);
          fractal(h);
          mv.popMatrix();     
          
        }

    }

    void render() {

        cycle += 0.05;

        if (cycle > 255)
            cycle = 0;

        mv.stroke(cycle+20, 255, 255);

        a += 0.25;
        theta = PApplet.radians(a);

        branch(300);
        mv.rotate(pi/2);
        branch(300);
        mv.rotate(pi/2);
        branch(300);
        mv.rotate(pi/2);
        branch(300);
        
        mv.rotateX(0.1f);
    }
}