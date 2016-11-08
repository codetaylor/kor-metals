package com.sudoplay.mc.kormetals.module.ore.blocks;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.core.generation.annotation.KorGenerateBlockSubTypedAssets;
import com.sudoplay.mc.kor.core.generation.annotation.KorGenerateLangEntries;
import com.sudoplay.mc.kor.core.generation.annotation.KorLangEntry;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.block.KorSubTypedBlock;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kor.spi.registry.injection.KorConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.KorMetalsModuleOre;
import com.sudoplay.mc.kormetals.module.ore.core.MetalType;
import com.sudoplay.mc.kormetals.module.ore.core.OreConfigEntry;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sk3lls on 11/7/2016.
 */
@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "ore",
    modId = KorMetals.MOD_ID,
    subTypes = {
        "copper",
        "lead",
        "nickel",
        "platinum",
        "silver",
        "tin"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "tile.ore_copper.name", value = "Copper Ore"),
    @KorLangEntry(key = "tile.ore_lead.name", value = "Lead Ore"),
    @KorLangEntry(key = "tile.ore_nickel.name", value = "Nickel Ore"),
    @KorLangEntry(key = "tile.ore_platinum.name", value = "Platinum Ore"),
    @KorLangEntry(key = "tile.ore_silver.name", value = "Silver Ore"),
    @KorLangEntry(key = "tile.ore_tin.name", value = "Tin Ore"),
})

public class BlockOre extends
    KorSubTypedBlock<MetalType> {

  private static class Config extends
      KorConfigObject {

    @SerializedName("ore_properties")
    Map<MetalType, OreConfigEntry> oreConfigEntryMap;

    public Config() {
      this.oreConfigEntryMap = new LinkedHashMap<>();

      this.oreConfigEntryMap.put(MetalType.Copper, new OreConfigEntry(3.0f, 5.0f, 1));
      this.oreConfigEntryMap.put(MetalType.Lead, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalType.Nickel, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalType.Platinum, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalType.Silver, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalType.Tin, new OreConfigEntry(3.0f, 5.0f, 1));
    }
  }

  public static final PropertyEnum<MetalType> TYPE = PropertyEnum.create("type", MetalType.class);

  private static Config CONFIG;

  @KorInject
  public BlockOre(
      Kor kor,
      @KorConfig(path = KorMetalsModuleOre.MODULE_ID + "/ore", file = "ore_properties.json") Config config
  ) {
    super(
        bootstrap(kor.getModId(), config),
        "ore",
        Material.ROCK,
        TYPE,
        MetalType.class
    );

    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
  }

  @Override
  public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
    return getOreConfigEntry(blockState).getHardness();
  }

  @Override
  public int getHarvestLevel(@Nonnull IBlockState state) {
    return getOreConfigEntry(state).getHarvestLevel();
  }

  @Override
  public float getExplosionResistance(World world, BlockPos pos, @Nonnull Entity exploder, Explosion explosion) {
    return getOreConfigEntry(world.getBlockState(pos)).getResistance();
  }

  private static String bootstrap(String modId, Config config) {
    BlockOre.CONFIG = config;
    return modId;
  }

  private OreConfigEntry getOreConfigEntry(IBlockState blockState) {
    MetalType metalType = blockState.getValue(TYPE);
    return CONFIG.oreConfigEntryMap.get(metalType);
  }
}