package com.sudoplay.mc.kormetals.module.ore.core;

import com.sudoplay.mc.kor.core.IntMap;
import com.sudoplay.mc.kor.spi.item.ISubType;

/**
 * Created by sk3lls on 11/7/2016.
 */
public enum MetalAlloyType implements
    ISubType {

  Brass(0, "brass"),
  Electrum(1, "electrum"),
  Enderium(2, "enderium"),
  Invar(3, "invar"),
  Lumium(4, "lumium"),
  Signalum(5, "signalum");

  private static IntMap<MetalAlloyType> MAP;

  public final int meta;
  public final String name;

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

  public static MetalAlloyType fromMeta(int meta) {

    MetalAlloyType[] values = values();

    if (meta < 0 || meta >= values.length) {
      throw new IllegalArgumentException("Meta must be zero or greater and no larger than " + values.length + ", was " + meta);
    }

    if (MAP == null) {
      MAP = new IntMap<>();

      for (MetalAlloyType metalType : values) {
        MAP.put(metalType.getMeta(), metalType);
      }
    }

    return MAP.get(meta);
  }
}
