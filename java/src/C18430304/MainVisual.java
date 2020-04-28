package C18430304;

import ie.tudublin.*;

public class MainVisual extends Visual {
    AudioCircle ac;
    Menu options;
    Stars stars;

    public void settings()
    {
        size(1280, 900, P3D);
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
          
        loadAudio("heroplanet.mp3");   
        getAudioPlayer().mute();
        ac = new AudioCircle(this);
        options = new Menu(this);
        stars = new Stars(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
        if (keyCode == UP)
        {
           options.toggle();
           stars.reset();
        }
        if (keyCode == RIGHT)
        {
           options.tab++;
        }
        if (keyCode == LEFT && options.tab > 0)
        {
           options.tab--;
        }
    }

    public void draw()
    {
        background(0);

        calculateAverageAmplitude();
        
        switch(options.tab) {
            case 0:
                ac.render();
                break;
            case 1:
                stars.render();
                break;
            default:
                break;
        }

        if (options.enabled) {
            options.render();
        }
    
    }
}