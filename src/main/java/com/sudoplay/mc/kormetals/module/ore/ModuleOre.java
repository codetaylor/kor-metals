package com.sudoplay.mc.kormetals.module.ore;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.*;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.block.*;
import com.sudoplay.mc.kormetals.module.ore.recipe.RecipeRegistrationDelegate;
import com.sudoplay.mc.kormetals.module.ore.worldgen.WorldGenEndOreRegistrationDelegate;
import com.sudoplay.mc.kormetals.module.ore.worldgen.WorldGenNetherOreRegistrationDelegate;
import com.sudoplay.mc.kormetals.module.ore.worldgen.WorldGenOverworldOreRegistrationDelegate;

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
    public static final String CATEGORY_BLOCK_ORE_DENSE_OVERWORLD = "1:block:ore_dense_overworld";

    public static final String CATEGORY_BLOCK_ORE_NETHER = "1:block:ore_nether";
    public static final String CATEGORY_BLOCK_ORE_DENSE_NETHER = "1:block:ore_dense_nether";

    public static final String CATEGORY_BLOCK_ORE_END = "1:block:ore_end";
    public static final String CATEGORY_BLOCK_ORE_DENSE_END = "1:block:ore_dense_end";

    public static final String CATEGORY_WORLDGEN_ORE_OVERWORLD = "1:worldgen:ore_overworld";
    public static final String CATEGORY_WORLDGEN_ORE_DENSE_OVERWORLD = "1:worldgen:ore_dense_overworld";

    public static final String CATEGORY_WORLDGEN_ORE_NETHER = "1:worldgen:ore_nether";
    public static final String CATEGORY_WORLDGEN_ORE_DENSE_NETHER = "1:worldgen:ore_dense_nether";

    public static final String CATEGORY_WORLDGEN_ORE_END = "1:worldgen:ore_end";
    public static final String CATEGORY_WORLDGEN_ORE_DENSE_END = "1:worldgen:ore_dense_end";
  }

  @Override
  public String getKorModuleId() {
    return MODULE_ID;
  }

  @Subscribe
  public void onLoadConfigurationsEvent(OnLoadConfigurationsEvent event) {
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
        BlockOreDense.class,
        BlockOreAlloy.class,
        BlockOreAlloyDense.class,

        BlockNetherOre.class,
        BlockNetherOreAlloy.class,

        BlockEndOre.class,
        BlockEndOreAlloy.class
    );
  }

  @Subscribe
  public void onRegisterWorldGenEvent(OnRegisterWorldGenEvent event) {
    event.getRegistryService().register(

        WorldGenOverworldOreRegistrationDelegate.class,
        WorldGenNetherOreRegistrationDelegate.class,
        WorldGenEndOreRegistrationDelegate.class
    );
  }

  @Subscribe
  public void onRegisterRecipes(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        RecipeRegistrationDelegate.class
    );
  }
}
