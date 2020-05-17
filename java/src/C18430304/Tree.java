package C18430304;

import processing.core.PApplet;

public class Tree { // A tree fractal 

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
        
        h *= 0.66; // every branch is 2/3 the size of the last one

        if (h > 2) { // Keep drawing branches until they are smaller than 2 pixels.
          mv.pushMatrix();    
          mv.rotate(theta);   
          mv.line(0, 0, 0, -h); 
          mv.translate(0, -h);
          branch(h);      
          mv.popMatrix();   
          
          mv.pushMatrix();
          mv.rotate(-theta);
          mv.line(0, 0, 0, -h);
          mv.translate(0, -h);
          branch(h);
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
        // Drawing 4 trees 90 degrees from eachother, makes for a cool effect, albeit a bit intense on the cpu/gpu.
        branch(300); // 300 is initial branch size
        mv.rotate(pi/2);
        branch(300);
        mv.rotate(pi/2);
        branch(300);
        mv.rotate(pi/2);
        branch(300);

    }
}