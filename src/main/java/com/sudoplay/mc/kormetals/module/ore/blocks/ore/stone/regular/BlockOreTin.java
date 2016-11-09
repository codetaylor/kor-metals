package com.sudoplay.mc.kormetals.module.ore.blocks.ore.stone.regular;

import com.sudoplay.mc.kor.core.generation.annotation.KorGenerateBlockAssets;
import com.sudoplay.mc.kor.core.generation.annotation.KorGenerateLangEntries;
import com.sudoplay.mc.kor.core.generation.annotation.KorLangEntry;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.block.KorBlock;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.core.OreConfigEntry;
import net.minecraft.block.material.Material;

/**
 * Created by sk3lls on 11/8/2016.
 */

@KorGenerateBlockAssets(
    modId = KorMetals.MOD_ID,
    name = "ore_tin"
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "tile.ore_tin.name", value = "Tin Ore")
})

@KorRegistrationTextConfigDependency(
    filename = ModuleOre.Config.FILENAME,
    category = ModuleOre.Config.CATEGORY_ORE,
    key = "ore_tin"
)

public class BlockOreTin extends
    KorBlock {

  private static class Config extends
      OreConfigEntry {

    private static final float HARDNESS = 3.0f;
    private static final float RESISTANCE = 5.0f;
    private static final int HARVEST_LEVEL = 1;

    public Config() {
      super(
          HARDNESS,
          RESISTANCE,
          HARVEST_LEVEL
      );
    }
  }

  @KorInject
  public BlockOreTin(
      Kor kor,
      @KorConfig(path = ModuleOre.MODULE_ID + "/ore", file = "ore_tin.json") Config config
  ) {
    super(
        kor.getModId(),
        "ore_tin",
        Material.ROCK
    );
    setCreativeTab(kor.get(KorMetalsCreativeTab.class));
    setHardness(config.getHardness());
    setResistance(config.getResistance());
    setHarvestLevel("pickaxe", config.getHarvestLevel());
  }
}