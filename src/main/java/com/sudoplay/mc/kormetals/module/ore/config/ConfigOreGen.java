package com.sudoplay.mc.kormetals.module.ore.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kor.spi.config.json.component.common.MinMaxInt;
import com.sudoplay.mc.kor.spi.world.DimensionProfile;
import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class ConfigOreGen extends
    KorConfigObject implements
    KorConfigOreGen {

  private static final int DIMENSION_ID = 0;
  private static final int DEFAULT_MOD_GENERATION_WEIGHT = 0;

  @SerializedName("ore_gen")
  private Map<String, KorOreGenConfigEntry> configEntryMap;

  public ConfigOreGen() {
    this.configEntryMap = new HashMap<>();

    // normal ores

    this.set("aluminum",
        new DenseDimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(8, 16), new MinMaxInt(40, 75), 0.01f),
        new DenseDimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(3, 8), new MinMaxInt(48, 96), 0.01f)
    );

    this.set("copper",
        new DenseDimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(8, 16), new MinMaxInt(40, 75), 0.01f),
        new DenseDimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(3, 8), new MinMaxInt(48, 96), 0.01f)
    );

    this.set("lead",
        new DenseDimensionProfile(DIMENSION_ID, 5, "minecraft:stone", new MinMaxInt(3, 6), new MinMaxInt(2, 35), 0.01f),
        new DenseDimensionProfile(DIMENSION_ID, 12, "minecraft:stone", new MinMaxInt(2, 3), new MinMaxInt(20, 25), 0.01f)
    );

    this.set("nickel",
        new DenseDimensionProfile(DIMENSION_ID, 3, "minecraft:stone", new MinMaxInt(1, 3), new MinMaxInt(5, 20), 0.01f)
    );

    this.set("platinum",
        new DenseDimensionProfile(DIMENSION_ID, 3, "minecraft:stone", new MinMaxInt(1, 2), new MinMaxInt(11, 28), 0.01f)
    );

    this.set("silver",
        new DenseDimensionProfile(DIMENSION_ID, 5, "minecraft:stone", new MinMaxInt(1, 2), new MinMaxInt(5, 30), 0.01f),
        new DenseDimensionProfile(DIMENSION_ID, 2, "minecraft:stone", new MinMaxInt(6, 8), new MinMaxInt(10, 35), 0.01f)
    );

    this.set("tin",
        new DenseDimensionProfile(DIMENSION_ID, 8, "minecraft:stone", new MinMaxInt(5, 10), new MinMaxInt(20, 55), 0.01f)
    );

    this.set("zinc",
        new DenseDimensionProfile(DIMENSION_ID, 8, "minecraft:stone", new MinMaxInt(5, 10), new MinMaxInt(2, 40), 0.01f)
    );

    // alloy ores

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      this.set(metalType.getName(), new DenseDimensionProfile(0, 3, "minecraft:stone", new MinMaxInt(1, 2), new MinMaxInt(5, 30), 0.01f));
    }
  }

  private void set(String name, DimensionProfile... profiles) {
    this.set(DEFAULT_MOD_GENERATION_WEIGHT, name, profiles);
  }

  private void set(int modGenerationWeight, String name, DimensionProfile... profiles) {
    this.configEntryMap.put(name, new KorOreGenConfigEntry(modGenerationWeight, profiles));
  }

  @Override
  public Map<String, KorOreGenConfigEntry> getConfigEntryMap() {
    return configEntryMap;
  }
}
