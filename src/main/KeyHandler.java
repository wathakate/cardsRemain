package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean uPressed, dPressed, lPressed, rPressed, focusPressed, shotPressed, meleePressed, lSelection, rSelection, scPressed, pause;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            uPressed = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            dPressed = true;
        }
        if (code == KeyEvent.VK_LEFT) {
            lPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rPressed = true;
        }
        if (code == KeyEvent.VK_SHIFT) {
            focusPressed = true;
        }
        if (code == KeyEvent.VK_E) {
            shotPressed = true;
        }
        if (code == KeyEvent.VK_Q) {
            meleePressed = true;
        }
        if (code == KeyEvent.VK_A) {
            lSelection = true;
        }
        if (code == KeyEvent.VK_D) {
            rSelection = true;
        }
        if (code == KeyEvent.VK_W) {
            scPressed = true;
        }
        if (code == KeyEvent.VK_ESCAPE){
            pause = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP) {
            uPressed = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            dPressed = false;
        }
        if (code == KeyEvent.VK_LEFT) {
            lPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT) {
            rPressed = false;
        }
        if (code == KeyEvent.VK_SHIFT) {
            focusPressed = false;
        }
        if (code == KeyEvent.VK_E) {
            shotPressed = false;
        }
        if (code == KeyEvent.VK_Q) {
            meleePressed = false;
        }
        if (code == KeyEvent.VK_A) {
            lSelection = false;
        }
        if (code == KeyEvent.VK_D) {
            rSelection = false;
        }
        if (code == KeyEvent.VK_W) {
            scPressed = false;
        }
        if (code == KeyEvent.VK_ESCAPE){
            pause = false;
        }
    }

}
