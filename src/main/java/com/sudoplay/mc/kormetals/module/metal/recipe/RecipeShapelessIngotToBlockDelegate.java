package com.sudoplay.mc.kormetals.module.metal.recipe;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeCraftingShapeless;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.kormetals.module.metal.ModuleMetal;
import com.sudoplay.mc.kormetals.module.metal.item.ItemIngot;
import com.sudoplay.mc.kormetals.shared.MetalType;
import net.minecraft.item.ItemStack;

/**
 * Created by sk3lls on 11/13/2016.
 */
public class RecipeShapelessIngotToBlockDelegate extends
    KorRegistrationDelegate {

  private TextConfigData config;

  @KorInject
  public RecipeShapelessIngotToBlockDelegate(
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
          new RecipeShapelessIngot(metalType, kor).getInitStrategy().onInit(kor);
        }
      }
    };
  }

  private boolean isRecipeEnabledInConfig(String name) {
    return this.config.getCategory(ModuleMetal.Config.CATEGORY_ITEM_INGOT).getBoolean(name)
        && this.config.getCategory(ModuleMetal.Config.CATEGORY_BLOCK_METAL).getBoolean(name)
        && this.config.getCategory(ModuleMetal.Config.CATEGORY_RECIPE_INGOT_TO_BLOCK).getBoolean(name);
  }

  private static class RecipeShapelessIngot extends
      KorRecipeCraftingShapeless {

    RecipeShapelessIngot(
        MetalType metalType,
        Kor kor
    ) {
      super(
          new ItemStack(kor.get(ItemIngot.class), 1, metalType.getMeta()),
          getParams(metalType)
      );
    }

    private static Object[] getParams(MetalType metalType) {
      String ingotOreDictName = "ingot"
          + metalType.getName().substring(0, 1).toUpperCase()
          + metalType.getName().substring(1);

      return new Object[]{
          ingotOreDictName,
          ingotOreDictName,
          ingotOreDictName,
          ingotOreDictName,
          ingotOreDictName,
          ingotOreDictName,
          ingotOreDictName,
          ingotOreDictName,
          ingotOreDictName
      };
    }
  }
}
