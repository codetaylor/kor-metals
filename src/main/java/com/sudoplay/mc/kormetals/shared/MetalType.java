package com.sudoplay.mc.kormetals.shared;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.item.ISubType;

/**
 * Created by sk3lls on 11/9/2016.
 */
public enum MetalType implements
    ISubType {

  @SerializedName("aluminum")
  Aluminum(0, "aluminum"),

  @SerializedName("copper")
  Copper(1, "copper"),

  @SerializedName("lead")
  Lead(2, "lead"),

  @SerializedName("nickel")
  Nickel(3, "nickel"),

  @SerializedName("platinum")
  Platinum(4, "platinum"),

  @SerializedName("silver")
  Silver(5, "silver"),

  @SerializedName("tin")
  Tin(6, "tin"),

  @SerializedName("zinc")
  Zinc(7, "zinc");

  private int meta;
  private String name;

  MetalType(int meta, String name) {
    this.meta = meta;
    this.name = name;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getMeta() {
    return this.meta;
  }

  public static MetalType fromName(String name) {

    for (MetalType metalType : MetalType.values()) {

      if (metalType.name.equals(name)) {
        return metalType;
      }
    }
    throw new IllegalArgumentException("Unknown metal type: " + name);
  }
}
