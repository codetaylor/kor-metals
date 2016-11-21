package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.kor.spi.world.*;
import com.sudoplay.mc.kormetals.module.ore.config.KorConfigOreGen;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.ResourceLocation;

import java.util.List;

/**
 * Created by sk3lls on 11/21/2016.
 */
public abstract class AbstractWorldGenOreRegistrationDelegate
    extends KorRegistrationDelegate {

  protected KorConfigOreGen config;
  private PropertyEnum<MetalType> metalTypePropertyEnum;
  private Block blockOre;
  private PropertyEnum<MetalAlloyType> metalAlloyTypePropertyEnum;
  private Block blockOreAlloy;

  public AbstractWorldGenOreRegistrationDelegate(
      KorConfigOreGen config,
      PropertyEnum<MetalType> metalTypePropertyEnum,
      Block blockOre,
      PropertyEnum<MetalAlloyType> metalAlloyTypePropertyEnum,
      Block blockOreAlloy
  ) {
    this.config = config;
    this.metalTypePropertyEnum = metalTypePropertyEnum;
    this.blockOre = blockOre;
    this.metalAlloyTypePropertyEnum = metalAlloyTypePropertyEnum;
    this.blockOreAlloy = blockOreAlloy;
  }

  protected abstract boolean isRegistrationPermitted(KorOreGenConfigEntry configEntry, String name);

  @Override
  public KorInitStrategy getInitStrategy() {
    return (kor) -> {

      KorOreGenConfigEntry configEntry;
      KorOreGen oreGen = new KorOreGen();

      for (MetalType metalType : MetalType.values()) {
        String name = metalType.getName();
        configEntry = this.config.getConfigEntryMap().get(name);

        if (isRegistrationPermitted(configEntry, name)) {
          List<DimensionProfile> dimensionProfileList = configEntry.getDimensionProfileList();

          for (DimensionProfile profile : dimensionProfileList) {
            int dimensionId = profile.getDimensionId();
            IBlockState defaultState = this.blockOre.getDefaultState().withProperty(this.metalTypePropertyEnum, metalType);

            oreGen.addOreGenStrategy(dimensionId, OreGenStrategy.create(
                profile.getBlockCount(),
                profile.getSpawnsPerChunk(),
                profile.getVerticalGeneration(),
                BlockMatcher.forBlock(Block.REGISTRY.getObject(new ResourceLocation(profile.getMatchBlock()))),
                new DefaultReplacementStrategy(defaultState) // TODO hook here for dense ores
            ));
          }
        }
      }

      for (MetalAlloyType metalType : MetalAlloyType.values()) {
        String name = metalType.getName();
        configEntry = this.config.getConfigEntryMap().get(name);

        if (isRegistrationPermitted(configEntry, name)) {
          List<DimensionProfile> dimensionProfileList = configEntry.getDimensionProfileList();

          for (DimensionProfile profile : dimensionProfileList) {
            int dimensionId = profile.getDimensionId();
            IBlockState defaultState = this.blockOreAlloy.getDefaultState().withProperty(this.metalAlloyTypePropertyEnum, metalType);

            oreGen.addOreGenStrategy(dimensionId, OreGenStrategy.create(
                profile.getBlockCount(),
                profile.getSpawnsPerChunk(),
                profile.getVerticalGeneration(),
                BlockMatcher.forBlock(Block.REGISTRY.getObject(new ResourceLocation(profile.getMatchBlock()))),
                new DefaultReplacementStrategy(defaultState) // TODO hook here for dense ores
            ));
          }
        }
      }

      oreGen.getInitStrategy().onInit(kor);
    };
  }
}
