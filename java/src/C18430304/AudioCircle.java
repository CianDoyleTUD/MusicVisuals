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
        
    }

}