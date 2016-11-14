package com.sudoplay.mc.kormetals.module.nugget;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterItemsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterRecipesEvent;
import com.sudoplay.mc.kormetals.module.nugget.item.ItemNugget;
import com.sudoplay.mc.kormetals.module.nugget.recipe.RecipeShapelessNuggetDelegate;

import java.io.File;

/**
 * Created by sk3lls on 11/13/2016.
 */
public class ModuleNugget implements
    IKorModule {

  public static final String MODULE_ID = "module_nugget";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";
    public static final String CATEGORY_NUGGET = "1:nugget";
    public static final String CATEGORY_RECIPE_INGOT = "2:recipe:ingot";
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
            new ModuleNuggetConfigAdapter()
        );
  }

  @Subscribe
  public void onRegisterItems(OnRegisterItemsEvent event) {
    event.getRegistryService().register(

        ItemNugget.class
    );
  }

  @Subscribe
  public void onRegisterRecipes(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        RecipeShapelessNuggetDelegate.class
    );
  }

}
