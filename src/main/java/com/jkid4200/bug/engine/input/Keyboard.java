package com.jkid4200.bug.engine.input;

import com.jkid4200.bug.engine.Window;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Keyboard extends KeyAdapter {

  private static final Map<Integer, Boolean> pressed = new HashMap<>();
  private static final Map<Integer, Boolean> released = new HashMap<>();

  public Keyboard(Window window, JFrame frame) {
    window.addKeyListener(this);
    frame.addKeyListener(this);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    pressed.put(e.getKeyCode(), true);
    released.put(e.getKeyCode(), false);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    pressed.put(e.getKeyCode(), false);
    released.put(e.getKeyCode(), true);
  }

  public static boolean isPressed(int key) {
    return pressed.getOrDefault(key, false);
  }

  public static boolean getReleased(int key) {
    return released.getOrDefault(key, false);
  }

  public static void clean() {
    pressed.clear();
    released.clear();
  }
}
