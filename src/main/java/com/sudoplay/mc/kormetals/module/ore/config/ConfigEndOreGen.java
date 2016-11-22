package com.sudoplay.mc.kormetals.module.ore.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kor.spi.config.json.component.common.MinMaxInt;
import com.sudoplay.mc.kor.spi.world.DimensionProfile;
import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class ConfigEndOreGen extends
    KorConfigObject implements
    KorConfigOreGen {

  private static final int DIMENSION_ID = 1;
  private static final int DEFAULT_MOD_GENERATION_WEIGHT = 0;

  @SerializedName("end_ore_gen")
  private Map<String, KorOreGenConfigEntry> configEntryMap;

  public ConfigEndOreGen() {
    this.configEntryMap = new HashMap<>();

    // normal ores

    for (MetalType metalType : MetalType.values()) {
      this.set(metalType.getName(),
          new DenseDimensionProfile(DIMENSION_ID, 8, "minecraft:end_stone", new MinMaxInt(8, 16), new MinMaxInt(0, 255), 0.04f)
      );
    }

    // alloy ores

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      this.set(metalType.getName(), new DenseDimensionProfile(DIMENSION_ID, 3, "minecraft:end_stone", new MinMaxInt(4, 8), new MinMaxInt(0, 255), 0.04f));
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
