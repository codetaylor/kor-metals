package com.sudoplay.mc.kormetals.module.ingot.recipe;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeItem;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeSmelting;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorPreInitStrategy;
import com.sudoplay.mc.kormetals.module.ingot.ModuleIngot;
import com.sudoplay.mc.kormetals.module.ingot.config.ConfigSmeltingIngot;
import com.sudoplay.mc.kormetals.module.ingot.item.ItemIngot;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/13/2016.
 */
public class RecipeSmeltingIngotDelegate extends
    KorRegistrationDelegate {

  private TextConfigData textConfigData;
  private ConfigSmeltingIngot config;

  @KorInject
  public RecipeSmeltingIngotDelegate(
      @KorTextConfig(file = ModuleIngot.Config.FILENAME) TextConfigData textConfigData,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "smelting_nether_ore.json") ConfigSmeltingIngot config
  ) {
    this.textConfigData = textConfigData;
    this.config = config;
  }

  @Override
  public KorPreInitStrategy getPreInitStrategy() {
    return kor -> {

      for (MetalType metalType : MetalType.values()) {
        String name = metalType.getName();

        if (isRecipeEnabledInConfig(name)) {
          new RecipeSmeltingIngot(metalType, kor, this.config).getInitStrategy().onInit(kor);
        }
      }
    };
  }

  private boolean isRecipeEnabledInConfig(String name) {
    return this.textConfigData.getCategory(ModuleIngot.Config.CATEGORY_INGOT).getBoolean(name)
        && this.textConfigData.getCategory(ModuleIngot.Config.CATEGORY_RECIPE_SMELTING).getBoolean(name);
  }

  /**
   * Created by sk3lls on 11/12/2016.
   */
  private static class RecipeSmeltingIngot extends
      KorRecipeSmelting {

    RecipeSmeltingIngot(
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
}
