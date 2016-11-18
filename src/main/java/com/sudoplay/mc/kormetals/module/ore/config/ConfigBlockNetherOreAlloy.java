package com.sudoplay.mc.kormetals.module.ore.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;

import java.util.EnumMap;
import java.util.Map;

import static com.sudoplay.mc.kormetals.shared.MetalAlloyType.*;

/**
 * Created by sk3lls on 11/15/2016.
 */
public class ConfigBlockNetherOreAlloy extends
    KorConfigObject {

  @SerializedName("nether_ore_alloy")
  private Map<MetalAlloyType, ConfigBlockEntry> oreConfigEntryMap;

  public ConfigBlockNetherOreAlloy() {
    this.oreConfigEntryMap = new EnumMap<>(MetalAlloyType.class);
    this.oreConfigEntryMap.put(AluminumBrass, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Brass, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Bronze, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Constantan, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Electrum, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Enderium, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Invar, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Lumium, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Signalum, new ConfigBlockEntry(3.0f, 5.0f, 3));
    this.oreConfigEntryMap.put(Steel, new ConfigBlockEntry(3.0f, 5.0f, 3));
  }

  public ConfigBlockEntry get(MetalAlloyType key) {
    return this.oreConfigEntryMap.get(key);
  }
}
