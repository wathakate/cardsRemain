package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UserInterface {
    BufferedImage image;
    public UserInterface(){
        getUiImage();
    }
    public void getUiImage(){
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/res/ui/testui.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g){
        g.drawImage(image, 0, 0, 1024, 576, null);
    }
}
