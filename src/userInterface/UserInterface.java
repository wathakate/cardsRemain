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
        //ui
        g.drawImage(image, 0, 0, gp.screenWidth, gp.screenHeight, null);
        g.setColor(Color.white);
        //carta
        g.drawImage(gp.stage.getPlayer().sp[gp.stage.getPlayer().selection].getCard(), 460, 494, 105, 131,null);
        // Nivel
        g.setFont(new Font("MS Gothic",Font.PLAIN, 24));
        g.drawString("Nivel: "+gp.stage.name,100, 250);
        // Puntaje
        g.setFont(new Font("MS Gothic",Font.PLAIN, 24));
        g.drawString("Puntaje:",800, 250);
        g.setFont(new Font("MS Gothic",Font.PLAIN, 48));
        g.drawString(Integer.toString(gp.score),750, 300);
    }
}
