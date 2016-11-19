package com.sudoplay.mc.kormetals.module.metal.block;

import com.google.common.collect.Iterables;
import com.google.gson.annotations.SerializedName;
import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.block.KorSubTypedEnumBlock;
import com.sudoplay.mc.kor.spi.config.json.KorConfigObject;
import com.sudoplay.mc.kor.spi.registry.KorOreDictionaryEntry;
import com.sudoplay.mc.kor.spi.registry.KorOreDictionaryEntryProvider;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.metal.ModuleMetal;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigBlockEntry;
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
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.sudoplay.mc.kormetals.shared.MetalAlloyType.*;

/**
 * Created by sk3lls on 11/9/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "aluminum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "copper"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "lead"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "nickel"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "platinum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "silver"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "tin"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_BLOCK_METAL, key = "zinc")
})

@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "block_alloy",
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
    @KorLangEntry(key = "tile.block_alloy_aluminum_brass.name", value = "Alumina Brass Block"),
    @KorLangEntry(key = "tile.block_alloy_brass.name", value = "Brass Block"),
    @KorLangEntry(key = "tile.block_alloy_bronze.name", value = "Bronze Block"),
    @KorLangEntry(key = "tile.block_alloy_constantan.name", value = "Constantan Block"),
    @KorLangEntry(key = "tile.block_alloy_electrum.name", value = "Electrum Block"),
    @KorLangEntry(key = "tile.block_alloy_enderium.name", value = "Enderium Block"),
    @KorLangEntry(key = "tile.block_alloy_invar.name", value = "Invar Block"),
    @KorLangEntry(key = "tile.block_alloy_lumium.name", value = "Lumium Block"),
    @KorLangEntry(key = "tile.block_alloy_signalum.name", value = "Signalum Block"),
    @KorLangEntry(key = "tile.block_alloy_steel.name", value = "Steel Block")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 18, row = 4, target = "blocks/block_alloy_aluminum_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 7, row = 4, target = "blocks/block_alloy_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 15, row = 4, target = "blocks/block_alloy_bronze", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 14, row = 4, target = "blocks/block_alloy_constantan", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 4, target = "blocks/block_alloy_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 4, target = "blocks/block_alloy_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 4, target = "blocks/block_alloy_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 4, target = "blocks/block_alloy_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 4, target = "blocks/block_alloy_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 13, row = 4, target = "blocks/block_alloy_steel", source = "KorMetals.png")
})

public class BlockMetalAlloy extends
    KorSubTypedEnumBlock<MetalAlloyType> implements
    KorOreDictionaryEntryProvider {

  private static class Config extends
      KorConfigObject {

    @SerializedName("block_properties")
    private Map<MetalAlloyType, ConfigBlockEntry> configEntryMap;

    public Config() {
      this.configEntryMap = new EnumMap<>(MetalAlloyType.class);
      this.configEntryMap.put(AluminumBrass, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Brass, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Bronze, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Constantan, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Electrum, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Enderium, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Invar, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Lumium, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Signalum, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Steel, new ConfigBlockEntry(3.0f, 5.0f, 2));
    }

    public ConfigBlockEntry get(MetalAlloyType key) {
      return this.configEntryMap.get(key);
    }
  }

  public static PropertyEnum<MetalAlloyType> TYPE;

  private final Config config;

  @KorInject
  public BlockMetalAlloy(
      Kor kor,
      @KorJsonConfig(path = ModuleMetal.MODULE_ID, file = "block_metal_alloy_properties.json") Config config,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "block_alloy",
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

      isEnabled = configData.getCategory(ModuleMetal.Config.CATEGORY_BLOCK_METAL).getBoolean(name);

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
