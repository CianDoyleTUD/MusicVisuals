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
# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

