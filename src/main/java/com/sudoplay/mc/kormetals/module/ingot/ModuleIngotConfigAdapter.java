package com.sudoplay.mc.kormetals.module.ingot;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by sk3lls on 11/12/2016.
 */
public class ModuleIngotConfigAdapter implements
    KorForgeConfigurationAdapter<TextConfigData> {

  @Override
  public void adapt(Configuration configuration, TextConfigData textConfigData) {
    String category;

    category = ModuleIngot.Config.CATEGORY_INGOT;

    configuration.addCustomCategoryComment(
        category,
        "Ingots toggled off here will not be loaded. Consequently, disabled\n" +
            "ingots will also have their ore to ingot smelting recipes removed."
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

    category = ModuleIngot.Config.CATEGORY_RECIPE_SMELTING;

    configuration.addCustomCategoryComment(
        category,
        "Ingots toggled off here will not be loaded. Consequently, disabled\n" +
            "ingots will also have their ore to ingot smelting recipes removed."
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

  private void adaptBoolean(String category, String key, boolean defaultValue, Configuration configuration, TextConfigData textConfigData) {
    boolean value = configuration.get(category, key, defaultValue).getBoolean();
    textConfigData.getCategory(category).putBoolean(key, value);
  }
}
