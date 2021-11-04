package com.jkid4200.bug.engine;

import com.jkid4200.bug.engine.input.Keyboard;
import com.jkid4200.bug.engine.input.Mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

@SuppressWarnings("unused")
public class Window extends Canvas {

  public static final boolean DEBUG = true;

  private final String title;
  private final int windowWidth;
  private final int windowHeight;

  private transient BufferStrategy bufferStrategy;
  private transient Graphics graphics;
  private final JFrame frame;

  public Window(String title, int windowWidth, int windowHeight) {
    this.title = title;
    this.windowWidth = windowWidth;
    this.windowHeight = windowHeight;
    this.frame = new JFrame(title);

    Dimension size = new Dimension(windowWidth, windowHeight);
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
  }

  public void init() {
    frame.add(this);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);

    createBufferStrategy(3);
    new Keyboard(this, frame);
    new Mouse(this, frame);
  }

  public Graphics startRender() {
    bufferStrategy = getBufferStrategy();
    graphics = bufferStrategy.getDrawGraphics();
    clear();
    return graphics;
  }

  public void stopRender() {
    graphics.dispose();
    bufferStrategy.show();
    Mouse.resetScroll();
  }

  public void clean() {
    Keyboard.clean();
    Mouse.clean();

    frame.setVisible(false);
    graphics = null;
    bufferStrategy = null;
  }

  private void clear() {
    graphics.setColor(Color.BLACK);
    graphics.fillRect(0, 0, windowWidth, windowHeight);
  }

  public void displayDebugMessage(String message) {
    if (DEBUG) {
      frame.setTitle(title + " | " + message);
    }
  }

  public float getAspectRatio() {
    return (float) windowWidth / windowHeight;
  }
}
