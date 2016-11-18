package com.sudoplay.mc.kormetals.module.ore;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import com.sudoplay.mc.kormetals.util.ConfigUtil;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by sk3lls on 11/8/2016.
 */
public class ModuleOreConfigAdapter implements
    KorForgeConfigurationAdapter<TextConfigData> {

  @Override
  public void adapt(Configuration configuration, TextConfigData textConfigData) {
    adaptOres(configuration, textConfigData);
  }

  private void adaptOres(Configuration configuration, TextConfigData textConfigData) {
    String category;

    category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD;

    configuration.addCustomCategoryComment(
        category,
        "Turning off an ore here will prevent it from being loaded and also\n" +
            "prevent the ore from spawning in the world. To edit each ore's properties,\n" +
            "see ore_properties.json."
    );

    ConfigUtil.setBaseMetals(category, configuration, textConfigData, true);
    ConfigUtil.setAlloyMetals(category, configuration, textConfigData, false);

    category = ModuleOre.Config.CATEGORY_BLOCK_ORE_NETHER;

    configuration.addCustomCategoryComment(
        category,
        "Turning off an ore here will prevent it from being loaded and also\n" +
            "prevent the ore from spawning in the world. To edit each ore's properties,\n" +
            "see nether_ore_properties.json."
    );

    ConfigUtil.setBaseMetals(category, configuration, textConfigData, true);
    ConfigUtil.setAlloyMetals(category, configuration, textConfigData, false);

    category = ModuleOre.Config.CATEGORY_WORLDGEN_ORE_OVERWORLD;

    configuration.addCustomCategoryComment(
        category,
        "Toggle ore generation for Dimension 0 (Overworld). To edit ore\n" +
            "generation properties, look in the worldgen folder."
    );

    ConfigUtil.setBaseMetals(category, configuration, textConfigData, true);
    ConfigUtil.setAlloyMetals(category, configuration, textConfigData, false);

    category = ModuleOre.Config.CATEGORY_WORLDGEN_ORE_NETHER;

    configuration.addCustomCategoryComment(
        category,
        "Toggle ore generation for Dimension -1 (Nether). To edit ore\n" +
            "generation properties, look in the worldgen folder."
    );

    ConfigUtil.setBaseMetals(category, configuration, textConfigData, true);
    ConfigUtil.setAlloyMetals(category, configuration, textConfigData, false);
  }

}
