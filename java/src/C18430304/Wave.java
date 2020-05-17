package C18430304;

import processing.core.PApplet;

public class Wave { // A wavy effect that looks similar to the ocean

    MainVisual mv;
    int rows, cols;
    int step = 20;
    float[][] points;
    float cycle = 0;
    float xOff, yOff;

    public Wave(MainVisual mv)
    {
        this.mv = mv; 
        cols = (mv.width + 200)/ step;
        rows = (mv.height  + 200) / step;
        points = new float[cols][rows];
    }

    public void render()
    {   

        mv.translate(0,0); 
        mv.rotateX((float)Math.PI/3); // Rotate grid about the centre of screen
        mv.translate(-130-mv.width/2, -200-mv.height/2);

        cycle-=0.01;
        yOff = cycle; // For bringing the effect towards the screen

        for(int y = 0; y < rows; y++)
        {
            xOff = 0;
            for(int x = 0; x < cols; x++)
            {
                points[x][y] = PApplet.map(mv.noise(xOff, yOff), 0, 1, 0, 150); // Procedurally create wave-like terrain
                xOff += 0.2;
            }
            yOff += 0.05;
        }
        // Create a mesh grid
        for(int y = 0; y < rows-1; y++) 
        {
            mv.beginShape(PApplet.TRIANGLE_STRIP);
            for(int x = 0; x < cols; x++)
            {
                mv.stroke(145, 255, 255);
                mv.noFill();
                mv.vertex(x*step, y*step, points[x][y]-200);
                mv.vertex(x*step, (y+1)*step, points[x][y+1]-200);
            }
            mv.endShape();
        }
    }
}