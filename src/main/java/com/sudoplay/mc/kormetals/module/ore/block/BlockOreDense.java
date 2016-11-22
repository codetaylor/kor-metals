package com.sudoplay.mc.kormetals.module.ore.block;

import com.google.common.collect.Iterables;
import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.block.KorSubTypedEnumBlock;
import com.sudoplay.mc.kor.spi.registry.KorOreDictionaryEntry;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigBlockOreDense;
import com.sudoplay.mc.kormetals.shared.MetalType;
import com.sudoplay.mc.kormetals.util.Util;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sk3lls on 11/9/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "aluminum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "copper"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "lead"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "nickel"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "platinum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "silver"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "tin"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_DENSE_OVERWORLD, key = "zinc")
})

@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "ore_dense",
    modId = KorMetals.MOD_ID,
    subTypes = {
        "aluminum",
        "copper",
        "lead",
        "nickel",
        "platinum",
        "silver",
        "tin",
        "zinc"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "tile.ore_dense_aluminum.name", value = "Alumina Ore (Dense)"),
    @KorLangEntry(key = "tile.ore_dense_copper.name", value = "Copper Ore (Dense)"),
    @KorLangEntry(key = "tile.ore_dense_lead.name", value = "Lead Ore (Dense)"),
    @KorLangEntry(key = "tile.ore_dense_nickel.name", value = "Nickel Ore (Dense)"),
    @KorLangEntry(key = "tile.ore_dense_platinum.name", value = "Platinum Ore (Dense)"),
    @KorLangEntry(key = "tile.ore_dense_silver.name", value = "Silver Ore (Dense)"),
    @KorLangEntry(key = "tile.ore_dense_tin.name", value = "Tin Ore (Dense)"),
    @KorLangEntry(key = "tile.ore_dense_zinc.name", value = "Zinc Ore (Dense)")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 17, row = 8, target = "blocks/ore_dense_aluminum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 8, target = "blocks/ore_dense_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 8, target = "blocks/ore_dense_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 8, target = "blocks/ore_dense_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 8, target = "blocks/ore_dense_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 8, target = "blocks/ore_dense_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 8, target = "blocks/ore_dense_tin", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 16, row = 8, target = "blocks/ore_dense_zinc", source = "KorMetals.png")
})

public class BlockOreDense extends
    KorSubTypedEnumBlock<MetalType> {

  public static PropertyEnum<MetalType> TYPE;

  private final ConfigBlockOreDense config;

  @KorInject
  public BlockOreDense(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "ore_dense_properties.json") ConfigBlockOreDense config,
      @KorTextConfig(path = ModuleOre.MODULE_ID, file = ModuleOre.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "ore_dense",
        Material.ROCK,
        (TYPE = PropertyEnum.create("type", MetalType.class, getAllowedValues(configData))),
        MetalType.class
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
    this.setDefaultState(this.getBlockState().getBaseState().withProperty(TYPE, Iterables.get(TYPE.getAllowedValues(), 0)));
    this.config = config;
  }

  @Nonnull
  private static MetalType[] getAllowedValues(@Nonnull TextConfigData configData) {
    String[] allowedMetalTypes;
    List<MetalType> allowedValueList;
    boolean isEnabled;

    allowedMetalTypes = new String[]{
        "aluminum",
        "copper",
        "lead",
        "nickel",
        "platinum",
        "silver",
        "tin",
        "zinc"
    };

    allowedValueList = new ArrayList<>();

    for (String name : allowedMetalTypes) {

      isEnabled = configData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD).getBoolean(name);

      if (isEnabled) {
        allowedValueList.add(MetalType.fromName(name));
      }
    }

    return allowedValueList.toArray(new MetalType[allowedValueList.size()]);
  }


  @Override
  @Nonnull
  public List<KorOreDictionaryEntry> getKorOreDictionaryEntries(@Nonnull List<KorOreDictionaryEntry> store) {

    for (MetalType metalType : TYPE.getAllowedValues()) {
      String name = "dense" + Util.getOreDictName(metalType.getName());
      store.add(new KorOreDictionaryEntry(name, metalType.getMeta()));
    }
    return store;
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
  public int quantityDropped(IBlockState state, int fortune, Random random) {
    return super.quantityDropped(state, fortune, random) * 2;
  }
}
