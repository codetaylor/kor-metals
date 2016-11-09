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

    category = ModuleOre.Config.CATEGORY_ORE;

    configuration.addCustomCategoryComment(
        category,
        "Toggle the availability of ore groups. Turning off ores here will also prevent the\n" +
            "ore from spawning in the world."
    );

    adaptBoolean(category, "ore_copper", true, "Toggle Copper Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_lead", true, "Toggle Lead Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_nickel", true, "Toggle Nickel Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_platinum", true, "Toggle Platinum Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_silver", true, "Toggle Silver Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_tin", true, "Toggle Tin Ore", configuration, textConfigData);

    adaptBoolean(category, "ore_brass", true, "Toggle Brass Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_electrum", true, "Toggle Electrum Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_enderium", true, "Toggle Enderium Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_invar", true, "Toggle Invar Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_lumium", true, "Toggle Lumium Ore", configuration, textConfigData);
    adaptBoolean(category, "ore_signalum", true, "Toggle Signalum Ore", configuration, textConfigData);

    adaptBoolean(category, "nether_ore_copper", true, "Toggle Nether Copper Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_lead", true, "Toggle Nether Lead Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_nickel", true, "Toggle Nether Nickel Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_platinum", true, "Toggle Nether Platinum Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_silver", true, "Toggle Nether Silver Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_tin", true, "Toggle Nether Tin Ore", configuration, textConfigData);

    adaptBoolean(category, "nether_ore_brass", true, "Toggle Nether Brass Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_electrum", true, "Toggle Nether Electrum Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_enderium", true, "Toggle Nether Enderium Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_invar", true, "Toggle Nether Invar Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_lumium", true, "Toggle Nether Lumium Ore", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_signalum", true, "Toggle Nether Signalum Ore", configuration, textConfigData);

    category = ModuleOre.Config.CATEGORY_ORE_GENERATION;

    configuration.addCustomCategoryComment(
        category,
        "Toggle each ore's world generation on or off."
    );

    adaptBoolean(category, "ore_copper", true, "Toggle Copper Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_lead", true, "Toggle Lead Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_nickel", true, "Toggle Nickel Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_platinum", true, "Toggle Platinum Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_silver", true, "Toggle Silver Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_tin", true, "Toggle Tin Ore generation", configuration, textConfigData);

    adaptBoolean(category, "ore_brass", true, "Toggle Brass Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_electrum", true, "Toggle Electrum Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_enderium", true, "Toggle Enderium Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_invar", true, "Toggle Invar Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_lumium", true, "Toggle Lumium Ore generation", configuration, textConfigData);
    adaptBoolean(category, "ore_signalum", true, "Toggle Signalum Ore generation", configuration, textConfigData);

    adaptBoolean(category, "nether_ore_copper", true, "Toggle Nether copper Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_lead", true, "Toggle Nether Lead Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_nickel", true, "Toggle Nether Nickel Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_platinum", true, "Toggle Nether Platinum Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_silver", true, "Toggle Nether Silver Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_tin", true, "Toggle Nether Tin Ore generation", configuration, textConfigData);

    adaptBoolean(category, "nether_ore_brass", true, "Toggle Nether Brass Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_electrum", true, "Toggle Nether Electrum Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_enderium", true, "Toggle Nether Enderium Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_invar", true, "Toggle Nether Invar Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_lumium", true, "Toggle Nether Lumium Ore generation", configuration, textConfigData);
    adaptBoolean(category, "nether_ore_signalum", true, "Toggle Nether Signalum Ore generation", configuration, textConfigData);
  }

  private void adaptBoolean(String category, String key, boolean defaultValue, String comment, Configuration configuration, TextConfigData textConfigData) {
    boolean value = configuration.getBoolean(key, category, defaultValue, comment);
    textConfigData.getCategory(category).putBoolean(key, value);
  }

}
