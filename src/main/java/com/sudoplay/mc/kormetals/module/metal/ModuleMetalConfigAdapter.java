package com.sudoplay.mc.kormetals.module.metal;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import com.sudoplay.mc.kormetals.util.ConfigUtil;
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

    ConfigUtil.setAllMetals(category, configuration, textConfigData, true);

    category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET;

    configuration.addCustomCategoryComment(
        category,
        "Nuggets toggled off here will not be loaded. Consequently, disabling a\n" +
            "nugget will also disable any recipes that produce the item."
    );

    ConfigUtil.setAllMetals(category, configuration, textConfigData, true);

    category = ModuleMetal.Config.CATEGORY_ITEM_DUST;

    configuration.addCustomCategoryComment(
        category,
        "Dusts toggled off here will not be loaded. Consequently, disabling a\n" +
            "dust will also disable any recipes that produce the item."
    );

    ConfigUtil.setAllMetals(category, configuration, textConfigData, true);

    category = ModuleMetal.Config.CATEGORY_BLOCK_METAL;

    configuration.addCustomCategoryComment(
        category,
        "Blocks toggled off here will not be loaded. Consequently, disabling a\n" +
            "block will also disable any recipes that produce the item."
    );

    ConfigUtil.setAllMetals(category, configuration, textConfigData, true);
  }
}
