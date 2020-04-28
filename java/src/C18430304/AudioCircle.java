package C18430304;

import processing.core.*;

public class AudioCircle {

    MainVisual mv;
    int cycle = 0;
    float cy = 0;
    float cx = 0;
    float cSize;
    float cRadius;
    float cos;
    float sin;
    float cxEdge;
    float cyEdge;
    float spikeLen = 10;
    float pi = (float)Math.PI;
    float step = (2 * pi) / 360;
    float variance = 50;

    public AudioCircle(MainVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cx = this.mv.width / 2;
    }

    public void render()
    {

        if(cycle > 255) { cycle = 0; }

        mv.colorMode(PApplet.HSB);
        
        //mv.stroke(120, 255, 255);

        cSize = PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, cy) + 500;
        cRadius = (cSize / 2);  
        
        mv.fill(cycle, 255, 255, 50);
        
        // Main circle
        mv.circle(cx, cy, cSize);

        cycle++;

        //Lines on circle
        for (float theta = 0;  theta < 2 * pi; theta += step) {

            cxEdge = cx + cRadius * (float)Math.cos(theta);
            cyEdge = cy + cRadius * (float)Math.sin(theta); 
            
            variance = mv.getSmoothedAmplitude() * 400;

            spikeLen = PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 1500) + (float)(Math.random() * variance);

            mv.stroke(PApplet.map(theta, 0, 2 * pi, 0, 255), 255, 255);

            mv.line(cxEdge, cyEdge, cx + (cRadius + spikeLen) * (float)Math.cos(theta), cy + (cRadius + spikeLen) * (float)Math.sin(theta));

        }
       
    }

}