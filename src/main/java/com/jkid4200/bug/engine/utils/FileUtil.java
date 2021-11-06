package com.jkid4200.bug.engine.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class FileUtil {

  public static BufferedImage getTexture(String fileName) {
    String path = "/textures/" + fileName;
    BufferedImage image = null;
    try {
      InputStream resource = FileUtil.class.getResourceAsStream(path);
      if (resource != null) {
        image = ImageIO.read(resource);
      } else {
        throw new IOException();
      }
    } catch (IOException e) {
      log.error("Could not load image from {}\n{}", path, e);
      System.exit(-1);
    }
    return image;
  }
}
