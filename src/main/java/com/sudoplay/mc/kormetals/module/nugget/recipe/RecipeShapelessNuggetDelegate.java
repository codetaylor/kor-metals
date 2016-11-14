package com.sudoplay.mc.kormetals.module.nugget.recipe;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeCraftingShapeless;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorPreInitStrategy;
import com.sudoplay.mc.kormetals.module.ingot.ModuleIngot;
import com.sudoplay.mc.kormetals.module.nugget.ModuleNugget;
import com.sudoplay.mc.kormetals.module.nugget.item.ItemNugget;
import com.sudoplay.mc.kormetals.shared.MetalType;
import net.minecraft.item.ItemStack;

/**
 * Created by sk3lls on 11/13/2016.
 */
public class RecipeShapelessNuggetDelegate extends
    KorRegistrationDelegate {

  private TextConfigData configNugget;
  private TextConfigData configIngot;

  @KorInject
  public RecipeShapelessNuggetDelegate(
      @KorTextConfig(file = ModuleNugget.Config.FILENAME) TextConfigData configNugget,
      @KorTextConfig(file = ModuleIngot.Config.FILENAME) TextConfigData configIngot
  ) {
    this.configNugget = configNugget;
    this.configIngot = configIngot;
  }

  @Override
  public KorPreInitStrategy getPreInitStrategy() {
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
    return this.configIngot.getCategory(ModuleIngot.Config.CATEGORY_INGOT).getBoolean(name)
        && this.configNugget.getCategory(ModuleNugget.Config.CATEGORY_NUGGET).getBoolean(name)
        && this.configNugget.getCategory(ModuleNugget.Config.CATEGORY_RECIPE_INGOT).getBoolean(name);
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
