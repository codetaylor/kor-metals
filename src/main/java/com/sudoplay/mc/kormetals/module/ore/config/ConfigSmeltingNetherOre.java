package com.sudoplay.mc.kormetals.module.ore.config;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kor.spi.config.json.component.smelting.ConfigSmeltingEntry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sk3lls on 11/12/2016.
 */
public class ConfigSmeltingNetherOre extends
    KorConfigObject {

  @SerializedName("smelting_nether_ore")
  private Map<String, ConfigSmeltingEntry> entryMap;

  public ConfigSmeltingNetherOre() {
    this.entryMap = new HashMap<>();

    this.entryMap.put("brass", new ConfigSmeltingEntry(0.8f, 2));
    this.entryMap.put("copper", new ConfigSmeltingEntry(0.7f, 2));
    this.entryMap.put("electrum", new ConfigSmeltingEntry(0.8f, 2));
    this.entryMap.put("enderium", new ConfigSmeltingEntry(0.8f, 2));
    this.entryMap.put("invar", new ConfigSmeltingEntry(0.8f, 2));
    this.entryMap.put("lead", new ConfigSmeltingEntry(0.7f, 2));
    this.entryMap.put("lumium", new ConfigSmeltingEntry(1.0f, 2));
    this.entryMap.put("nickel", new ConfigSmeltingEntry(0.8f, 2));
    this.entryMap.put("platinum", new ConfigSmeltingEntry(1.0f, 2));
    this.entryMap.put("silver", new ConfigSmeltingEntry(0.8f, 2));
    this.entryMap.put("signalum", new ConfigSmeltingEntry(1.0f, 2));
    this.entryMap.put("tin", new ConfigSmeltingEntry(0.7f, 2));
  }

  public ConfigSmeltingEntry get(String name) {
    return this.entryMap.get(name);
  }
}
