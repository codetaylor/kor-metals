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
import com.sudoplay.mc.kormetals.module.ore.core.MetalAlloyType;
import com.sudoplay.mc.kormetals.module.ore.core.OreConfigEntry;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sk3lls on 11/7/2016.
 */
@KorGenerateBlockSubTypedAssets(
    property = "type",
    name = "nether_ore",
    modId = KorMetals.MOD_ID,
    subTypes = {
        "brass",
        "electrum",
        "enderium",
        "invar",
        "lumium",
        "signalum"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "tile.nether_ore_brass.name", value = "Nether Brass Ore"),
    @KorLangEntry(key = "tile.nether_ore_electrum.name", value = "Nether Electrum Ore"),
    @KorLangEntry(key = "tile.nether_ore_enderium.name", value = "Nether Enderium Ore"),
    @KorLangEntry(key = "tile.nether_ore_invar.name", value = "Nether Invar Ore"),
    @KorLangEntry(key = "tile.nether_ore_lumium.name", value = "Nether Lumium Ore"),
    @KorLangEntry(key = "tile.nether_ore_signalum.name", value = "Nether Signalum Ore")
})

public class BlockNetherOreAlloy extends
    KorSubTypedBlock<MetalAlloyType> {

  private static class Config extends
      KorConfigObject {

    @SerializedName("nether_ore_properties")
    Map<MetalAlloyType, OreConfigEntry> oreConfigEntryMap;

    public Config() {
      this.oreConfigEntryMap = new LinkedHashMap<>();

      this.oreConfigEntryMap.put(MetalAlloyType.Brass, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalAlloyType.Electrum, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalAlloyType.Enderium, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalAlloyType.Invar, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalAlloyType.Lumium, new OreConfigEntry(3.0f, 5.0f, 2));
      this.oreConfigEntryMap.put(MetalAlloyType.Signalum, new OreConfigEntry(3.0f, 5.0f, 2));
    }
  }

  private static final PropertyEnum<MetalAlloyType> TYPE = PropertyEnum.create("type", MetalAlloyType.class);

  private static Config CONFIG;

  @KorInject
  public BlockNetherOreAlloy(
      Kor kor,
      @KorConfig(path = KorMetalsModuleOre.MODULE_ID + "/ore", file = "nether_ore_properties.json") Config config
  ) {
    super(
        bootstrap(kor.getModId(), config),
        "nether_ore",
        Material.ROCK,
        TYPE,
        MetalAlloyType.class
    );

    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
  }

  @Override
  public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
    return getOreConfigEntry(blockState).getHardness();
  }

  @Override
  public int getLightValue(@Nonnull IBlockState state, IBlockAccess world, @Nonnull BlockPos pos) {
    return (state.getValue(TYPE) == MetalAlloyType.Lumium) ? 15 : 0;
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
    BlockNetherOreAlloy.CONFIG = config;
    return modId;
  }

  private OreConfigEntry getOreConfigEntry(IBlockState blockState) {
    MetalAlloyType metalType = blockState.getValue(TYPE);
    return CONFIG.oreConfigEntryMap.get(metalType);
  }
}
