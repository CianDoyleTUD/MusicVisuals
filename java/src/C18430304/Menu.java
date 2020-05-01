package C18430304;

import processing.core.*;
import ie.tudublin.*;

public class Menu extends Visual {
    
    MainVisual mv;
    int scrH;
    int scrW;
    int dropdowns = 0;
    int tab = 0;
    int menuH = 50;
    boolean enabled = false;

    public Menu(MainVisual mv)
    {
        this.mv = mv;
        scrH = this.mv.height;
        scrW = this.mv.width;
    }

    public void toggle() 
    {
        enabled = !enabled;
    }

    public void render()
    {
        
        mv.pushMatrix();

        mv.translate(0 - scrW, 0 - scrH);
        mv.stroke(140, 255, 255);
        mv.fill(140, 255, 255, 50);
        mv.rect(0, 0, scrW - 1, menuH);

        mv.fill(0, 255, 255, 255);
        mv.textSize(32);
        mv.text(this.tab, 10, 35); 

        for (int i = 0; i < dropdowns; i++) {

            mv.rect(0, (i * 50) + menuH, scrW - 1, 50);

        }

        mv.popMatrix();

        /*float posx = PApplet.map(mv.getAudioPlayer().position(), 0, mv.getAudioPlayer().length(), 0, 1000);
        mv.stroke(0,200,0);
        mv.line(posx, 0, posx, 100);*/
       
    }

}