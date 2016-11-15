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
public class RecipeShapelessIngotDelegate extends
    KorRegistrationDelegate {

  private TextConfigData config;

  @KorInject
  public RecipeShapelessIngotDelegate(
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
    return this.config.getCategory(ModuleMetal.Config.CATEGORY_INGOT).getBoolean(name)
        && this.config.getCategory(ModuleMetal.Config.CATEGORY_NUGGET).getBoolean(name)
        && this.config.getCategory(ModuleMetal.Config.CATEGORY_INGOT_RECIPE_NUGGET).getBoolean(name);
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
      String nuggetOreDictName = "nugget"
          + metalType.getName().substring(0, 1).toUpperCase()
          + metalType.getName().substring(1);

      return new Object[]{
          nuggetOreDictName,
          nuggetOreDictName,
          nuggetOreDictName,
          nuggetOreDictName,
          nuggetOreDictName,
          nuggetOreDictName,
          nuggetOreDictName,
          nuggetOreDictName,
          nuggetOreDictName
      };
    }
  }
}
