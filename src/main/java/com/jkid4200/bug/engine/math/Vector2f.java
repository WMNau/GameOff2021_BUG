package com.jkid4200.bug.engine.math;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Vector2f {

  private float x;
  private float y;

  public Vector2f(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public Vector2f(float xy) {
    this(xy, xy);
  }

  public Vector2f() {
    this(0.0f);
  }

  public Vector2f(Vector2f vector) {
    this(vector.x, vector.y);
  }

  public void add(float x, float y) {
    this.x += x;
    this.y += y;
  }

  public void set(float x, float y) {
    this.x = x;
    this.y = y;
  }

  public void clear() {
    this.x = 0.0f;
    this.y = 0.0f;
  }
}
