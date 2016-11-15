package com.sudoplay.mc.kormetals.module.ore;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.*;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.recipe.RecipeSmeltingNetherOreDelegate;
import com.sudoplay.mc.kormetals.module.ore.worldgen.*;

import java.io.File;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class ModuleOre implements
    IKorModule {

  public static final String MODULE_ID = "ore";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";
    public static final String CATEGORY_ORE_OVERWORLD = "1:ore:overworld";
    public static final String CATEGORY_ORE_NETHER = "2:ore:nether";
    public static final String CATEGORY_ORE_OVERWORLD_GENERATION = "3:ore:overworld:generation";
    public static final String CATEGORY_ORE_NETHER_GENERATION = "4:ore:nether:generation";
    public static final String CATEGORY_RECIPE_SMELTING = "5:recipe:smelting";

    public static class OreGenOverworld {
      public static final String CONFIG_PATH = MODULE_ID + "/oregen/overworld";
    }

    public static class OreGenNether {
      public static final String CONFIG_PATH = MODULE_ID + "/oregen/nether";
    }
  }

  @Override
  public String getKorModuleId() {
    return MODULE_ID;
  }

  @Subscribe
  public void onLoadConfigurations(OnLoadConfigurationsEvent event) {
    event.getConfigurationService()

        .loadConfiguration(
            new File(Config.FILENAME),
            new ModuleOreConfigAdapter()
        );
  }

  @Subscribe
  public void onRegisterCreativeTabsEvent(OnRegisterCreativeTabsEvent event) {
    event.getRegistryService().register(

        // KorMetals Creative Tab
        KorMetalsCreativeTab.class
    );
  }

  @Subscribe
  public void onRegisterBlocksEvent(OnRegisterBlocksEvent event) {
    event.getRegistryService().register(

        BlockOre.class,
        BlockNetherOre.class
    );
  }

  @Subscribe
  public void onRegisterWorldGenEvent(OnRegisterWorldGenEvent event) {
    event.getRegistryService().register(

        // Alloy OreGen
        WorldGenOreBrass.class,
        WorldGenOreElectrum.class,
        WorldGenOreEnderium.class,
        WorldGenOreInvar.class,
        WorldGenOreLumium.class,
        WorldGenOreSignalum.class,

        // Regular OreGen
        WorldGenOreCopper.class,
        WorldGenOreLead.class,
        WorldGenOreNickel.class,
        WorldGenOrePlatinum.class,
        WorldGenOreSilver.class,
        WorldGenOreTin.class,

        // Nether Alloy OreGen
        WorldGenNetherOreBrass.class,
        WorldGenNetherOreElectrum.class,
        WorldGenNetherOreEnderium.class,
        WorldGenNetherOreInvar.class,
        WorldGenNetherOreLumium.class,
        WorldGenNetherOreSignalum.class,

        // Nether Regular OreGen
        WorldGenNetherOreCopper.class,
        WorldGenNetherOreLead.class,
        WorldGenNetherOreNickel.class,
        WorldGenNetherOrePlatinum.class,
        WorldGenNetherOreSilver.class,
        WorldGenNetherOreTin.class
    );
  }

  @Subscribe
  public void onRegisterRecipesEvent(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        // Smelting Nether Ore
        RecipeSmeltingNetherOreDelegate.class
    );
  }
}
