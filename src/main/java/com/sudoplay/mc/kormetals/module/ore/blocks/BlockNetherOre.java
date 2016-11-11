package com.sudoplay.mc.kormetals.module.ore.blocks;

import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.block.KorSubTypedEnumBlock;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.core.OreConfigEntry;
import com.sudoplay.mc.kormetals.shared.MetalType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.Map;

import static com.sudoplay.mc.kormetals.shared.MetalType.*;

/**
 * Created by sk3lls on 11/9/2016.
 */

@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "nether_ore",
    modId = KorMetals.MOD_ID,
    subTypes = {
        "brass",
        "copper",
        "electrum",
        "enderium",
        "invar",
        "lead",
        "lumium",
        "nickel",
        "platinum",
        "signalum",
        "silver",
        "tin"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "tile.nether_ore_brass.name", value = "Nether Brass Ore"),
    @KorLangEntry(key = "tile.nether_ore_copper.name", value = "Nether Copper Ore"),
    @KorLangEntry(key = "tile.nether_ore_electrum.name", value = "Nether Electrum Ore"),
    @KorLangEntry(key = "tile.nether_ore_enderium.name", value = "Nether Enderium Ore"),
    @KorLangEntry(key = "tile.nether_ore_invar.name", value = "Nether Invar Ore"),
    @KorLangEntry(key = "tile.nether_ore_lead.name", value = "Nether Lead Ore"),
    @KorLangEntry(key = "tile.nether_ore_lumium.name", value = "Nether Lumium Ore"),
    @KorLangEntry(key = "tile.nether_ore_nickel.name", value = "Nether Nickel Ore"),
    @KorLangEntry(key = "tile.nether_ore_platinum.name", value = "Nether Platinum Ore"),
    @KorLangEntry(key = "tile.nether_ore_signalum.name", value = "Nether Signalum Ore"),
    @KorLangEntry(key = "tile.nether_ore_silver.name", value = "Nether Silver Ore"),
    @KorLangEntry(key = "tile.nether_ore_tin.name", value = "Nether Tin Ore")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 6, row = 7, target = "blocks/nether_ore_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 0, row = 7, target = "blocks/nether_ore_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 7, target = "blocks/nether_ore_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 7, target = "blocks/nether_ore_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 7, row = 7, target = "blocks/nether_ore_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 7, target = "blocks/nether_ore_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 7, target = "blocks/nether_ore_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 7, target = "blocks/nether_ore_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 7, target = "blocks/nether_ore_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 7, target = "blocks/nether_ore_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 7, target = "blocks/nether_ore_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 7, target = "blocks/nether_ore_tin", source = "KorMetals.png")
})

public class BlockNetherOre extends
    KorSubTypedEnumBlock<MetalType> {

  private static class Config extends
      KorConfigObject {

    @SerializedName("nether_ore")
    private Map<MetalType, OreConfigEntry> oreConfigEntryMap;

    public Config() {
      this.oreConfigEntryMap = new EnumMap<>(MetalType.class);
      this.oreConfigEntryMap.put(Brass, new OreConfigEntry(3.0f, 5.0f, 3));
      this.oreConfigEntryMap.put(Copper, new OreConfigEntry(3.0f, 5.0f, 1));
      this.oreConfigEntryMap.put(Electrum, new OreConfigEntry(3.0f, 5.0f, 3));
      this.oreConfigEntryMap.put(Enderium, new OreConfigEntry(3.0f, 5.0f, 3));
      this.oreConfigEntryMap.put(Invar, new OreConfigEntry(3.0f, 5.0f, 3));
      this.oreConfigEntryMap.put(Lead, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(Lumium, new OreConfigEntry(3.0f, 5.0f, 3));
      this.oreConfigEntryMap.put(Nickel, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(Platinum, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(Signalum, new OreConfigEntry(3.0f, 5.0f, 3));
      this.oreConfigEntryMap.put(Silver, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(Tin, new OreConfigEntry(3.0f, 5.0f, 1));
    }

    public OreConfigEntry get(MetalType key) {
      return this.oreConfigEntryMap.get(key);
    }
  }

  public static final PropertyEnum<MetalType> TYPE = PropertyEnum.create("type", MetalType.class);

  private final Config config;

  @KorInject
  public BlockNetherOre(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "nether_ore.json") Config config,
      @KorTextConfig(path = ModuleOre.MODULE_ID, file = ModuleOre.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "nether_ore",
        Material.ROCK,
        TYPE,
        MetalType.class,
        new boolean[]{
            isEnabled("brass", configData),
            isEnabled("copper", configData),
            isEnabled("electrum", configData),
            isEnabled("enderium", configData),
            isEnabled("invar", configData),
            isEnabled("lead", configData),
            isEnabled("lumium", configData),
            isEnabled("nickel", configData),
            isEnabled("platinum", configData),
            isEnabled("signalum", configData),
            isEnabled("silver", configData),
            isEnabled("tin", configData)
        }
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
    this.setDefaultState(this.getBlockState().getBaseState().withProperty(TYPE, MetalType.Copper));
    this.config = config;
  }

  private static boolean isEnabled(String key, TextConfigData configData) {
    return configData.getCategory(ModuleOre.Config.CATEGORY_ORE_NETHER).getBoolean(key);
  }

  @Override
  public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
    return this.config.get(blockState.getValue(TYPE)).getHardness();
  }

  @Override
  public int getHarvestLevel(@Nonnull IBlockState blockState) {
    return this.config.get(blockState.getValue(TYPE)).getHarvestLevel();
  }

  @Override
  public float getExplosionResistance(World world, BlockPos pos, @Nonnull Entity exploder, Explosion explosion) {
    IBlockState blockState = world.getBlockState(pos);
    return this.config.get(blockState.getValue(TYPE)).getResistance();
  }

  @Override
  public int getLightValue(@Nonnull IBlockState blockState, IBlockAccess world, @Nonnull BlockPos pos) {
    return (blockState.getValue(TYPE) == MetalType.Lumium) ? 15 : 0;
  }
}