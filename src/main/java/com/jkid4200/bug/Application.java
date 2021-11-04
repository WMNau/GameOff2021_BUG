package com.jkid4200.bug;

import com.jkid4200.bug.engine.Window;
import com.jkid4200.bug.engine.utils.Timer;

import java.awt.*;

public class Application implements Runnable {

  private Thread applicationThread;
  private boolean running;

  private final Window window;

  Application() {
    this.running = false;
    this.window = new Window("Bug", 1080, 720);
  }

  private void init() {
    window.init();
  }

  private void update() {
    // Update game objects
  }

  private void render(Graphics graphics) {
    // Render game objects
  }

  private void clean() {
    window.clean();
  }

  @Override
  public void run() {
    init();

    while (running) {
      Timer.start();

      while (Timer.shouldUpdate()) {
        update();
        Timer.update();
      }
      Graphics graphics = window.startRender();
      render(graphics);
      window.stopRender();
      Timer.render();

      if (Timer.shouldReset()) {
        Timer.reset(window);
      }
    }
    clean();
    stop();
  }

  private void start() {
    if (!running) {
      running = true;
      applicationThread = new Thread(this, "Application Thread");
      applicationThread.start();
    }
  }

  private void stop() {
    running = false;
    try {
      applicationThread.join(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    applicationThread = null;
  }

  public static void main(String[] args) {
    new Application().start();
  }
}
