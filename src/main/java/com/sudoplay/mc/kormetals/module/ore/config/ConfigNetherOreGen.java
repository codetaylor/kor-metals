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
public class ConfigNetherOreGen extends
    KorConfigObject {

  private static final int DIMENSION_ID = -1;
  private static final int DEFAULT_MOD_GENERATION_WEIGHT = 0;

  @SerializedName("nether_ore_gen")
  private Map<String, KorOreGenConfigEntry> configEntryMap;

  public ConfigNetherOreGen() {
    this.configEntryMap = new HashMap<>();

    // normal ores

    for (MetalType metalType : MetalType.values()) {
      this.register(metalType.getName(),
          new DimensionProfile(DIMENSION_ID, 8, "minecraft:netherrack", new MinMaxInt(8, 16), new MinMaxInt(0, 128))
      );
    }

    // alloy ores

    for (MetalAlloyType metalType : MetalAlloyType.values()) {

      if (metalType == MetalAlloyType.Lumium) {
        this.register(metalType.getName(), new DimensionProfile(0, 3, "minecraft:glowstone", new MinMaxInt(4, 8), new MinMaxInt(0, 128)));

      } else {
        this.register(metalType.getName(), new DimensionProfile(0, 3, "minecraft:netherrack", new MinMaxInt(4, 8), new MinMaxInt(0, 128)));
      }
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
