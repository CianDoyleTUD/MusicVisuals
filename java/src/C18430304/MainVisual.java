package C18430304;

import ie.tudublin.*;

public class MainVisual extends Visual {
    AudioCircle ac;
    int effect = 0;

    public void settings()
    {
        size(1024, 720);
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
            
        loadAudio("heroplanet.mp3");   
        
        ac = new AudioCircle(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            effect++;
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(100);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        
        if (effect == 1) {
            ac.render();  
        }
    }
}