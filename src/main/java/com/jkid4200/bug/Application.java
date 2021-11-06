package com.jkid4200.bug;

import com.jkid4200.bug.engine.Window;
import com.jkid4200.bug.engine.entities.Entity;
import com.jkid4200.bug.engine.entities.Player;
import com.jkid4200.bug.engine.entities.ai.Enemy;
import com.jkid4200.bug.engine.math.Vector2i;
import com.jkid4200.bug.engine.utils.Timer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Application implements Runnable {

  private Thread applicationThread;
  private boolean running;

  private final Window window;
  private final List<Entity> entityList;

  Application() {
    this.running = false;
    this.window = new Window("Bug", 1080, 720);
    entityList = new ArrayList<>();
  }

  private void init() {
    window.init();
    entityList.add(new Player(new Vector2i(100), new Vector2i(50)));
    entityList.add(new Enemy(new Vector2i(200), new Vector2i(50)));
  }

  private void update() {
    entityList.forEach(
        entity -> {
          entity.update();
          entity.move();
        });
  }

  private void render(Graphics graphics) {
    entityList.forEach(entity -> entity.render(graphics));
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
