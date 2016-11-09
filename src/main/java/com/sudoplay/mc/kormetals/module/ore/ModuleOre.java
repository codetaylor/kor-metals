package com.sudoplay.mc.kormetals.module.ore;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnLoadConfigurationsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterBlocksEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterCreativeTabsEvent;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterWorldGenEvent;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.blocks.ore.netherrack.alloy.*;
import com.sudoplay.mc.kormetals.module.ore.blocks.ore.netherrack.regular.*;
import com.sudoplay.mc.kormetals.module.ore.blocks.ore.stone.alloy.*;
import com.sudoplay.mc.kormetals.module.ore.blocks.ore.stone.regular.*;
import com.sudoplay.mc.kormetals.module.ore.world.oregen.netherrack.alloy.*;
import com.sudoplay.mc.kormetals.module.ore.world.oregen.netherrack.regular.*;
import com.sudoplay.mc.kormetals.module.ore.world.oregen.stone.alloy.*;
import com.sudoplay.mc.kormetals.module.ore.world.oregen.stone.regular.*;

import java.io.File;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class ModuleOre implements
    IKorModule {

  public static final String MODULE_ID = "module_ore";

  public static class Config {
    public static final String FILENAME = MODULE_ID + "/" + MODULE_ID + ".cfg";
    public static final String CATEGORY_ORE = "Ore";
    public static final String CATEGORY_ORE_GENERATION = "Ore Generation";
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

        // Alloy ores
        BlockOreBrass.class,
        BlockOreElectrum.class,
        BlockOreEnderium.class,
        BlockOreInvar.class,
        BlockOreLumium.class,
        BlockOreSignalum.class,

        // Regular ores
        BlockOreCopper.class,
        BlockOreLead.class,
        BlockOreNickel.class,
        BlockOrePlatinum.class,
        BlockOreSilver.class,
        BlockOreTin.class,

        // Nether Alloy Ores
        BlockNetherOreBrass.class,
        BlockNetherOreElectrum.class,
        BlockNetherOreEnderium.class,
        BlockNetherOreInvar.class,
        BlockNetherOreLumium.class,
        BlockNetherOreSignalum.class,

        // Nether Regular Ores
        BlockNetherOreCopper.class,
        BlockNetherOreLead.class,
        BlockNetherOreNickel.class,
        BlockNetherOrePlatinum.class,
        BlockNetherOreSilver.class,
        BlockNetherOreTin.class
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
}
