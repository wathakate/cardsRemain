package userInterface;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UserInterface {
    BufferedImage image;
    GamePanel gp;
    public UserInterface(GamePanel gp){
        this.gp = gp;
        getUiImage();
    }
    public void getUiImage(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/ui/testui.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
        //image = gp.stage.backDrop;
    }
    public void draw(Graphics2D g){
        g.drawImage(image, 0, 0, gp.screenWidth, gp.screenHeight, null);
        g.setFont(g.getFont().deriveFont(Font.PLAIN, 48F));
        g.setColor(Color.white);
        g.draws
    }
}
