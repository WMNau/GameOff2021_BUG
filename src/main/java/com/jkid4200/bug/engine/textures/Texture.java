package com.jkid4200.bug.engine.textures;

import com.jkid4200.bug.engine.utils.FileUtil;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.util.UUID;

@Data
public class Texture {

  private final String id;
  private final BufferedImage image;
  private final int width;
  private final int height;

  public Texture(String fileName) {
    this(FileUtil.getTexture(fileName));
  }

  public Texture(BufferedImage image) {
    this.id = UUID.randomUUID().toString();
    this.image = image;
    this.width = image.getWidth();
    this.height = image.getHeight();
  }
}
