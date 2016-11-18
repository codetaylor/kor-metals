package com.sudoplay.mc.kormetals.module.ore.recipe;

import com.sudoplay.mc.kor.spi.recipe.KorRecipeFileRegistrationDelegate;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;

/**
 * Created by sk3lls on 11/17/2016.
 */
public class RecipeRegistrationDelegate extends
    KorRecipeFileRegistrationDelegate {

  @KorInject
  public RecipeRegistrationDelegate(
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "recipes.json") Recipes recipeFile
  ) {
    super(recipeFile);
  }
}
