package com.sudoplay.mc.kormetals.shared;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.item.ISubType;

/**
 * Created by sk3lls on 11/9/2016.
 */
public enum MetalAlloyType implements
    ISubType {

  @SerializedName("aluminum_brass")
  AluminumBrass(0, "aluminum_brass"),

  @SerializedName("brass")
  Brass(1, "brass"),

  @SerializedName("bronze")
  Bronze(2, "bronze"),

  @SerializedName("constantan")
  Constantan(3, "constantan"),

  @SerializedName("electrum")
  Electrum(4, "electrum"),

  @SerializedName("enderium")
  Enderium(5, "enderium"),

  @SerializedName("invar")
  Invar(6, "invar"),

  @SerializedName("lumium")
  Lumium(7, "lumium"),

  @SerializedName("signalum")
  Signalum(8, "signalum"),

  @SerializedName("steel")
  Steel(9, "steel");

  private int meta;
  private String name;

  MetalAlloyType(int meta, String name) {
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

  public static MetalAlloyType fromName(String name) {

    for (MetalAlloyType metalType : MetalAlloyType.values()) {

      if (metalType.name.equals(name)) {
        return metalType;
      }
    }
    throw new IllegalArgumentException("Unknown metal type: " + name);
  }
}
