package com.sudoplay.mc.kormetals.module.metal;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterItemsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterRecipesEvent;
import com.sudoplay.mc.kormetals.module.metal.item.ItemDust;
import com.sudoplay.mc.kormetals.module.metal.item.ItemIngot;
import com.sudoplay.mc.kormetals.module.metal.item.ItemNugget;
import com.sudoplay.mc.kormetals.module.metal.recipe.RecipeShapelessIngotToNuggetDelegate;
import com.sudoplay.mc.kormetals.module.metal.recipe.RecipeShapelessNuggetToIngotDelegate;
import com.sudoplay.mc.kormetals.module.metal.recipe.RecipeSmeltingDustToIngotDelegate;
import com.sudoplay.mc.kormetals.module.metal.recipe.RecipeSmeltingOreToIngotDelegate;

import java.io.File;

/**
 * Created by sk3lls on 11/14/2016.
 */
public class ModuleMetal implements
    IKorModule {

  public static final String MODULE_ID = "metal";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";

    public static final String CATEGORY_ITEM_INGOT = "1:item:ingot";
    public static final String CATEGORY_SMELTING_ORE_TO_INGOT = "1:smelting:ore_to_ingot";
    public static final String CATEGORY_RECIPE_NUGGET_TO_INGOT = "1:recipe:nugget_to_ingot";

    public static final String CATEGORY_ITEM_NUGGET = "2:item:nugget";
    public static final String CATEGORY_RECIPE_INGOT_TO_NUGGET = "2:recipe:ingot_to_nugget";

    public static final String CATEGORY_ITEM_DUST = "3:item:dust";
    public static final String CATEGORY_SMELTING_DUST_TO_INGOT = "3:smelting:dust_to_ingot";
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
        ItemNugget.class,
        ItemDust.class
    );
  }

  @Subscribe
  public void onRegisterRecipes(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        RecipeSmeltingOreToIngotDelegate.class,
        RecipeShapelessNuggetToIngotDelegate.class,
        RecipeShapelessIngotToNuggetDelegate.class,
        RecipeSmeltingDustToIngotDelegate.class
    );
  }
}
