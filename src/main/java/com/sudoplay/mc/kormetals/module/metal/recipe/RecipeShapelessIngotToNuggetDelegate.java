package com.sudoplay.mc.kormetals.module.metal.recipe;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeCraftingShapeless;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.kormetals.module.metal.ModuleMetal;
import com.sudoplay.mc.kormetals.module.metal.item.ItemNugget;
import com.sudoplay.mc.kormetals.shared.MetalType;
import net.minecraft.item.ItemStack;

/**
 * Created by sk3lls on 11/13/2016.
 */
public class RecipeShapelessIngotToNuggetDelegate extends
    KorRegistrationDelegate {

  private TextConfigData config;

  @KorInject
  public RecipeShapelessIngotToNuggetDelegate(
      @KorTextConfig(file = ModuleMetal.Config.FILENAME) TextConfigData config
  ) {
    this.config = config;
  }

  @Override
  public KorInitStrategy getInitStrategy() {
    return (kor) -> {

      for (MetalType metalType : MetalType.values()) {
        String name = metalType.getName();

        if (isRecipeEnabledInConfig(name)) {
          new RecipeShapelessNugget(metalType, kor).getInitStrategy().onInit(kor);
        }
      }
    };
  }

  private boolean isRecipeEnabledInConfig(String name) {
    return this.config.getCategory(ModuleMetal.Config.CATEGORY_ITEM_INGOT).getBoolean(name)
        && this.config.getCategory(ModuleMetal.Config.CATEGORY_ITEM_NUGGET).getBoolean(name)
        && this.config.getCategory(ModuleMetal.Config.CATEGORY_RECIPE_INGOT_TO_NUGGET).getBoolean(name);
  }

  private static class RecipeShapelessNugget extends
      KorRecipeCraftingShapeless {

    RecipeShapelessNugget(
        MetalType metalType,
        Kor kor
    ) {
      super(
          new ItemStack(kor.get(ItemNugget.class), 9, metalType.getMeta()),
          new Object[]{
              "ingot" + metalType.getName().substring(0, 1).toUpperCase() + metalType.getName().substring(1)
          }
      );
    }
  }
}
