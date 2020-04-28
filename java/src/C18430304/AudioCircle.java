package C18430304;

import processing.core.*;

public class AudioCircle {

    MainVisual mv;
    float cy = 0;
    float cx = 0;

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

        PApplet.println("::" + mv.getSmoothedAmplitude());
        
        mv.circle(cx, cy, PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, cy) + 500 );

    }

}