package com.sudoplay.mc.kormetals.module.ingot.recipe;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeItem;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeSmelting;
import com.sudoplay.mc.kormetals.module.ingot.config.ConfigSmeltingIngot;
import com.sudoplay.mc.kormetals.module.ingot.item.ItemIngot;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/12/2016.
 */
/* package */ class SmeltingIngot extends KorRecipeSmelting {

  /* package */ SmeltingIngot(
      MetalType metalType,
      Kor kor,
      ConfigSmeltingIngot config
  ) {
    super(
        KorRecipeItem.from(kor.get(BlockOre.class), 1, metalType.getMeta()),
        KorRecipeItem.from(kor.get(ItemIngot.class), config.get(metalType.getName()).getQuantity(), metalType.getMeta()),
        config.get(metalType.getName()).getXp()
    );
  }
}
