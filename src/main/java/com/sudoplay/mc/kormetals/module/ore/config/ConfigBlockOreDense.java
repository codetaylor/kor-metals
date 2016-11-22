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
public class ConfigBlockOreDense extends
    KorConfigObject {

  @SerializedName("ore")
  private Map<MetalType, ConfigDenseOreEntry> oreConfigEntryMap;

  public ConfigBlockOreDense() {
    this.oreConfigEntryMap = new EnumMap<>(MetalType.class);
    this.oreConfigEntryMap.put(Aluminum, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Copper, new ConfigDenseOreEntry(6.0f, 7.0f, 2, 2));
    this.oreConfigEntryMap.put(Lead, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Nickel, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Platinum, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Silver, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
    this.oreConfigEntryMap.put(Tin, new ConfigDenseOreEntry(6.0f, 7.0f, 2, 2));
    this.oreConfigEntryMap.put(Zinc, new ConfigDenseOreEntry(6.0f, 7.0f, 3, 2));
  }

  public ConfigDenseOreEntry get(MetalType key) {
    return this.oreConfigEntryMap.get(key);
  }
}
