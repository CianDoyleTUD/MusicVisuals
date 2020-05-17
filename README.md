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
will change size depending on how much bass there is for example. A lot of math was used in this program to calculate angles and trajectories. There is a fair bit of circular geometry used to create the audio bands visualiser.
# What I am most proud of in the assignment
I am probably most proud of my use of mathematics to create visually pleasing effects. Mathematics is not very interesting to me personally, but I found it was needed a fair bit to create 3d graphics. I found myself actually becoming quite interested in the formulas related to drawing circles, etc.
# Youtube demonstration

[![YouTube](http://img.youtube.com/vi/N5t7hB70aVk/0.jpg)](https://www.youtube.com/watch?v=N5t7hB70aVk)

