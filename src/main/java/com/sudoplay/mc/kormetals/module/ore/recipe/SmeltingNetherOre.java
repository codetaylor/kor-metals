package com.sudoplay.mc.kormetals.module.ore.recipe;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeItem;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeSmelting;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigSmeltingNetherOre;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/12/2016.
 */
/* package */ abstract class SmeltingNetherOre extends
    KorRecipeSmelting {

  /* package */ SmeltingNetherOre(
      MetalType metalType,
      Kor kor,
      ConfigSmeltingNetherOre config
  ) {
    super(
        KorRecipeItem.from(kor.get(BlockNetherOre.class), 1, metalType.getMeta()),
        KorRecipeItem.from(kor.get(BlockOre.class), config.get(metalType.getName()).getQuantity(), metalType.getMeta()),
        config.get(metalType.getName()).getXp()
    );
  }
}
