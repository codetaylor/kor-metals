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
import com.sudoplay.mc.kormetals.shared.MetalType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.sudoplay.mc.kormetals.shared.MetalType.*;

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
    name = "block",
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
    @KorLangEntry(key = "tile.block_aluminum.name", value = "Alumina Block"),
    @KorLangEntry(key = "tile.block_copper.name", value = "Copper Block"),
    @KorLangEntry(key = "tile.block_lead.name", value = "Lead Block"),
    @KorLangEntry(key = "tile.block_nickel.name", value = "Nickel Block"),
    @KorLangEntry(key = "tile.block_platinum.name", value = "Platinum Block"),
    @KorLangEntry(key = "tile.block_silver.name", value = "Silver Block"),
    @KorLangEntry(key = "tile.block_tin.name", value = "Tin Block"),
    @KorLangEntry(key = "tile.block_zinc.name", value = "Zinc Block")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 17, row = 4, target = "blocks/block_aluminum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 4, target = "blocks/block_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 4, target = "blocks/block_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 4, target = "blocks/block_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 4, target = "blocks/block_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 4, target = "blocks/block_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 4, target = "blocks/block_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 4, target = "blocks/block_tin", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 16, row = 4, target = "blocks/block_zinc", source = "KorMetals.png")
})

public class BlockMetal extends
    KorSubTypedEnumBlock<MetalType> implements
    KorOreDictionaryEntryProvider {

  private static class Config extends
      KorConfigObject {

    @SerializedName("block_properties")
    private Map<MetalType, ConfigBlockEntry> configEntryMap;

    public Config() {
      this.configEntryMap = new EnumMap<>(MetalType.class);
      this.configEntryMap.put(Aluminum, new ConfigBlockEntry(3.0f, 5.0f, 1));
      this.configEntryMap.put(Copper, new ConfigBlockEntry(3.0f, 5.0f, 1));
      this.configEntryMap.put(Lead, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Nickel, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Platinum, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Silver, new ConfigBlockEntry(3.0f, 5.0f, 2));
      this.configEntryMap.put(Tin, new ConfigBlockEntry(3.0f, 5.0f, 1));
      this.configEntryMap.put(Zinc, new ConfigBlockEntry(3.0f, 5.0f, 1));
    }

    public ConfigBlockEntry get(MetalType key) {
      return this.configEntryMap.get(key);
    }
  }

  public static PropertyEnum<MetalType> TYPE;

  private final Config config;

  @KorInject
  public BlockMetal(
      Kor kor,
      @KorJsonConfig(path = ModuleMetal.MODULE_ID, file = "block_metal_properties.json") Config config,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "block",
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

      isEnabled = configData.getCategory(ModuleMetal.Config.CATEGORY_BLOCK_METAL).getBoolean(name);

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
      String name = metalType.getName();
      name = "block" + name.substring(0, 1).toUpperCase() + name.substring(1);
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
