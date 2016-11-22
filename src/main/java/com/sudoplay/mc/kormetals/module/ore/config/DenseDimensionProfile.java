package com.sudoplay.mc.kormetals.module.ore.config;

import com.sudoplay.mc.kor.spi.config.json.component.common.MinMaxInt;
import com.sudoplay.mc.kor.spi.world.DimensionProfile;

/**
 * Created by sk3lls on 11/22/2016.
 */
public class DenseDimensionProfile extends
    DimensionProfile {

  private float denseSpawnChance;

  public DenseDimensionProfile(
      int dimensionId,
      int blockCount,
      String matchBlock,
      MinMaxInt spawnsPerChunk,
      MinMaxInt verticalGeneration,
      float denseSpawnChance
  ) {
    super(dimensionId, blockCount, matchBlock, spawnsPerChunk, verticalGeneration);
    this.denseSpawnChance = denseSpawnChance;
  }

  public float getDenseSpawnChance() {
    return denseSpawnChance;
  }
}
