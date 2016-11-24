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
import com.sudoplay.mc.kormetals.module.ore.config.ConfigBlockNetherOreAlloy;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kor.spi.util.StringUtils;
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
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "aluminum_brass"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "brass"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "bronze"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "constantan"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "electrum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "enderium"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "invar"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "lumium"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "signalum"),
    @KorTextConfigDependency(filename = ModuleOre.Config.FILENAME, category = ModuleOre.Config.CATEGORY_BLOCK_ORE_END, key = "steel")
})

@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "end_ore_alloy",
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
    @KorLangEntry(key = "tile.end_ore_alloy_aluminum_brass.name", value = "End Alumina Brass Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_brass.name", value = "End Brass Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_constantan.name", value = "End Constantan Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_electrum.name", value = "End Electrum Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_enderium.name", value = "End Enderium Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_invar.name", value = "End Invar Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_lumium.name", value = "End Lumium Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_signalum.name", value = "End Signalum Ore"),
    @KorLangEntry(key = "tile.end_ore_alloy_steel.name", value = "End Steel Ore")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 18, row = 6, target = "blocks/end_ore_alloy_aluminum_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 7, row = 6, target = "blocks/end_ore_alloy_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 15, row = 6, target = "blocks/end_ore_alloy_bronze", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 14, row = 6, target = "blocks/end_ore_alloy_constantan", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 6, target = "blocks/end_ore_alloy_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 6, target = "blocks/end_ore_alloy_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 6, target = "blocks/end_ore_alloy_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 6, target = "blocks/end_ore_alloy_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 6, target = "blocks/end_ore_alloy_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 13, row = 6, target = "blocks/end_ore_alloy_steel", source = "KorMetals.png")
})

public class BlockEndOreAlloy extends
    KorSubTypedEnumBlock<MetalAlloyType> implements
    KorOreDictionaryEntryProvider {

  public static PropertyEnum<MetalAlloyType> TYPE;

  private final ConfigBlockNetherOreAlloy config;

  @KorInject
  public BlockEndOreAlloy(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "end_ore_alloy_properties.json") ConfigBlockNetherOreAlloy config,
      @KorTextConfig(path = ModuleOre.MODULE_ID, file = ModuleOre.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "end_ore_alloy",
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
    };

    allowedValueList = new ArrayList<>();

    for (String name : allowedMetalTypes) {

      isEnabled = configData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_END).getBoolean(name);

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
      String name = "ore" + StringUtils.convertSnakeCaseToCamelCase(metalType.getName());
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
