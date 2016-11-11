package com.sudoplay.mc.kormetals.shared;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.spi.item.ISubType;

/**
 * Created by sk3lls on 11/9/2016.
 */
public enum MetalType implements
    ISubType {

  @SerializedName("brass")
  Brass(0, "brass"),

  @SerializedName("copper")
  Copper(1, "copper"),

  @SerializedName("electrum")
  Electrum(2, "electrum"),

  @SerializedName("enderium")
  Enderium(3, "enderium"),

  @SerializedName("invar")
  Invar(4, "invar"),

  @SerializedName("lead")
  Lead(5, "lead"),

  @SerializedName("lumium")
  Lumium(6, "lumium"),

  @SerializedName("nickel")
  Nickel(7, "nickel"),

  @SerializedName("platinum")
  Platinum(8, "platinum"),

  @SerializedName("signalum")
  Signalum(9, "signalum"),

  @SerializedName("silver")
  Silver(10, "silver"),

  @SerializedName("tin")
  Tin(11, "tin");

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
}
