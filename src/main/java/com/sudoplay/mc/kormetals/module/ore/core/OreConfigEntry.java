package com.sudoplay.mc.kormetals.module.ore.core;

import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class OreConfigEntry extends
    KorConfigObject {

  private float hardness;
  private float resistance;
  private int harvestLevel;

  public OreConfigEntry(float hardness, float resistance, int harvestLevel) {
    this.hardness = hardness;
    this.resistance = resistance;
    this.harvestLevel = harvestLevel;
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
}
