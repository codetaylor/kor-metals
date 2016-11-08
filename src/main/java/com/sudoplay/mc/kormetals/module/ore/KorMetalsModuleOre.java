package com.sudoplay.mc.kormetals.module.ore;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.registry.service.IRegistryService;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.OnRegisterBlocksEvent;
import com.sudoplay.mc.kor.spi.event.OnRegisterCreativeTabsEvent;
import com.sudoplay.mc.kor.spi.event.OnRegisterWorldGenEvent;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockNetherOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOreAlloy;
import com.sudoplay.mc.kormetals.module.ore.world.*;

import static com.sudoplay.mc.kormetals.module.ore.KorMetalsModuleOreConfigAdapter.CATEGORY_ORE;
import static com.sudoplay.mc.kormetals.module.ore.KorMetalsModuleOreConfigAdapter.CATEGORY_ORE_GENERATION;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class KorMetalsModuleOre implements
    IKorModule {

  public static final String MODULE_ID = "module_ore";

  @Override
  public String getKorModuleId() {
    return MODULE_ID;
  }

  @Subscribe
  public void onLoadConfigurations(OnLoadConfigurationsEvent event) {
    event.getConfigurationService().loadConfiguration(
        MODULE_ID,
        MODULE_ID + ".cfg",
        new KorMetalsModuleOreConfigAdapter()
    );
  }

  @Subscribe
  public void onRegisterCreativeTabsEvent(OnRegisterCreativeTabsEvent event) {
    event.getRegistryService()

        .register(KorMetalsCreativeTab.class)
    ;
  }

  @Subscribe
  public void onRegisterBlocksEvent(OnRegisterBlocksEvent event) {
    IRegistryService registry = event.getRegistryService();

    TextConfigData config = event.getConfigurationService().get(MODULE_ID + ".cfg");

    if (config
        .getCategory(CATEGORY_ORE)
        .getBoolean("ore")) {
      registry.register(BlockOre.class);
    }

    if (config
        .getCategory(CATEGORY_ORE)
        .getBoolean("nether_ore")) {
      registry.register(BlockNetherOre.class);
    }

    if (config
        .getCategory(CATEGORY_ORE)
        .getBoolean("ore_alloy")) {
      registry.register(BlockOreAlloy.class);
    }

    if (config
        .getCategory(CATEGORY_ORE)
        .getBoolean("nether_ore_alloy")) {
      registry.register(BlockNetherOreAlloy.class);
    }
  }

  @Subscribe
  public void onRegisterWorldGenEvent(OnRegisterWorldGenEvent event) {
    IRegistryService registry = event.getRegistryService();

    TextConfigData config = event.getConfigurationService().get(MODULE_ID + ".cfg");

    registerOreGeneration(WorldGenCopperOre.class, "copper", CATEGORY_ORE_GENERATION, registry, config);
    registerOreGeneration(WorldGenLeadOre.class, "lead", CATEGORY_ORE_GENERATION, registry, config);
    registerOreGeneration(WorldGenNickelOre.class, "nickel", CATEGORY_ORE_GENERATION, registry, config);
    registerOreGeneration(WorldGenPlatinumOre.class, "platinum", CATEGORY_ORE_GENERATION, registry, config);
    registerOreGeneration(WorldGenSilverOre.class, "silver", CATEGORY_ORE_GENERATION, registry, config);
    registerOreGeneration(WorldGenTinOre.class, "tin", CATEGORY_ORE_GENERATION, registry, config);
  }

  private void registerOreGeneration(Class<?> aClass, String key, String category, IRegistryService registry, TextConfigData config) {

    if (config.getCategory(category).getBoolean(key)) {
      registry.register(aClass);
    }
  }
}
