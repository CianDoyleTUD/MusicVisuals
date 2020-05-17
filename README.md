# Music Visualiser Project

Name: Cian Doyle

Student Number: C18430304

# Description of the assignment
For this assignment, I decided to create some aesthetically pleasing visuals to enjoy while listening to music.
I created visuals which are affected by the music being played, and some which are not. The list of visuals is:
- An audio band visualiser, which reacts to the audio frequencies and volume.
- A visual which implodes stars from the centre of the screen at a speed relative to how loud the music is
- A set of spiral spheres which infinitely loop 
- A visual composed of recursive fractal trees which infinitely loop
- A simulated low poly ocean which uses perlin noise

# Instructions
Simply compile the program and use space to begin playing the song. I have left it to play the song provided, however 
you can use other songs by adding them to the data folder and changing line 27 of MainVisual.java to
``` 
loadAudio("filename.mp3");
```
# How it works
This program works in Java with the use of the Processing library for drawing graphics to the screen, 
in conjunction with the [Minim library](https://github.com/ddf/Minim), A Java audio library, designed to be used with Processing. This is what I used to manipulate the graphics to achieve things such as an audio band visualiser which 
will change size depending on how much bass there is. The inner lines of the circle are representing 6 different audio bands and how active they are. This effect is best noticed on a song with a big bass drop or dramatic change in sound.

The stars effect was achieved by creating 120 objects which each have a random trajectory from the centre, calculated as such:
```
public Star()
    {
        this.randAng = PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi); // Generate a random angle for the star to travel along
        this.angX = (float)Math.cos(randAng);
        this.angY = (float)Math.sin(randAng); 
        this.angZ = (float)Math.cos(PApplet.map((float)Math.random(), 0, 1, 0, 2 * pi)); 
        this.colour = (int)(Math.random() * 255);
    }
```
The speed of the stars is effected by the volume of the song:
```
stars[i].angX += stars[i].angX * (mv.getAmplitude() / 3);
stars[i].angY += stars[i].angY * (mv.getAmplitude() / 3);  
stars[i].angZ += stars[i].angZ * (mv.getAmplitude() / 3);
```
The tree fractal and spiral effects are not affected by the music. They are simply recursive functions which draw
shapes but look nice in my opinion. 

The ocean-like effect was created with perlin noise. I created a grid mesh with a custom shape. I then randomised the height of the grid mesh with noise
```
points[x][y] = PApplet.map(mv.noise(xOff, yOff), 0, 1, 0, 150);
```
This gives an ocean-like terrain and to move it towards the screen I increased the yOff and xOff values to shift the pattern, giving the effect of movement of the camera, hence why it can be infinitely generated.
# What I am most proud of in the assignment
I am probably most proud of my use of mathematics to create visually pleasing effects. Mathematics is not very interesting to me personally, but I found it was needed a fair bit to create 3d graphics. I found myself actually becoming quite interested in the formulas related to drawing circles, etc.
# Youtube demonstration

[![YouTube](http://img.youtube.com/vi/N5t7hB70aVk/0.jpg)](https://www.youtube.com/watch?v=N5t7hB70aVk)

