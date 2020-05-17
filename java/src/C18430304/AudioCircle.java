package C18430304;

import processing.core.*;

public class AudioCircle {

    MainVisual mv;
    int cycle = 0;
    float cy = 0;
    float cx = 0;
    float cSize, cRadius, cxEdge, cyEdge;
    float cos, sin;
    float variance;
    float rotY;
    float spikeLen = 10;
    float pi = (float)Math.PI;
    float step = (2 * pi) / 360; // How accurate we are going to be, a line for every degree looks fine.
    int linesPerBand = (int)((2 * pi) / step) / 6;

    public AudioCircle(MainVisual mv)
    {
        this.mv = mv;
    }

    public void render()
    {

        if(cycle > 255) { cycle = 0; }

        mv.colorMode(PApplet.HSB);

        cSize = PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, cy) + 500; 
        cRadius = (cSize / 2);  
        
        mv.fill(0, 0, 0);
        
        // Main circle
        mv.circle(0, 0, cSize);

        cycle++;

        //Lines inside circle
        for (float theta = 0;  theta < 2 * pi; theta += step) { 
            // Co-ordinate of edge of circle at theta radians
            cxEdge = cRadius * (float)Math.cos(theta);
            cyEdge = cRadius * (float)Math.sin(theta); 

            int degree = ((int)PApplet.map(theta, 0, 2 * pi, 0, (int)((2 * pi) / step)));
            int bandNum = (int)PApplet.map(theta, 0, 2 * pi, 0, 6); // Each of the 6 audio bands has its own sixth of the circle
            int bandPeak = ((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand); // line which is the band peak for specific band
            
            // For creating a peak, which gradually decreases the further away a line is from the center of it's band
            if(bandPeak <= 0) 
            {
                variance = PApplet.map(bandPeak - degree, -30, 0, 0, (mv.bands[bandNum] / 3));
            }
            else {
                variance = PApplet.map(bandPeak - degree, 0, 32, 0, (mv.bands[bandNum] / 3));
            }
            // Handling both sides of peak, also adding random noise for aesthetics 
            if (  degree < bandPeak)   
            {
                spikeLen = ((mv.bands[bandNum] / 3) - variance) + (int)(Math.random() * 10); 
            }
            else 
            {
                spikeLen = ((mv.bands[bandNum] / 3) + variance) + (int)(Math.random() * 10);
            }

            mv.stroke(PApplet.map(theta, 0, 2 * pi, 0, 255), 255, 255); // Gradually shift colours as we traverse around circle
            
            // Cap the lines so they don't go further than the center of the circle or end up negative
            if(spikeLen < 0)
                spikeLen = (int)(Math.random() * 10); 

            if(spikeLen > cRadius) 
                spikeLen = cRadius;

            mv.pushMatrix();    

            rotY += 0.00001;

            mv.rotateZ(rotY);

            mv.line(cxEdge, cyEdge, (cRadius - spikeLen) * (float)Math.cos(theta), (cRadius - spikeLen) * (float)Math.sin(theta)); // Draw lines from edge to center based on size of band

            mv.popMatrix();

        }
  
    }

}