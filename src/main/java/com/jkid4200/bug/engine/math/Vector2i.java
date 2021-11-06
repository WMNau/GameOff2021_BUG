package com.jkid4200.bug.engine.math;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Vector2i {

  private int x;
  private int y;

  public Vector2i(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Vector2i(int xy) {
    this(xy, xy);
  }

  public Vector2i() {
    this(0);
  }

  public Vector2i(Vector2i vector) {
    this(vector.x, vector.y);
  }

  public void add(float x, float y) {
    this.x += x;
    this.y += y;
  }

  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void clear() {
    this.x = 0;
    this.y = 0;
  }
}
