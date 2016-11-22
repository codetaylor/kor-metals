package com.sudoplay.mc.kormetals.module.ore.config;

import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class ConfigDenseOreEntry extends
    KorConfigObject {

  private float hardness;
  private float resistance;
  private int harvestLevel;
  private int denseDropMultiplier;

  public ConfigDenseOreEntry(float hardness, float resistance, int harvestLevel, int denseDropMultiplier) {
    this.hardness = hardness;
    this.resistance = resistance;
    this.harvestLevel = harvestLevel;
    this.denseDropMultiplier = denseDropMultiplier;
  }

  public float getHardness() {
    return hardness;
  }

  public float getResistance() {
    return resistance;
  }

  public int getHarvestLevel() {
    return harvestLevel;
  }

  public int getDenseDropMultiplier() {
    return denseDropMultiplier;
  }
}
