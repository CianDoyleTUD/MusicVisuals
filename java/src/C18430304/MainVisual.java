package C18430304;

import ie.tudublin.*;
import processing.core.PApplet;

public class MainVisual extends Visual {

    AudioCircle ac;
    Menu options;
    Stars stars;
    float angle;
    float rotY;
    float[] bands;

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
          
        loadAudio("letgo.mp3");   
        ac = new AudioCircle(this);
        options = new Menu(this);
        stars = new Stars(this);
        colorMode(PApplet.HSB);

    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            //getAudioPlayer().mute();
        }
        if (keyCode == UP)
        {
           options.toggle();
           stars.initialize();
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
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();

        bands = getSmoothedBands();

        rotY += 0.01;   

        translate(width / 2, height / 2, 0);

        PApplet.println(frameRate);
        
        switch(options.tab) {
            case 0:
                rotateY(rotY);
                stars.render();
                break;
            case 1:
                ac.render();
                break;
            default:
                break;
        }

        if (options.enabled) {
            options.render();
        }
    
    }
}