package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockNetherOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOreAlloyDense;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOreDense;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigNetherOreGen;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class WorldGenNetherOreRegistrationDelegate extends
    AbstractWorldGenOreRegistrationDelegate {

  private TextConfigData textConfigData;

  @KorInject
  public WorldGenNetherOreRegistrationDelegate(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "nether_ore_gen.json") ConfigNetherOreGen config,
      @KorTextConfig(file = ModuleOre.Config.FILENAME) TextConfigData textConfigData
  ) {
    super(
        config,
        BlockNetherOre.TYPE,
        kor.get(BlockNetherOre.class),
        kor.get(BlockOreDense.class),
        BlockNetherOreAlloy.TYPE,
        kor.get(BlockNetherOreAlloy.class),
        kor.get(BlockOreAlloyDense.class)
    );
    this.textConfigData = textConfigData;
  }

  @Override
  public boolean isOreAllowed(KorOreGenConfigEntry configEntry, String name) {
    return configEntry != null
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_WORLDGEN_ORE_NETHER).getBoolean(name)
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_NETHER).getBoolean(name);
  }

  @Override
  protected boolean isDenseOreAllowed(KorOreGenConfigEntry configEntry, String name) {
    return configEntry != null
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_WORLDGEN_ORE_DENSE_NETHER).getBoolean(name)
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_NETHER).getBoolean(name);
  }
}
