package com.sudoplay.mc.kormetals.module.ore.recipe;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeItem;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeSmelting;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/11/2016.
 */
@KorRegistrationTextConfigDependency(dependsOn = {
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_ORE_OVERWORLD,
        key = "platinum"
    ),
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_ORE_NETHER,
        key = "platinum"
    ),
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_RECIPE_SMELTING,
        key = "platinum"
    )
})

public class SmeltingNetherOrePlatinum extends
    KorRecipeSmelting {

  private static final int META = MetalType.Platinum.getMeta();

  @KorInject
  public SmeltingNetherOrePlatinum(
      Kor kor
  ) {
    super(
        KorRecipeItem.from(kor.get(BlockNetherOre.class), 1, META),
        KorRecipeItem.from(kor.get(BlockOre.class), 2, META),
        1.0f
    );
  }
}
