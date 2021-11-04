package com.jkid4200.bug.engine.utils;

import com.jkid4200.bug.engine.Window;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Timer {

  private static long lastTime = System.nanoTime();
  private static long resetTime = System.currentTimeMillis();

  private static final float FPS = 60.0f;
  private static final float NS = 1_000_000_000.0f / FPS;
  @Getter private static float delta = 0.0f;

  private static int frames = 0;
  private static int updates = 0;

  public static void start() {
    final long now = System.nanoTime();
    delta += (now - lastTime) / NS;
    lastTime = now;
  }

  public static boolean shouldUpdate() {
    return delta >= 1.0f;
  }

  public static void update() {
    delta--;
    updates++;
  }

  public static void render() {
    frames++;
  }

  public static boolean shouldReset() {
    return System.currentTimeMillis() - resetTime > 1000L;
  }

  public static void reset(Window window) {
    resetTime += 1000L;
    window.displayDebugMessage("FPS: " + frames + ", UPS: " + updates);
    frames = 0;
    updates = 0;
  }
}
