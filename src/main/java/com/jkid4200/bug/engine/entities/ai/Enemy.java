package com.jkid4200.bug.engine.entities.ai;

import com.jkid4200.bug.engine.entities.Entity;
import com.jkid4200.bug.engine.math.Vector2i;

import java.awt.*;

public class Enemy extends Entity {

  public Enemy(Vector2i position, Vector2i size) {
    super(position, size, Color.RED);
  }
}
