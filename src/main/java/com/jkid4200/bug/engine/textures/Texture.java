package com.jkid4200.bug.engine.textures;

import lombok.*;

import java.awt.image.BufferedImage;
import java.util.UUID;

@SuppressWarnings("unused")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Texture {

  @Getter private final String id = UUID.randomUUID().toString();
  @Getter private BufferedImage image;

  public int getWidth() {
    return image == null ? 0 : image.getWidth();
  }

  public int getHeight() {
    return image == null ? 0 : image.getHeight();
  }
}
