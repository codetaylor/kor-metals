package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.config.json.component.common.MinMaxInt;
import com.sudoplay.mc.kor.spi.config.json.component.world.oregen.DimensionProfile;
import com.sudoplay.mc.kor.spi.config.json.component.world.oregen.KorOreGenConfig;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.world.KorWorldGen;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOreAlloy;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;

/**
 * Created by sk3lls on 11/8/2016.
 */
@KorRegistrationTextConfigDependency(dependsOn = {
    // is the ore turned off?
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD,
        key = "electrum"
    ),
    // is the oregen turned off?
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_WORLDGEN_ORE_OVERWORLD,
        key = "electrum"
    )
})

public class WorldGenOreElectrum extends
    KorWorldGen {

  // --------------------------------------------------------------------------
  // - Config

  private static class Config extends
      KorOreGenConfig {

    static final int MOD_GENERATION_WEIGHT = 0;

    public Config() {
      super(
          MOD_GENERATION_WEIGHT,
          new DimensionProfile(0, 3, "minecraft:stone", new MinMaxInt(1, 2), new MinMaxInt(5, 30))
      );
    }
  }

  // --------------------------------------------------------------------------
  @KorInject
  public WorldGenOreElectrum(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.Config.OreGenOverworld.CONFIG_PATH, file = "electrum.json") Config config
  ) {
    super(
        config,
        kor.get(BlockOreAlloy.class).getDefaultState().withProperty(BlockOreAlloy.TYPE, MetalAlloyType.Electrum)
    );
  }
}
