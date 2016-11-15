package com.sudoplay.mc.kormetals.module.ore;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
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

    adaptBoolean(category, "copper", true, configuration, textConfigData);
    adaptBoolean(category, "lead", true, configuration, textConfigData);
    adaptBoolean(category, "nickel", true, configuration, textConfigData);
    adaptBoolean(category, "platinum", true, configuration, textConfigData);
    adaptBoolean(category, "silver", true, configuration, textConfigData);
    adaptBoolean(category, "tin", true, configuration, textConfigData);

    adaptBoolean(category, "brass", false, configuration, textConfigData);
    adaptBoolean(category, "electrum", false, configuration, textConfigData);
    adaptBoolean(category, "enderium", false, configuration, textConfigData);
    adaptBoolean(category, "invar", false, configuration, textConfigData);
    adaptBoolean(category, "lumium", false, configuration, textConfigData);
    adaptBoolean(category, "signalum", false, configuration, textConfigData);

    category = ModuleOre.Config.CATEGORY_BLOCK_ORE_NETHER;

    configuration.addCustomCategoryComment(
        category,
        "Turning off an ore here will prevent it from being loaded and also\n" +
            "prevent the ore from spawning in the world. To edit each ore's properties,\n" +
            "see nether_ore_properties.json."
    );

    adaptBoolean(category, "copper", true, configuration, textConfigData);
    adaptBoolean(category, "lead", true, configuration, textConfigData);
    adaptBoolean(category, "nickel", true, configuration, textConfigData);
    adaptBoolean(category, "platinum", true, configuration, textConfigData);
    adaptBoolean(category, "silver", true, configuration, textConfigData);
    adaptBoolean(category, "tin", true, configuration, textConfigData);

    adaptBoolean(category, "brass", false, configuration, textConfigData);
    adaptBoolean(category, "electrum", false, configuration, textConfigData);
    adaptBoolean(category, "enderium", false, configuration, textConfigData);
    adaptBoolean(category, "invar", false, configuration, textConfigData);
    adaptBoolean(category, "lumium", false, configuration, textConfigData);
    adaptBoolean(category, "signalum", false, configuration, textConfigData);

    category = ModuleOre.Config.CATEGORY_WORLDGEN_ORE_OVERWORLD;

    configuration.addCustomCategoryComment(
        category,
        "Toggle ore generation for Dimension 0 (Overworld). To edit ore\n" +
            "generation properties, look in the oregen folder."
    );

    adaptBoolean(category, "copper", true, configuration, textConfigData);
    adaptBoolean(category, "lead", true, configuration, textConfigData);
    adaptBoolean(category, "nickel", true, configuration, textConfigData);
    adaptBoolean(category, "platinum", true, configuration, textConfigData);
    adaptBoolean(category, "silver", true, configuration, textConfigData);
    adaptBoolean(category, "tin", true, configuration, textConfigData);

    adaptBoolean(category, "brass", false, configuration, textConfigData);
    adaptBoolean(category, "electrum", false, configuration, textConfigData);
    adaptBoolean(category, "enderium", false, configuration, textConfigData);
    adaptBoolean(category, "invar", false, configuration, textConfigData);
    adaptBoolean(category, "lumium", false, configuration, textConfigData);
    adaptBoolean(category, "signalum", false, configuration, textConfigData);

    category = ModuleOre.Config.CATEGORY_WORLDGEN_ORE_NETHER;

    configuration.addCustomCategoryComment(
        category,
        "Toggle ore generation for Dimension -1 (Nether). To edit ore\n" +
            "generation properties, look in the oregen folder."
    );

    adaptBoolean(category, "copper", true, configuration, textConfigData);
    adaptBoolean(category, "lead", true, configuration, textConfigData);
    adaptBoolean(category, "nickel", true, configuration, textConfigData);
    adaptBoolean(category, "platinum", true, configuration, textConfigData);
    adaptBoolean(category, "silver", true, configuration, textConfigData);
    adaptBoolean(category, "tin", true, configuration, textConfigData);

    adaptBoolean(category, "brass", false, configuration, textConfigData);
    adaptBoolean(category, "electrum", false, configuration, textConfigData);
    adaptBoolean(category, "enderium", false, configuration, textConfigData);
    adaptBoolean(category, "invar", false, configuration, textConfigData);
    adaptBoolean(category, "lumium", false, configuration, textConfigData);
    adaptBoolean(category, "signalum", false, configuration, textConfigData);

    category = ModuleOre.Config.CATEGORY_SMELTING_NETHER_ORE_TO_ORE;

    configuration.addCustomCategoryComment(
        category,
        "Toggle the nether ore smelting recipes."
    );

    adaptBoolean(category, "copper", true, configuration, textConfigData);
    adaptBoolean(category, "lead", true, configuration, textConfigData);
    adaptBoolean(category, "nickel", true, configuration, textConfigData);
    adaptBoolean(category, "platinum", true, configuration, textConfigData);
    adaptBoolean(category, "silver", true, configuration, textConfigData);
    adaptBoolean(category, "tin", true, configuration, textConfigData);

    adaptBoolean(category, "brass", false, configuration, textConfigData);
    adaptBoolean(category, "electrum", false, configuration, textConfigData);
    adaptBoolean(category, "enderium", false, configuration, textConfigData);
    adaptBoolean(category, "invar", false, configuration, textConfigData);
    adaptBoolean(category, "lumium", false, configuration, textConfigData);
    adaptBoolean(category, "signalum", false, configuration, textConfigData);
  }

  private void adaptBoolean(String category, String key, boolean defaultValue, String comment, Configuration configuration, TextConfigData textConfigData) {
    boolean value = configuration.getBoolean(key, category, defaultValue, comment);
    textConfigData.getCategory(category).putBoolean(key, value);
  }

  private void adaptBoolean(String category, String key, boolean defaultValue, Configuration configuration, TextConfigData textConfigData) {
    boolean value = configuration.get(category, key, defaultValue).getBoolean();
    textConfigData.getCategory(category).putBoolean(key, value);
  }

}
