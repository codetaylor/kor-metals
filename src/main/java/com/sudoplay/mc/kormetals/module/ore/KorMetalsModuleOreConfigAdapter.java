package com.sudoplay.mc.kormetals.module.ore;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.forge.KorForgeConfigurationAdapter;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by sk3lls on 11/8/2016.
 */
public class KorMetalsModuleOreConfigAdapter implements
    KorForgeConfigurationAdapter<TextConfigData> {

  public static final String CATEGORY_ORE = "Ore";
  public static final String CATEGORY_ORE_GENERATION = "Ore Generation";

  @Override
  public void adapt(Configuration configuration, TextConfigData textConfigData) {
    adaptOres(configuration, textConfigData);
  }

  private void adaptOres(Configuration configuration, TextConfigData textConfigData) {
    String category;

    category = CATEGORY_ORE;

    configuration.addCustomCategoryComment(
        category,
        "Toggle the availability of ore groups. Turning off ores here will also prevent the\n" +
            "ore from spawning in the world."
    );

    adaptBoolean(category, "ore", true, "Copper, Lead, Nickel, Platinum, Silver, Tin", configuration, textConfigData);
    adaptBoolean(category, "nether_ore", true, "Copper, Lead, Nickel, Platinum, Silver, Tin", configuration, textConfigData);
    adaptBoolean(category, "ore_alloy", false, "Brass, Electrum, Enderium, Invar, Lumium, Signalum", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_alloy", false, "Brass, Electrum, Enderium, Invar, Lumium, Signalum", configuration, textConfigData);

    category = CATEGORY_ORE_GENERATION;

    configuration.addCustomCategoryComment(
        category,
        "Toggle each ore's world generation on or off."
    );

    adaptBoolean(category, "copper", true, "Toggle copper ore generation", configuration, textConfigData);
    adaptBoolean(category, "lead", true, "Toggle lead ore generation", configuration, textConfigData);
    adaptBoolean(category, "nickel", true, "Toggle nickel ore generation", configuration, textConfigData);
    adaptBoolean(category, "platinum", true, "Toggle platinum ore generation", configuration, textConfigData);
    adaptBoolean(category, "silver", true, "Toggle silver ore generation", configuration, textConfigData);
    adaptBoolean(category, "tin", true, "Toggle tin ore generation", configuration, textConfigData);
  }

  private void adaptBoolean(String category, String key, boolean defaultValue, String comment, Configuration configuration, TextConfigData textConfigData) {
    boolean value = configuration.getBoolean(key, category, defaultValue, comment);
    textConfigData.getCategory(category).putBoolean(key, value);
  }

}
