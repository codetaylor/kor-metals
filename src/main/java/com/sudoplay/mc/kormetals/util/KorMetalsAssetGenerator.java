package com.sudoplay.mc.kormetals.util;

import com.sudoplay.mc.kor.core.generation.AssetGenerator;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class KorMetalsAssetGenerator {

  public static void main(String... args) {

    AssetGenerator generator = new AssetGenerator(
        "subprojects/kor-metals/assets",
        "subprojects/kor-metals/src/main/resources/assets/ctkormetals"
    );

    generator.generate(new ModuleOre());
  }
}
