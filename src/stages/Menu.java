package stages;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu extends Stage{
    JButton continuar;
    JButton seleccionar;
    BufferedImage logo;

    public Menu(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        backColor = Color.black;
        gp.updatePanel(backColor);
        gp.setLayout(null);
        continuar = new JButton("Continuar");
        seleccionar = new JButton("Seleccionar nivel");
        seleccionar.setBounds(gp.screenWidth / 2 - 100, gp.screenHeight / 2 + 60, 200, 50);
        seleccionar.setForeground(Color.WHITE);
        seleccionar.setBackground(Color.DARK_GRAY);
        gp.add(seleccionar);
        try {
            logo = ImageIO.read(getClass().getResourceAsStream("/res/ui/logo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        if (keyH.shotPressed){
            gp.loadProgress();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(logo, (gp.screenWidth/2) - 128, (gp.screenHeight/2) - 256, 256,256, null);
        gp.revalidate();
    }
}
