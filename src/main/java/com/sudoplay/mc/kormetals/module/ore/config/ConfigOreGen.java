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
    KorConfigObject {

  private static final int DIMENSION_ID = 0;
  private static final int DEFAULT_MOD_GENERATION_WEIGHT = 0;

  @SerializedName("ore_gen")
  private Map<String, KorOreGenConfigEntry> configEntryMap;

  public ConfigOreGen() {
    this.configEntryMap = new HashMap<>();

    // normal ores

    this.register("aluminum",
        new DimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(8, 16), new MinMaxInt(40, 75)),
        new DimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(3, 8), new MinMaxInt(48, 96))
    );

    this.register("copper",
        new DimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(8, 16), new MinMaxInt(40, 75)),
        new DimensionProfile(DIMENSION_ID, 10, "minecraft:stone", new MinMaxInt(3, 8), new MinMaxInt(48, 96))
    );

    this.register("lead",
        new DimensionProfile(DIMENSION_ID, 5, "minecraft:stone", new MinMaxInt(3, 6), new MinMaxInt(2, 35)),
        new DimensionProfile(DIMENSION_ID, 12, "minecraft:stone", new MinMaxInt(2, 3), new MinMaxInt(20, 25))
    );

    this.register("nickel",
        new DimensionProfile(DIMENSION_ID, 3, "minecraft:stone", new MinMaxInt(1, 3), new MinMaxInt(5, 20))
    );

    this.register("platinum",
        new DimensionProfile(DIMENSION_ID, 3, "minecraft:stone", new MinMaxInt(1, 2), new MinMaxInt(11, 28))
    );

    this.register("silver",
        new DimensionProfile(DIMENSION_ID, 5, "minecraft:stone", new MinMaxInt(1, 2), new MinMaxInt(5, 30)),
        new DimensionProfile(DIMENSION_ID, 2, "minecraft:stone", new MinMaxInt(6, 8), new MinMaxInt(10, 35))
    );

    this.register("tin",
        new DimensionProfile(DIMENSION_ID, 8, "minecraft:stone", new MinMaxInt(5, 10), new MinMaxInt(20, 55))
    );

    this.register("zinc",
        new DimensionProfile(DIMENSION_ID, 8, "minecraft:stone", new MinMaxInt(5, 10), new MinMaxInt(2, 40))
    );

    // alloy ores

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      this.register(metalType.getName(), new DimensionProfile(0, 3, "minecraft:stone", new MinMaxInt(1, 2), new MinMaxInt(5, 30)));
    }
  }

  private void register(String name, DimensionProfile... profiles) {
    this.register(DEFAULT_MOD_GENERATION_WEIGHT, name, profiles);
  }

  private void register(int modGenerationWeight, String name, DimensionProfile... profiles) {
    this.configEntryMap.put(name, new KorOreGenConfigEntry(modGenerationWeight, profiles));
  }

  public Map<String, KorOreGenConfigEntry> getConfigEntryMap() {
    return configEntryMap;
  }
}
