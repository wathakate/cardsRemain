package main;

import stages.*;
import stages.Menu;

import java.awt.*;
import javax.swing.JPanel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GamePanel extends JPanel implements Runnable {
    final int tileSize = 32;
    final float scale = (float) 1;
    public final int trueTileS = (int) (tileSize * scale);
    final int maxScreenCol = 32;
    final int maxScreenRow = 18;
    public final int screenWidth = trueTileS * maxScreenCol;
    public final int screenHeight = trueTileS * maxScreenRow;

    BorderLayout bl = new BorderLayout();
    public KeyHandler keyH = new KeyHandler();
    boolean isPaused = false;
    public int score;
    Thread gameThread;
    public Stage stage = new Menu(this, keyH);

    public GamePanel(){
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

    final double drawInterval = 1000000000/30;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawcount = 0;
    @Override
    public void run() {
        delta = 0;
        lastTime = System.nanoTime();
        timer = 0;
        drawcount = 0;

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
        if (keyH.pause){
            isPaused = !isPaused;
        }
        if (!isPaused){
            stage.update();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        stage.draw(g2);
        if (isPaused){
            g2.setFont(new Font("MS Gothic",Font.BOLD, 64));
            g2.setColor(Color.white);
            g.drawString("PAUSADO", (screenWidth/2)-115, screenHeight/2);
        }
        g2.dispose();
    }

    //Maneja t0do lo de guardar y cargar
    public void saveProgress(int scr, int currentStage){
        try {
            int originalScore = 0;
            int originalStage = 1;
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));
            if (!Files.readAllLines(Paths.get("save.txt")).isEmpty()) {
                originalScore = Integer.parseInt(br.readLine().trim());
                originalStage = Integer.parseInt(br.readLine().trim());
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("save.txt"));
            bw.write(String.valueOf(scr)); // primera linea
            bw.newLine();
            bw.write(String.valueOf(currentStage)); // segunda linea
            bw.newLine();
            if (originalScore < scr){ // compara si tu puntaje es mejor a tu record anterior
                bw.write(String.valueOf(scr)); // tercera linea
            } else {
                bw.write(String.valueOf(originalScore));
            }
            bw.newLine();
            if (originalStage < currentStage){ // compara si el nivel guardado es mayor al que ya llegaste
                bw.write(String.valueOf(currentStage)); // cuarta
            } else {
                bw.write(String.valueOf(originalStage));
            }
            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void loadProgress(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("save.txt"));

            if (!Files.readAllLines(Paths.get("save.txt")).isEmpty()) {
                score = Integer.parseInt(br.readLine().trim()); // pone el puntaje
                switch(Integer.parseInt(br.readLine().trim())){ // pone el stage
                    case 101:
                        stage = new stagetest(this, keyH);
                        break;
                    case 1:
                        stage = new Stage01(this, keyH);
                        break;
                    case 2:
                        stage = new Stage02(this, keyH);
                        break;
                    case 3:
                        stage = new Stage03(this, keyH);
                        break;
                    case 4:
                        stage = new Stage04(this, keyH);
                        break;
                    case 5:
                        stage = new Stage05(this, keyH);
                        break;
                    case 6:
                        stage = new Stage06(this, keyH);
                        break;
                    default:
                        stage = new Menu(this,keyH);
                }
            } else {
                System.out.println("Error leyendo save.txt");
                score = 0;
                stage = new Stage01(this, keyH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updatePanel(Color backcolor){
        this.setBackground(backcolor);
    }
}
