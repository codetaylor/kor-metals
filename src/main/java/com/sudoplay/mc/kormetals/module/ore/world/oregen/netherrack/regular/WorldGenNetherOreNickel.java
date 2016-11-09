package com.sudoplay.mc.kormetals.module.ore.world.oregen.netherrack.regular;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.config.json.component.common.MinMaxInt;
import com.sudoplay.mc.kor.spi.config.json.component.world.oregen.DimensionProfile;
import com.sudoplay.mc.kor.spi.config.json.component.world.oregen.KorOreGenConfig;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationClassDependency;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.world.KorWorldGen;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.ore.netherrack.regular.BlockNetherOreNickel;

/**
 * Created by sk3lls on 11/8/2016.
 */
@KorRegistrationTextConfigDependency(
    filename = ModuleOre.Config.FILENAME,
    category = ModuleOre.Config.CATEGORY_ORE_GENERATION,
    key = "nether_ore_nickel"
)

@KorRegistrationClassDependency(dependsOn = {
    BlockNetherOreNickel.class
})

public class WorldGenNetherOreNickel extends
    KorWorldGen {

  // --------------------------------------------------------------------------
  // - Config

  private static class Config extends
      KorOreGenConfig {

    static final int MOD_GENERATION_WEIGHT = 0;

    public Config() {
      super(
          MOD_GENERATION_WEIGHT,
          new DimensionProfile(-1, 3, "minecraft:netherrack", new MinMaxInt(2, 3), new MinMaxInt(10, 100))
      );
    }
  }

  // --------------------------------------------------------------------------
  @KorInject
  public WorldGenNetherOreNickel(
      Kor kor,
      @KorConfig(path = ModuleOre.MODULE_ID + "/world", file = "nether_ore_nickel.json") Config config
  ) {
    super(
        config,
        kor.get(BlockNetherOreNickel.class).getDefaultState()
    );
  }
}
