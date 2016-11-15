package com.sudoplay.mc.kormetals.module.ore.recipe;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeItem;
import com.sudoplay.mc.kor.spi.recipe.KorRecipeSmelting;
import com.sudoplay.mc.kor.spi.registry.KorRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kor.spi.registry.strategy.KorInitStrategy;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockNetherOre;
import com.sudoplay.mc.kormetals.module.ore.blocks.BlockOre;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigSmeltingNetherOre;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/13/2016.
 */
public class RecipeSmeltingNetherOreDelegate extends
    KorRegistrationDelegate {

  private TextConfigData textConfigData;
  private ConfigSmeltingNetherOre config;

  @KorInject
  public RecipeSmeltingNetherOreDelegate(
      @KorTextConfig(file = ModuleOre.Config.FILENAME) TextConfigData textConfigData,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "smelting_nether_ore_to_ore.json") ConfigSmeltingNetherOre config
  ) {
    this.textConfigData = textConfigData;
    this.config = config;
  }

  @Override
  public KorInitStrategy getInitStrategy() {
    return (kor) -> {

      for (MetalType metalType : MetalType.values()) {
        String name = metalType.getName();

        if (isRecipeEnabledInConfig(name)) {
          new RecipeSmeltingNetherOre(metalType, kor, this.config).getInitStrategy().onInit(kor);
        }
      }
    };
  }

  private boolean isRecipeEnabledInConfig(String name) {
    return this.textConfigData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_OVERWORLD).getBoolean(name)
        && this.textConfigData.getCategory(ModuleOre.Config.CATEGORY_BLOCK_ORE_NETHER).getBoolean(name)
        && this.textConfigData.getCategory(ModuleOre.Config.CATEGORY_SMELTING_NETHER_ORE_TO_ORE).getBoolean(name);
  }

  private static class RecipeSmeltingNetherOre extends
      KorRecipeSmelting {

    RecipeSmeltingNetherOre(
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
}
