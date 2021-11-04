package com.jkid4200.bug.engine.input;

import com.jkid4200.bug.engine.Window;
import com.jkid4200.bug.engine.math.Vector2f;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Mouse extends MouseAdapter {

  private static final Map<Integer, Boolean> pressed = new HashMap<>();
  private static final Map<Integer, Boolean> released = new HashMap<>();

  @Getter private static final Vector2f position = new Vector2f();
  @Getter private static float scroll = 0.0f;

  public Mouse(Window window, JFrame frame) {
    window.addMouseListener(this);
    window.addMouseMotionListener(this);
    window.addMouseWheelListener(this);
    frame.addMouseListener(this);
    frame.addMouseMotionListener(this);
    frame.addMouseMotionListener(this);
  }

  @Override
  public void mousePressed(MouseEvent e) {
    pressed.put(e.getButton(), true);
    released.put(e.getButton(), false);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    pressed.put(e.getButton(), false);
    released.put(e.getButton(), true);
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    position.set(e.getXOnScreen(), e.getYOnScreen());
  }

  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    scroll = (float) e.getPreciseWheelRotation();
  }

  public static void clean() {
    pressed.clear();
    released.clear();
  }

  public static boolean getPressed(int button) {
    return pressed.getOrDefault(button, false);
  }

  public static boolean getReleased(int button) {
    return released.getOrDefault(button, false);
  }

  public static float getX() {
    return position.getX();
  }

  public static float getY() {
    return position.getY();
  }

  public static boolean isScrollUp() {
    return scroll < 0.0f;
  }

  public static boolean isScrollDown() {
    return scroll > 0.0f;
  }

  public static void resetScroll() {
    scroll = 0.0f;
  }
}
