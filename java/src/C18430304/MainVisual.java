package C18430304;

import ie.tudublin.*;
import processing.core.PApplet;

public class MainVisual extends Visual {

    AudioCircle ac;
    Menu mainMenu;
    Stars stars;
    Wave waves;
    Tree tree;
    Spiral spiral;
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
          
        loadAudio("math.mp3");   
        ac = new AudioCircle(this);
        mainMenu = new Menu(this);
        stars = new Stars(this);
        waves = new Wave(this); 
        tree = new Tree(this);
        spiral = new Spiral(this);
        colorMode(PApplet.HSB);

        getAudioPlayer().cue(0);
        getAudioPlayer().play();
        getAudioPlayer().mute();

    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            getAudioPlayer().mute();
        }
        if (keyCode == UP)
        {
           stars.initialize();
           getAudioPlayer().skip(5000);
        }
        if (keyCode == RIGHT)
        {
            mainMenu.tab++;
        }
        if (keyCode == LEFT && mainMenu.tab > 0)
        {
            mainMenu.tab--;
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
        
        switch(mainMenu.tab) {
            case 0:
                rotateY(rotY);
                rotateX(rotY);
                stars.render();
                break;
            case 1:
                ac.render();
                break;
            case 2:
                tree.render();
                break;
            case 3:
                spiral.render();
                break;
            default:
                break;
        }
    
    }
}