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
    int linesPerBand = (int)((2 * pi) / step) / 6;

    int[] totalBands = new int[6];

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

            float variance = degree + (((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand));
           

            spikeLen = ( (mv.bands[bandNum] / 3) + (variance / 5));// + (int)(Math.random() * 10);

            

            totalBands[bandNum]++;

            //PApplet.println("bandNum : " + bandNum);
            //PApplet.println("linesPerBand : " + linesPerBand);
            //PApplet.println("i : " + (int)PApplet.map(theta, 0, 2 * pi, 0, (int)((2 * pi) / step)));
            //PApplet.println("value: " + (((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand))     );

            mv.stroke(PApplet.map(theta, 0, 2 * pi, 0, 255), 255, 255);

            if (degree == ((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand))
            {
                mv.stroke(140, 255, 255);
            }

            mv.line(cxEdge, cyEdge, (cRadius + spikeLen) * (float)Math.cos(theta), (cRadius + spikeLen) * (float)Math.sin(theta));
            mv.line(0, 0, cxEdge, cyEdge);

        }
       
    }

}