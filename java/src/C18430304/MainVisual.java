package C18430304;

import ie.tudublin.*;

public class MainVisual extends Visual {
    AudioCircle ac;
    Menu options;

    public void settings()
    {
        size(1280, 900);
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
        }
    }

    public void draw()
    {
        background(0);

        calculateAverageAmplitude();
        
        ac.render();  

        if (options.enabled) {
            options.render();
        }
    
    }
}