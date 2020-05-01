package C18430304;

import processing.core.*;

public class Wave {

    MainVisual mv;

    public Wave(MainVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        float gap = 20;
        int linesPerBand = (int)(mv.width / gap) / 6;
       

        for(int i = 0 ; i < mv.width / gap ; i ++)
        {
            
            mv.stroke(255, 255, 255);

            int bandNum = (int)PApplet.map(i, 0, mv.width / gap, 0, 6);

            PApplet.println(((linesPerBand / 2) * (bandNum + 1)));


            /*

            AT 0: i == 5
            AT 1: i == 15
            AT 2: i == 25


            */
            if (i == ((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand))
            {
                mv.stroke(140, 255, 255);
                
                //mv.rect(200, 200, 200, 200);
            }


            mv.line(i * gap, mv.height, i * gap, (mv.height - mv.bands[bandNum] * 0.2f) - 40);
            
            //(int)PApplet.map(i, 0, mv.width / gap, 0, 6);
            mv.text(((linesPerBand / 2) * (bandNum + 1)), i * gap, (mv.height - mv.bands[bandNum] * 0.2f) - 40); 
            mv.text(i, i * gap, (mv.height - mv.bands[bandNum] * 0.2f) - 50); 
            mv.text(((linesPerBand / 2) + bandNum) + (bandNum * linesPerBand), i * gap, (mv.height - mv.bands[bandNum] * 0.2f) - 60); 

        }
    }
}