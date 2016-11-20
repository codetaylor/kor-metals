package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.kor.spi.registry.strategy.KorRegistrationStrategy;
import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;
import com.sudoplay.mc.kor.spi.world.KorWorldGen;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigOreGen;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class WorldGenOreRegistrationDelegate extends
    KorRegistrationDelegate {

  private ConfigOreGen config;
  private TextConfigData textConfigData;

  @KorInject
  public WorldGenOreRegistrationDelegate(
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "ore_gen.json") ConfigOreGen config,
      @KorTextConfig(file = ModuleOre.Config.FILENAME) TextConfigData textConfigData
  ) {
    this.config = config;
    this.textConfigData = textConfigData;
  }

  @Override
  public KorInitStrategy getInitStrategy() {
    return (kor) -> {

      KorOreGenConfigEntry configEntry;

      for (MetalType metalType : MetalType.values()) {
        String name = metalType.getName();
        configEntry = this.config.getConfigEntryMap().get(name);

        if (isRegistrationNeeded(configEntry, name)) {
          new KorWorldGen(configEntry, kor.get(BlockOre.class).getDefaultState().withProperty(BlockOre.TYPE, metalType)).getInitStrategy().onInit(kor);
        }
      }

      for (MetalAlloyType metalType : MetalAlloyType.values()) {
        String name = metalType.getName();
        configEntry = this.config.getConfigEntryMap().get(name);

        if (isRegistrationNeeded(configEntry, name)) {
          new KorWorldGen(configEntry, kor.get(BlockOreAlloy.class).getDefaultState().withProperty(BlockOreAlloy.TYPE, metalType)).getInitStrategy().onInit(kor);
        }
      }
    };
  }

  private boolean isRegistrationNeeded(KorOreGenConfigEntry configEntry, String name) {
    return configEntry != null
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_WORLDGEN_ORE_OVERWORLD).getBoolean(name);
  }
}
