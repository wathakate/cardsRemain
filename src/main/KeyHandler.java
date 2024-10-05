package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean uPressed, dPressed, lPressed, rPressed, ePressed;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            uPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            dPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            lPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            rPressed = true;
        }
        if (code == KeyEvent.VK_E) {
            ePressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            uPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            dPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            lPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rPressed = false;
        }
        if (code == KeyEvent.VK_E) {
            ePressed = false;
        }
    }

}
