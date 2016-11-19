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
import com.sudoplay.mc.kormetals.module.ore.config.ConfigBlockOreAlloy;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.util.Util;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sk3lls on 11/9/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "aluminum_brass"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "brass"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "bronze"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "constantan"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "electrum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "enderium"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "invar"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "lumium"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "signalum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD, key = "steel")
})

@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "ore_alloy",
    modId = KorMetals.MOD_ID,
    subTypes = {
        "aluminum_brass",
        "brass",
        "bronze",
        "constantan",
        "electrum",
        "enderium",
        "invar",
        "lumium",
        "signalum",
        "steel"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "tile.ore_alloy_aluminum_brass.name", value = "Alumina Brass Ore"),
    @KorLangEntry(key = "tile.ore_alloy_brass.name", value = "Brass Ore"),
    @KorLangEntry(key = "tile.ore_alloy_bronze.name", value = "Bronze Ore"),
    @KorLangEntry(key = "tile.ore_alloy_constantan.name", value = "Constantan Ore"),
    @KorLangEntry(key = "tile.ore_alloy_electrum.name", value = "Electrum Ore"),
    @KorLangEntry(key = "tile.ore_alloy_enderium.name", value = "Enderium Ore"),
    @KorLangEntry(key = "tile.ore_alloy_invar.name", value = "Invar Ore"),
    @KorLangEntry(key = "tile.ore_alloy_lumium.name", value = "Lumium Ore"),
    @KorLangEntry(key = "tile.ore_alloy_signalum.name", value = "Signalum Ore"),
    @KorLangEntry(key = "tile.ore_alloy_steel.name", value = "Steel Ore")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 18, row = 7, target = "blocks/ore_alloy_aluminum_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 7, row = 7, target = "blocks/ore_alloy_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 15, row = 7, target = "blocks/ore_alloy_bronze", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 14, row = 7, target = "blocks/ore_alloy_constantan", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 7, target = "blocks/ore_alloy_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 7, target = "blocks/ore_alloy_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 7, target = "blocks/ore_alloy_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 7, target = "blocks/ore_alloy_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 7, target = "blocks/ore_alloy_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 13, row = 7, target = "blocks/ore_alloy_steel", source = "KorMetals.png")
})

public class BlockOreAlloy extends
    KorSubTypedEnumBlock<MetalAlloyType> implements
    KorOreDictionaryEntryProvider {

  public static PropertyEnum<MetalAlloyType> TYPE;

  private final ConfigBlockOreAlloy config;

  @KorInject
  public BlockOreAlloy(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "ore_alloy_properties.json") ConfigBlockOreAlloy config,
      @KorTextConfig(path = ModuleOre.MODULE_ID, file = ModuleOre.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "ore_alloy",
        Material.ROCK,
        (TYPE = PropertyEnum.create("type", MetalAlloyType.class, getAllowedValues(configData))),
        MetalAlloyType.class
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
    this.setDefaultState(this.getBlockState().getBaseState().withProperty(TYPE, Iterables.get(TYPE.getAllowedValues(), 0)));
    this.config = config;
  }

  @Nonnull
  private static MetalAlloyType[] getAllowedValues(@Nonnull TextConfigData configData) {
    String[] allowedMetalTypes;
    List<MetalAlloyType> allowedValueList;
    boolean isEnabled;

    allowedMetalTypes = new String[]{
        "aluminumBrass",
        "brass",
        "bronze",
        "constantan",
        "electrum",
        "enderium",
        "invar",
        "lumium",
        "signalum",
        "steel"
    };

    allowedValueList = new ArrayList<>();

    for (String name : allowedMetalTypes) {

      isEnabled = configData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD).getBoolean(name);

      if (isEnabled) {
        allowedValueList.add(MetalAlloyType.fromName(name));
      }
    }

    return allowedValueList.toArray(new MetalAlloyType[allowedValueList.size()]);
  }

  @Override
  @Nonnull
  public List<KorOreDictionaryEntry> getKorOreDictionaryEntries(@Nonnull List<KorOreDictionaryEntry> store) {

    for (MetalAlloyType metalType : TYPE.getAllowedValues()) {
      String name = Util.getOreDictName(metalType.getName());
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
  public int getLightValue(@Nonnull IBlockState blockState, IBlockAccess world, @Nonnull BlockPos pos) {
    return (blockState.getValue(TYPE) == MetalAlloyType.Lumium) ? 15 : 0;
  }
}
