package com.sudoplay.mc.kormetals.module.metal;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by sk3lls on 11/12/2016.
 */
public class ModuleMetalConfigAdapter implements
    KorForgeConfigurationAdapter<TextConfigData> {

  @Override
  public void adapt(Configuration configuration, TextConfigData textConfigData) {
    String category;

    category = ModuleMetal.Config.CATEGORY_ITEM_INGOT;

    configuration.addCustomCategoryComment(
        category,
        "Ingots toggled off here will not be loaded. Consequently, disabling an\n" +
            "ingot will also disable any recipes that produce the item."
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

    category = ModuleMetal.Config.CATEGORY_SMELTING_ORE_TO_INGOT;

    configuration.addCustomCategoryComment(
        category,
        "Toggle ore -> ingot smelting recipes here."
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

    category = ModuleMetal.Config.CATEGORY_RECIPE_NUGGET_TO_INGOT;

    configuration.addCustomCategoryComment(
        category,
        "Toggle nuggets -> ingot recipes here."
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

    category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET;

    configuration.addCustomCategoryComment(
        category,
        "Nuggets toggled off here will not be loaded. Consequently, disabling a\n" +
            "nugget will also disable any recipes that produce the item."
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

    category = ModuleMetal.Config.CATEGORY_RECIPE_INGOT_TO_NUGGET;

    configuration.addCustomCategoryComment(
        category,
        "Toggle ingot -> nuggets recipes here."
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

    category = ModuleMetal.Config.CATEGORY_ITEM_DUST;

    configuration.addCustomCategoryComment(
        category,
        "Dusts toggled off here will not be loaded. Consequently, disabling a\n" +
            "dust will also disable any recipes that produce the item."
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

    category = ModuleMetal.Config.CATEGORY_SMELTING_DUST_TO_INGOT;

    configuration.addCustomCategoryComment(
        category,
        "Toggle dust -> ingot smelting recipes here."
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

    category = ModuleMetal.Config.CATEGORY_BLOCK_METAL;

    configuration.addCustomCategoryComment(
        category,
        "Blocks toggled off here will not be loaded. Consequently, disabling an\n" +
            "block will also disable any recipes that produce the item."
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

    category = ModuleMetal.Config.CATEGORY_RECIPE_INGOT_TO_BLOCK;

    configuration.addCustomCategoryComment(
        category,
        "Toggle ingots -> block recipes here."
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
