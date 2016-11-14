package com.sudoplay.mc.kormetals.module.nugget;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by sk3lls on 11/12/2016.
 */
public class ModuleNuggetConfigAdapter implements
    KorForgeConfigurationAdapter<TextConfigData> {

  @Override
  public void adapt(Configuration configuration, TextConfigData textConfigData) {
    String category;

    category = ModuleNugget.Config.CATEGORY_NUGGET;

    configuration.addCustomCategoryComment(
        category,
        "Nuggets toggled off here will not be loaded. Consequently, disabled\n" +
            "nuggets will also have their ingot to nugget recipes removed."
    );

    adaptBoolean(category, "copper", true, configuration, textConfigData);
    adaptBoolean(category, "lead", true, configuration, textConfigData);
    adaptBoolean(category, "nickel", true, configuration, textConfigData);
    adaptBoolean(category, "platinum", true, configuration, textConfigData);
    adaptBoolean(category, "silver", true, configuration, textConfigData);
    adaptBoolean(category, "tin", true, configuration, textConfigData);

    adaptBoolean(category, "brass", true, configuration, textConfigData);
    adaptBoolean(category, "electrum", true, configuration, textConfigData);
    adaptBoolean(category, "enderium", true, configuration, textConfigData);
    adaptBoolean(category, "invar", true, configuration, textConfigData);
    adaptBoolean(category, "lumium", true, configuration, textConfigData);
    adaptBoolean(category, "signalum", true, configuration, textConfigData);

    category = ModuleNugget.Config.CATEGORY_RECIPE_INGOT;

    configuration.addCustomCategoryComment(
        category,
        "The recipes to craft ingots into nuggets can be toggled here."
    );

    adaptBoolean(category, "copper", true, configuration, textConfigData);
    adaptBoolean(category, "lead", true, configuration, textConfigData);
    adaptBoolean(category, "nickel", true, configuration, textConfigData);
    adaptBoolean(category, "platinum", true, configuration, textConfigData);
    adaptBoolean(category, "silver", true, configuration, textConfigData);
    adaptBoolean(category, "tin", true, configuration, textConfigData);

    adaptBoolean(category, "brass", true, configuration, textConfigData);
    adaptBoolean(category, "electrum", true, configuration, textConfigData);
    adaptBoolean(category, "enderium", true, configuration, textConfigData);
    adaptBoolean(category, "invar", true, configuration, textConfigData);
    adaptBoolean(category, "lumium", true, configuration, textConfigData);
    adaptBoolean(category, "signalum", true, configuration, textConfigData);
  }

  private void adaptBoolean(String category, String key, boolean defaultValue, Configuration configuration, TextConfigData textConfigData) {
    boolean value = configuration.get(category, key, defaultValue).getBoolean();
    textConfigData.getCategory(category).putBoolean(key, value);
  }

}
