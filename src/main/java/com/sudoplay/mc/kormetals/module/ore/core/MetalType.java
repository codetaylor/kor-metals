package com.sudoplay.mc.kormetals.module.ore.core;

import com.sudoplay.mc.kor.core.IntMap;
import com.sudoplay.mc.kor.spi.item.ISubType;

/**
 * Created by sk3lls on 11/7/2016.
 */
public enum MetalType implements
    ISubType {

  Copper(0, "copper"),
  Lead(1, "lead"),
  Nickel(2, "nickel"),
  Platinum(3, "platinum"),
  Silver(4, "silver"),
  Tin(5, "tin");

  private static IntMap<MetalType> MAP;

  public final int meta;
  public final String name;

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

  public static MetalType fromMeta(int meta) {

    MetalType[] values = values();

    if (meta < 0 || meta >= values.length) {
      throw new IllegalArgumentException("Meta must be zero or greater and no larger than " + values.length + ", was " + meta);
    }

    if (MAP == null) {
      MAP = new IntMap<>();

      for (MetalType metalType : values) {
        MAP.put(metalType.getMeta(), metalType);
      }
    }

    return MAP.get(meta);
  }
}
