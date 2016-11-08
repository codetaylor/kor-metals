package com.sudoplay.mc.kormetals.module.ore.world;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.config.json.component.common.MinMaxInt;
import com.sudoplay.mc.kor.spi.config.json.component.world.oregen.DimensionProfile;
import com.sudoplay.mc.kor.spi.config.json.component.world.oregen.KorOreGenConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.world.KorWorldGen;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.module.ore.KorMetalsModuleOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.core.MetalType;

/**
 * Created by sk3lls on 11/8/2016.
 */
public class WorldGenSilverOre extends
    KorWorldGen {

  // --------------------------------------------------------------------------
  // - Config

  private static class Config extends
      KorOreGenConfig {

    static final int MOD_GENERATION_WEIGHT = 1000;

    public Config() {
      super(
          MOD_GENERATION_WEIGHT,
          new DimensionProfile(0, 5, "minecraft:stone", new MinMaxInt(1, 6), new MinMaxInt(5, 30)),
          new DimensionProfile(0, 2, KorMetals.MOD_ID + ":ore_lead", new MinMaxInt(3, 4), new MinMaxInt(10, 35))
      );
    }
  }

  // --------------------------------------------------------------------------
  @KorInject
  public WorldGenSilverOre(
      Kor kor,
      @KorConfig(path = KorMetalsModuleOre.MODULE_ID + "/world", file = "silver_ore.json") Config config
  ) {
    super(
        config,
        kor.get(BlockOre.class).getDefaultState().withProperty(BlockOre.TYPE, MetalType.Silver)
    );
  }
}
