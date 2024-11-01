package main;

import stages.Stage;
import stages.stagetest;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;

public class GamePanel extends JPanel implements Runnable {
    final int tileSize = 32;
    final float scale = (float) 1;
    public final int trueTileS = (int) (tileSize * scale);
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    public final int screenWidth = trueTileS * maxScreenCol;
    public final int screenHeight = trueTileS * maxScreenRow;

    public KeyHandler keyH = new KeyHandler();
    public int score;
    Thread gameThread;
    public Stage stage;

    public GamePanel(){
        loadProgress();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(stage.backColor);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
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
        stage.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        stage.draw(g2);
        g2.dispose();
    }

    //Maneja t0do lo de guardar y cargar
    public void saveProgress(int scr, int currentStage){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));

            bw.write(String.valueOf(scr)); // primera linea
            bw.newLine();
            bw.write(String.valueOf(currentStage)); // segunda linea
            bw.newLine();
            if (Integer.parseInt(br.readLine()) < scr){ // compara si tu puntaje es mejor a tu record anterior
                bw.write(String.valueOf(scr)); // tercera linea
            }
            bw.newLine();
            if (Integer.parseInt(br.readLine()) < currentStage){ // compara si el nivel guardado es mayor al que ya llegaste
                bw.write(String.valueOf(currentStage)); // cuarta
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void loadProgress(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            score = Integer.parseInt(br.readLine()); // pone el puntaje
            switch(Integer.parseInt(br.readLine())){ // pone el stage
                case 101:
                    stage = new stagetest(this, keyH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePanel(){
        this.setBackground(stage.backColor);
    }
}
