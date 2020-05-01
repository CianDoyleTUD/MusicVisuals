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
    float variance;
    float rotY;
    float spikeLen = 10;
    float pi = (float)Math.PI;
    float step = (2 * pi) / 360;
    int linesPerBand = (int)((2 * pi) / step) / 6;

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
        
        mv.fill(0, 0, 0);
        
        // Main circle
        mv.circle(0, 0, cSize);

        cycle++;

        //Lines on circle
        for (float theta = 0;  theta < 2 * pi; theta += step) {

            cxEdge = cRadius * (float)Math.cos(theta);
            cyEdge = cRadius * (float)Math.sin(theta); 

            int degree = ((int)PApplet.map(theta, 0, 2 * pi, 0, (int)((2 * pi) / step)));
            int bandNum = (int)PApplet.map(theta, 0, 2 * pi, 0, 6); 

            if(((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand)  <= 0 )
            {
                variance = PApplet.map((((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand)) - degree, -29, 0, 0, (mv.bands[bandNum] / 8));
            }
            else {
                variance = PApplet.map((((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand)) - degree, 0, 31, 0, (mv.bands[bandNum] / 8));
            }

            if (  degree < ((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand))   
            {
                spikeLen = ((mv.bands[bandNum] / 8) - variance) + (int)(Math.random() * 5);
            }
            else 
            {
                spikeLen = ((mv.bands[bandNum] / 8) + variance) + (int)(Math.random() * 5);
            }

            mv.stroke(PApplet.map(theta, 0, 2 * pi, 0, 255), 255, 255);

            mv.pushMatrix();    

            rotY += 0.00001;
            mv.rotateZ(rotY);

            mv.line(cxEdge, cyEdge, (cRadius - spikeLen) * (float)Math.cos(theta), (cRadius - spikeLen) * (float)Math.sin(theta));

            mv.popMatrix();

        }
       
    }

}