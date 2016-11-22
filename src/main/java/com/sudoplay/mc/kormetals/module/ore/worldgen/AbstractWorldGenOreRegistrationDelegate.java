package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.kor.spi.world.*;
import com.sudoplay.mc.kormetals.module.ore.config.DenseDimensionProfile;
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
  private Block blockDenseOre;
  private PropertyEnum<MetalAlloyType> metalAlloyTypePropertyEnum;
  private Block blockOreAlloy;
  private Block blockOreDenseAlloy;

  public AbstractWorldGenOreRegistrationDelegate(
      KorConfigOreGen config,
      PropertyEnum<MetalType> metalTypePropertyEnum,
      Block blockOre,
      Block blockDenseOre,
      PropertyEnum<MetalAlloyType> metalAlloyTypePropertyEnum,
      Block blockOreAlloy,
      Block blockOreDenseAlloy
  ) {
    this.config = config;
    this.metalTypePropertyEnum = metalTypePropertyEnum;
    this.blockOre = blockOre;
    this.blockDenseOre = blockDenseOre;
    this.metalAlloyTypePropertyEnum = metalAlloyTypePropertyEnum;
    this.blockOreAlloy = blockOreAlloy;
    this.blockOreDenseAlloy = blockOreDenseAlloy;
  }

  protected abstract boolean isOreAllowed(KorOreGenConfigEntry configEntry, String name);

  protected abstract boolean isDenseOreAllowed(KorOreGenConfigEntry configEntry, String name);

  @Override
  public KorInitStrategy getInitStrategy() {
    return (kor) -> {

      KorOreGenConfigEntry configEntry;
      KorOreGen oreGen = new KorOreGen();

      for (MetalType metalType : MetalType.values()) {
        String name = metalType.getName();
        configEntry = this.config.getConfigEntryMap().get(name);

        boolean oreAllowed = isOreAllowed(configEntry, name);
        boolean denseOreAllowed = isDenseOreAllowed(configEntry, name);

        if (oreAllowed || denseOreAllowed) {
          List<DimensionProfile> dimensionProfileList = configEntry.getDimensionProfileList();

          for (DimensionProfile profile : dimensionProfileList) {
            int dimensionId = profile.getDimensionId();

            KorOreGenReplacementStrategy replacementStrategy;

            if (oreAllowed && denseOreAllowed) {
              float denseSpawnChance = 0;

              if (profile instanceof DenseDimensionProfile) {
                denseSpawnChance = ((DenseDimensionProfile) profile).getDenseSpawnChance();
              }

              IBlockState defaultState = this.blockOre.getDefaultState().withProperty(this.metalTypePropertyEnum, metalType);
              IBlockState denseState = this.blockDenseOre.getDefaultState().withProperty(this.metalTypePropertyEnum, metalType);
              replacementStrategy = new DenseOreReplacementStrategy(defaultState, denseState, denseSpawnChance);

            } else if (oreAllowed) {
              IBlockState defaultState = this.blockOre.getDefaultState().withProperty(this.metalTypePropertyEnum, metalType);
              replacementStrategy = new DefaultReplacementStrategy(defaultState);

            } else {
              IBlockState denseState = this.blockDenseOre.getDefaultState().withProperty(this.metalTypePropertyEnum, metalType);
              replacementStrategy = new DefaultReplacementStrategy(denseState);
            }

            oreGen.addOreGenStrategy(dimensionId, OreGenStrategy.create(
                profile.getBlockCount(),
                profile.getSpawnsPerChunk(),
                profile.getVerticalGeneration(),
                BlockMatcher.forBlock(Block.REGISTRY.getObject(new ResourceLocation(profile.getMatchBlock()))),
                replacementStrategy
            ));
          }
        }
      }

      for (MetalAlloyType metalType : MetalAlloyType.values()) {
        String name = metalType.getName();
        configEntry = this.config.getConfigEntryMap().get(name);

        boolean oreAllowed = isOreAllowed(configEntry, name);
        boolean denseOreAllowed = isDenseOreAllowed(configEntry, name);

        if (oreAllowed || denseOreAllowed) {
          List<DimensionProfile> dimensionProfileList = configEntry.getDimensionProfileList();

          for (DimensionProfile profile : dimensionProfileList) {
            int dimensionId = profile.getDimensionId();

            KorOreGenReplacementStrategy replacementStrategy;

            if (oreAllowed && denseOreAllowed) {
              float denseSpawnChance = 0;

              if (profile instanceof DenseDimensionProfile) {
                denseSpawnChance = ((DenseDimensionProfile) profile).getDenseSpawnChance();
              }

              IBlockState defaultState = this.blockOreAlloy.getDefaultState().withProperty(this.metalAlloyTypePropertyEnum, metalType);
              IBlockState denseState = this.blockOreDenseAlloy.getDefaultState().withProperty(this.metalAlloyTypePropertyEnum, metalType);
              replacementStrategy = new DenseOreReplacementStrategy(defaultState, denseState, denseSpawnChance);

            } else if (oreAllowed) {
              IBlockState defaultState = this.blockOreAlloy.getDefaultState().withProperty(this.metalAlloyTypePropertyEnum, metalType);
              replacementStrategy = new DefaultReplacementStrategy(defaultState);

            } else {
              IBlockState denseState = this.blockOreDenseAlloy.getDefaultState().withProperty(this.metalAlloyTypePropertyEnum, metalType);
              replacementStrategy = new DefaultReplacementStrategy(denseState);
            }

            oreGen.addOreGenStrategy(dimensionId, OreGenStrategy.create(
                profile.getBlockCount(),
                profile.getSpawnsPerChunk(),
                profile.getVerticalGeneration(),
                BlockMatcher.forBlock(Block.REGISTRY.getObject(new ResourceLocation(profile.getMatchBlock()))),
                replacementStrategy
            ));
          }
        }
      }

      oreGen.getInitStrategy().onInit(kor);
    };
  }
}
