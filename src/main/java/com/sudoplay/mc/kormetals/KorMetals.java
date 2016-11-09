package com.sudoplay.mc.kormetals;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static net.minecraftforge.fml.common.Mod.EventHandler;
import static net.minecraftforge.fml.common.Mod.Instance;

@net.minecraftforge.fml.common.Mod(
    modid = KorMetals.MOD_ID,
    version = KorMetals.VERSION,
    name = KorMetals.NAME
)
public class KorMetals extends
    Kor {

  public static final String MOD_ID = "ctkormetals";
  public static final String VERSION = "snapshot";
  public static final String NAME = "Kor Metals";
  public static final double JSON_CONFIGS_VERSION = 1.0;

  @SuppressWarnings("unused")
  @Instance
  public static KorMetals INSTANCE;

  @Override
  public double getJsonConfigsVersion() {
    return KorMetals.JSON_CONFIGS_VERSION;
  }

  @Override
  public String getModId() {
    return KorMetals.MOD_ID;
  }

  @Override
  public String getModVersion() {
    return KorMetals.VERSION;
  }

  @Override
  public String getModName() {
    return KorMetals.NAME;
  }

  @EventHandler
  protected void onPreInitialization(FMLPreInitializationEvent event) {

    this.registerModules(
        // Register modules here
        new ModuleOre()
    );

    super.onPreInitialization(event);
  }

  @EventHandler
  protected void onInitialization(FMLInitializationEvent event) {
    super.onInitialization(event);
  }

  @EventHandler
  protected void onPostInitialization(FMLPostInitializationEvent event) {
    super.onPostInitialization(event);
  }
}
