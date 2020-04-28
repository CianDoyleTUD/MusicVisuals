package C18430304;

import processing.core.*;

public class Menu {
    
    MainVisual mv;
    int scrH;
    int scrW;
    boolean enabled = true;

    public Menu(MainVisual mv)
    {
        this.mv = mv;
        scrH = this.mv.height;
        scrW = this.mv.width;
    }

    public void toggle() {
        enabled = !enabled;
    }


    public void render()
    {

        mv.stroke(140, 255, 255);
        mv.fill(140, 255, 255, 50);
        mv.rect(0, 0, scrW - 1, 50);

        /*float posx = PApplet.map(mv.getAudioPlayer().position(), 0, mv.getAudioPlayer().length(), 0, 1000);
        mv.stroke(0,200,0);
        mv.line(posx, 0, posx, 100);*/
       
    }

}