package main;

import userInterface.UiPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Cards remain");

        GamePanel gamepanel = new GamePanel();
        UiPanel uipanel = new UiPanel();
        window.add(gamepanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamepanel.startGameThread();
    }
}