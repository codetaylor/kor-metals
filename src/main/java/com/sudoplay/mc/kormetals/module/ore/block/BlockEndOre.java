package com.sudoplay.mc.kormetals.module.ore.block;

import com.google.common.collect.Iterables;
import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.block.KorSubTypedEnumBlock;
import com.sudoplay.mc.kor.spi.registry.KorOreDictionaryEntry;
import com.sudoplay.mc.kor.spi.registry.KorOreDictionaryEntryProvider;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigBlockNetherOre;
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

/**
 * Created by sk3lls on 11/9/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "aluminum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "copper"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "lead"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "nickel"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "platinum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "silver"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "tin"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "zinc")
})

@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "end_ore",
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
    @KorLangEntry(key = "tile.end_ore_aluminum.name", value = "End Alumina Ore"),
    @KorLangEntry(key = "tile.end_ore_copper.name", value = "End Copper Ore"),
    @KorLangEntry(key = "tile.end_ore_lead.name", value = "End Lead Ore"),
    @KorLangEntry(key = "tile.end_ore_nickel.name", value = "End Nickel Ore"),
    @KorLangEntry(key = "tile.end_ore_platinum.name", value = "End Platinum Ore"),
    @KorLangEntry(key = "tile.end_ore_silver.name", value = "End Silver Ore"),
    @KorLangEntry(key = "tile.end_ore_tin.name", value = "End Tin Ore"),
    @KorLangEntry(key = "tile.end_ore_zinc.name", value = "End Zinc Ore")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 17, row = 7, target = "blocks/end_ore_aluminum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 7, target = "blocks/end_ore_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 7, target = "blocks/end_ore_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 7, target = "blocks/end_ore_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 7, target = "blocks/end_ore_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 7, target = "blocks/end_ore_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 7, target = "blocks/end_ore_tin", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 16, row = 7, target = "blocks/end_ore_zinc", source = "KorMetals.png")
})

public class BlockEndOre extends
    KorSubTypedEnumBlock<MetalType> implements
    KorOreDictionaryEntryProvider {

  public static PropertyEnum<MetalType> TYPE;

  private final ConfigBlockNetherOre config;

  @KorInject
  public BlockEndOre(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "end_ore_properties.json") ConfigBlockNetherOre config,
      @KorTextConfig(path = ModuleOre.MODULE_ID, file = ModuleOre.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "end_ore",
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

      isEnabled = configData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_END).getBoolean(name);

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
      String name = "ore" + Util.getOreDictName(metalType.getName());
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
}
