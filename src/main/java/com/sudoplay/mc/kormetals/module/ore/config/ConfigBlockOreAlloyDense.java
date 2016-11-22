package com.sudoplay.mc.kormetals.module.ore.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;

import java.util.EnumMap;
import java.util.Map;

import static com.sudoplay.mc.kormetals.shared.MetalAlloyType.*;

/**
 * Created by sk3lls on 11/15/2016.
 */
public class ConfigBlockOreAlloyDense extends
    KorConfigObject {

  @SerializedName("ore_alloy")
  private Map<MetalAlloyType, ConfigDenseOreEntry> oreConfigEntryMap;

  public ConfigBlockOreAlloyDense() {
    this.oreConfigEntryMap = new EnumMap<>(MetalAlloyType.class);
    this.oreConfigEntryMap.put(AluminumBrass, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Brass, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Bronze, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Constantan, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Electrum, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Enderium, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Invar, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Lumium, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Signalum, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Steel, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
  }

  public ConfigDenseOreEntry get(MetalAlloyType key) {
    return this.oreConfigEntryMap.get(key);
  }
}
