package C18430304;

import processing.core.*;

public class AudioCircle {

    MainVisual mv;
    float cy = 0;
    float cx = 0;
    float cSize;
    float cRadius;
    float cos;
    float sin;
    float xAng;
    float yAng;

    public AudioCircle(MainVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;
    }

    public void render()
    {

        mv.colorMode(PApplet.HSB);
        mv.fill(255, 255, 255);
        mv.stroke(120, 255, 255);

        cSize = PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, cy) + 500;
        cRadius = cSize / 2;

        // Main circle
        mv.circle(cx, cy, cSize);

        //Lines on circle
        for (int i = 0; i <= 360; i++) {

            xAng = cx + cRadius * (float)Math.cos(i); // -1 -> 0 -> 1
            yAng = cy + cRadius * (float)Math.sin(i); // -1 -> 0 -> 1
            
  
            mv.line(cx, cy, xAng, yAng);

        }
       
    }

}