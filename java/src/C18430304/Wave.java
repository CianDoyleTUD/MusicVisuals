package C18430304;

import processing.core.*;

public class Wave {

    MainVisual mv;
    int rows, cols;
    int scale = 20;

    public Wave(MainVisual mv)
    {
        this.mv = mv; 
        cols = mv.width / scale;
        rows = mv.height / scale;

    }

    public void render()
    {   

        mv.translate(0,0);
        mv.rotateX((float)Math.PI/3);
        mv.translate(-mv.width/2, -mv.height/2);
        for(int x = 0; x < cols; x++)
        {
            mv.beginShape(PApplet.TRIANGLE_STRIP);
            for(int y = 0; y < rows; y++)
            {
                mv.stroke(195, 100, 100);
                mv.noFill();
                mv.vertex(x*scale, y*scale);
                mv.vertex((x+1)*scale, y*scale);
            }
            mv.endShape();
        }
    }
}