package com.sudoplay.mc.kormetals.module.ingot;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterItemsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterRecipesEvent;
import com.sudoplay.mc.kormetals.module.ingot.item.ItemIngot;
import com.sudoplay.mc.kormetals.module.ingot.recipe.*;

import java.io.File;

/**
 * Created by sk3lls on 11/12/2016.
 */
public class ModuleIngot implements
    IKorModule {

  public static final String MODULE_ID = "module_ingot";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";
    public static final String CATEGORY_INGOT = "1:ingot";
    public static final String CATEGORY_RECIPE_SMELTING = "2:recipe:smelting";
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
            new ModuleIngotConfigAdapter()
        );
  }

  @Subscribe
  public void onRegisterItems(OnRegisterItemsEvent event) {
    event.getRegistryService().register(

        ItemIngot.class
    );
  }

  @Subscribe
  public void onRegisterRecipes(OnRegisterRecipesEvent event) {
    event.getRegistryService().register(

        SmeltingIngotBrass.class,
        SmeltingIngotCopper.class,
        SmeltingIngotElectrum.class,
        SmeltingIngotEnderium.class,
        SmeltingIngotInvar.class,
        SmeltingIngotLead.class,
        SmeltingIngotLumium.class,
        SmeltingIngotNickel.class,
        SmeltingIngotPlatinum.class,
        SmeltingIngotSignalum.class,
        SmeltingIngotSilver.class,
        SmeltingIngotTin.class
    );
  }
}
