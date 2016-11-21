package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockEndOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockEndOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigEndOreGen;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class WorldGenEndOreRegistrationDelegate extends
    AbstractWorldGenOreRegistrationDelegate {

  private TextConfigData textConfigData;

  @KorInject
  public WorldGenEndOreRegistrationDelegate(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "end_ore_gen.json") ConfigEndOreGen config,
      @KorTextConfig(file = ModuleOre.Config.FILENAME) TextConfigData textConfigData
  ) {
    super(config, BlockEndOre.TYPE, kor.get(BlockEndOre.class), BlockEndOreAlloy.TYPE, kor.get(BlockEndOreAlloy.class));
    this.textConfigData = textConfigData;
  }

  @Override
  public boolean isRegistrationPermitted(KorOreGenConfigEntry configEntry, String name) {
    return configEntry != null
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_WORLDGEN_ORE_END).getBoolean(name)
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_END).getBoolean(name);
  }
}
