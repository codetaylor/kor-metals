package com.sudoplay.mc.kormetals.module.ore;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.*;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.block.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockNetherOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.block.BlockOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.recipe.RecipeRegistrationDelegate;
import com.sudoplay.mc.kormetals.module.ore.worldgen.WorldGenNetherOreRegistrationDelegate;
import com.sudoplay.mc.kormetals.module.ore.worldgen.WorldGenOreRegistrationDelegate;

import java.io.File;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class ModuleOre implements
    IKorModule {

  public static final String MODULE_ID = "ore";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";
    public static final String CATEGORY_BLOCK_ORE_OVERWORLD = "1:block:ore_overworld";
    public static final String CATEGORY_BLOCK_ORE_NETHER = "1:block:ore_nether";
    public static final String CATEGORY_WORLDGEN_ORE_OVERWORLD = "1:worldgen:ore_overworld";
    public static final String CATEGORY_WORLDGEN_ORE_NETHER = "1:worldgen:ore_nether";
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
        BlockOreAlloy.class,
        BlockNetherOre.class,
        BlockNetherOreAlloy.class
    );
  }

  @Subscribe
  public void onRegisterWorldGenEvent(OnRegisterWorldGenEvent event) {
    event.getRegistryService().register(

        WorldGenOreRegistrationDelegate.class,
        WorldGenNetherOreRegistrationDelegate.class
    );
  }

  @Subscribe
  public void onRegisterRecipes(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        RecipeRegistrationDelegate.class
    );
  }
}
