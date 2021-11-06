package com.jkid4200.bug.engine.entities;

import com.jkid4200.bug.engine.math.Vector2i;
import com.jkid4200.bug.engine.textures.Texture;
import com.jkid4200.bug.engine.utils.FileUtil;

import java.awt.*;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public abstract class Entity {

  protected final String id;
  protected final Rectangle bounds;
  protected final Color color;

  protected final Optional<Texture> texture;

  protected Entity(Vector2i position, Vector2i size, Color color) {
    this.id = UUID.randomUUID().toString();
    this.bounds = new Rectangle(position.getX(), position.getY(), size.getX(), size.getY());
    this.color = color;
    this.texture = Optional.empty();
  }

  protected Entity(Vector2i position, Vector2i size, String textureName) {
    this.id = UUID.randomUUID().toString();
    this.bounds = new Rectangle(position.getX(), position.getY(), size.getX(), size.getY());
    this.color = Color.CYAN;
    this.texture =
        Optional.of(new Texture().toBuilder().image(FileUtil.getTexture(textureName)).build());
  }

  public void update() {
    // Implement only if needed
  }

  public void move() {
    // Implement only if needed
  }

  public void render(Graphics graphics) {
    texture.ifPresentOrElse(
        tex ->
            graphics.drawImage(
                tex.getImage(), bounds.x, bounds.y, bounds.width, bounds.height, null),
        () -> {
          graphics.setColor(color);
          graphics.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        });
  }
}
