package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;
import com.sudoplay.mc.kor.spi.world.KorWorldGen;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockNetherOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigNetherOreGen;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class WorldGenNetherOreRegistrationDelegate extends
    KorRegistrationDelegate {

  private ConfigNetherOreGen config;
  private TextConfigData textConfigData;

  @KorInject
  public WorldGenNetherOreRegistrationDelegate(
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "nether_ore_gen.json") ConfigNetherOreGen config,
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
          new KorWorldGen(configEntry, kor.get(BlockNetherOre.class).getDefaultState().withProperty(BlockNetherOre.TYPE, metalType)).getInitStrategy().onInit(kor);
        }
      }

      for (MetalAlloyType metalType : MetalAlloyType.values()) {
        String name = metalType.getName();
        configEntry = this.config.getConfigEntryMap().get(name);

        if (isRegistrationNeeded(configEntry, name)) {
          new KorWorldGen(configEntry, kor.get(BlockNetherOreAlloy.class).getDefaultState().withProperty(BlockNetherOreAlloy.TYPE, metalType)).getInitStrategy().onInit(kor);
        }
      }
    };
  }

  private boolean isRegistrationNeeded(KorOreGenConfigEntry configEntry, String name) {
    return configEntry != null
        && textConfigData.getCategory(ModuleOre.Config.CATEGORY_WORLDGEN_ORE_NETHER).getBoolean(name);
  }
}
