package main;

import userInterface.UserInterface;
import entity.EnemyManager;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Player;
import entity.Spade;

public class GamePanel extends JPanel implements Runnable {
    final int tileSize = 64;
    final float scale = (float) 1;
    public final int trueTileS = (int) (tileSize * scale);
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    public final int screenWidth = trueTileS * maxScreenCol;
    public final int screenHeight = trueTileS * maxScreenRow;

    public KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    UserInterface UI = new UserInterface(this);
    Player player = new Player(this, keyH);
    EnemyManager eManager = new EnemyManager(this);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        eManager.addEm(new Spade(this));
        eManager.enemies.get(0).x = 500;
        eManager.enemies.get(0).y = 200;
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        final double drawInterval = 1000000000/30;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawcount = 0;

        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawcount++;
            }

            if (timer >= 1000000000) {
                System.out.println(drawcount);
                drawcount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();
        eManager.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        player.draw(g2);
        eManager.draw(g2);
        UI.draw(g2);
        g2.dispose();
    }
}
