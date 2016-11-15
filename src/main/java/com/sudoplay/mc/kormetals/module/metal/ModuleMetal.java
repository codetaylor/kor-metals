package com.sudoplay.mc.kormetals.module.metal;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterItemsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterRecipesEvent;
import com.sudoplay.mc.kormetals.module.metal.item.ItemIngot;
import com.sudoplay.mc.kormetals.module.metal.recipe.RecipeShapelessIngotDelegate;
import com.sudoplay.mc.kormetals.module.metal.recipe.RecipeSmeltingIngotDelegate;
import com.sudoplay.mc.kormetals.module.metal.item.ItemNugget;
import com.sudoplay.mc.kormetals.module.metal.recipe.RecipeShapelessNuggetDelegate;

import java.io.File;

/**
 * Created by sk3lls on 11/14/2016.
 */
public class ModuleMetal implements
    IKorModule {

  public static final String MODULE_ID = "metal";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";

    public static final String CATEGORY_INGOT = "1:ingot";
    public static final String CATEGORY_INGOT_RECIPE_SMELTING = "2:ingot:recipe:smelting";
    public static final String CATEGORY_INGOT_RECIPE_NUGGET = "3:ingot:recipe:nugget";

    public static final String CATEGORY_NUGGET = "4:nugget";
    public static final String CATEGORY_NUGGET_RECIPE_INGOT = "5:nugget:recipe:ingot";
  }

  @Override
  public String getKorModuleId() {
    return MODULE_ID;
  }

  @Subscribe
  public void onLoadConfigurations(OnLoadConfigurationsEvent event) {
    event.getConfigurationService()

        .loadConfiguration(
            new File(ModuleMetal.Config.FILENAME),
            new ModuleMetalConfigAdapter()
        );
  }

  @Subscribe
  public void onRegisterItems(OnRegisterItemsEvent event) {
    event.getRegistryService().register(

        ItemIngot.class,
        ItemNugget.class
    );
  }

  @Subscribe
  public void onRegisterRecipes(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        RecipeSmeltingIngotDelegate.class,
        RecipeShapelessIngotDelegate.class,
        RecipeShapelessNuggetDelegate.class
    );
  }
}
