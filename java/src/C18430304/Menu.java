package C18430304;

public class Menu {
    
    MainVisual mv;
    int scrH;
    int scrW;
    int menuH;
    int menuW;
    int dropdowns = 0;
    int tab = 1;

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

        mv.fill(111, 255, 255, 255);
        mv.textSize(32);
        mv.text("Enter", menuW/2, menuH/2); 

        for (int i = 0; i < dropdowns; i++) {

            //mv.rect(0, (i * 50) + menuH, scrW - 1, 50);

        }

        mv.popMatrix();
       
    }

}