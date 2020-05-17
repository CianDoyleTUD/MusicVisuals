package C18430304;

public class Menu { // Simple main menu with controls
    
    MainVisual mv;
    int scrH;
    int scrW;
    int menuH;
    int menuW;
    int tab = 0;

    public Menu(MainVisual mv)
    {
        this.mv = mv;
        scrH = this.mv.height;
        scrW = this.mv.width;
        menuH = scrH / 2;
        menuW = scrW / 2;
    }

    public void render()
    {
        
        mv.pushMatrix();

        mv.translate(0 - menuW/2, 0 - menuH/2);
        mv.stroke(140, 255, 255);
        mv.fill(140, 255, 255, 50);
        mv.rect(0, 0, menuW, menuH);

        mv.fill(0,0,255, 255);
        mv.textSize(25);
        mv.translate(0, 0);
        mv.text("Controls:\n\nArrow keys to cycle through visuals\n\nSpace bar to play the music\n\nEnjoy :)", menuW/6, menuH/4); 

        mv.popMatrix();
       
    }

}