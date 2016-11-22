package com.sudoplay.mc.kormetals.module.ore.worldgen;

import com.sudoplay.mc.kor.spi.world.KorOreGenReplacementStrategy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

/**
 * Created by sk3lls on 11/21/2016.
 */
public class DenseOreReplacementStrategy implements
    KorOreGenReplacementStrategy {

  private IBlockState defaultState;
  private IBlockState denseState;
  private float denseSpawnChance;

  public DenseOreReplacementStrategy(
      IBlockState defaultState,
      IBlockState denseState,
      float denseSpawnChance
  ) {
    this.defaultState = defaultState;
    this.denseState = denseState;
    this.denseSpawnChance = denseSpawnChance;
  }

  @Override
  public void execute(@Nonnull World worldIn, @Nonnull BlockPos blockpos, @Nonnull Random random) {

    if (random.nextFloat() <= this.denseSpawnChance) {
      worldIn.setBlockState(blockpos, this.denseState, 2);

    } else {
      worldIn.setBlockState(blockpos, this.defaultState, 2);
    }
  }
}
