package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigOreGen;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class WorldGenOverworldOreRegistrationDelegate extends
    AbstractWorldGenOreRegistrationDelegate {

  private TextConfigData textConfigData;

  @KorInject
  public WorldGenOverworldOreRegistrationDelegate(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "ore_gen.json") ConfigOreGen config,
      @KorTextConfig(file = ModuleOre.Config.FILENAME) TextConfigData textConfigData
  ) {
    super(config, BlockOre.TYPE, kor.get(BlockOre.class), BlockOreAlloy.TYPE, kor.get(BlockOreAlloy.class));
    this.textConfigData = textConfigData;
  }

  @Override
  public boolean isRegistrationPermitted(KorOreGenConfigEntry configEntry, String name) {
    return configEntry != null
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_WORLDGEN_ORE_OVERWORLD).getBoolean(name)
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD).getBoolean(name);
  }
}
