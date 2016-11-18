package com.sudoplay.mc.kormetals.module.ore.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kormetals.shared.MetalType;

import java.util.EnumMap;
import java.util.Map;

import static com.sudoplay.mc.kormetals.shared.MetalType.*;

/**
 * Created by sk3lls on 11/15/2016.
 */
public class ConfigBlockNetherOre extends
    KorConfigObject {

  @SerializedName("nether_ore")
  private Map<MetalType, ConfigBlockEntry> oreConfigEntryMap;

  public ConfigBlockNetherOre() {
    this.oreConfigEntryMap = new EnumMap<>(MetalType.class);
    this.oreConfigEntryMap.put(Aluminum, new ConfigBlockEntry(3.0f, 5.0f, 2));
    this.oreConfigEntryMap.put(Copper, new ConfigBlockEntry(3.0f, 5.0f, 1));
    this.oreConfigEntryMap.put(Lead, new ConfigBlockEntry(3.0f, 5.0f, 2));
    this.oreConfigEntryMap.put(Nickel, new ConfigBlockEntry(3.0f, 5.0f, 2));
    this.oreConfigEntryMap.put(Platinum, new ConfigBlockEntry(3.0f, 5.0f, 2));
    this.oreConfigEntryMap.put(Silver, new ConfigBlockEntry(3.0f, 5.0f, 2));
    this.oreConfigEntryMap.put(Tin, new ConfigBlockEntry(3.0f, 5.0f, 1));
    this.oreConfigEntryMap.put(Zinc, new ConfigBlockEntry(3.0f, 5.0f, 2));
  }

  public ConfigBlockEntry get(MetalType key) {
    return this.oreConfigEntryMap.get(key);
  }
}
