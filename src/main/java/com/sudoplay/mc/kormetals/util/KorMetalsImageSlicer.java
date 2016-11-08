package com.sudoplay.mc.kormetals.util;

import com.sudoplay.mc.kor.core.ImageSlicer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class KorMetalsImageSlicer {

  private ImageSlicer imageSlicer;
  private String[] filenames;

  public KorMetalsImageSlicer(ImageSlicer imageSlicer) {
    this.imageSlicer = imageSlicer;
  }

  public static void main(String... args) {
    ImageSlicer imageSlicer = new ImageSlicer();
    new KorMetalsImageSlicer(imageSlicer).slice();
  }

  public void slice() {

    this.filenames = this.imageSlicer.createFilenames(
        new String[]{"copper", "tin", "silver", "lead", "nickel", "platinum", "brass", "invar", "electrum", "signalum", "lumium", "enderium"},
        new String[]{"ingot", "nugget", "powder", "block", "gear", "plate", "ore", "nether_ore", "helmet", "chestplate", "leggings", "boots", "axe", "hoe", "pickaxe", "shovel", "sword", "shears"}
    );

    System.out.println("Filenames:");
    System.out.println(Arrays.toString(this.filenames));
    System.out.println();

    try {

      // regular ores and nether ores
      sliceImage(
          "subprojects/kor-metals/assets/KorMetals.png",
          "subprojects/kor-metals/src/main/resources/assets/ctkormetals/textures/blocks",
          new int[]{0, 6, 12, 8} // left, top, right, bottom
      );

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void sliceImage(
      String sourceFilename,
      String sliceDestinationPath, int[] crop
  ) throws IOException {
    InputStream inputStream;
    inputStream = new FileInputStream(sourceFilename);

    this.imageSlicer.sliceImage(
        inputStream,
        this.filenames,
        crop,
        16,
        16,
        new File(sliceDestinationPath)
    );

    inputStream.close();
  }
}