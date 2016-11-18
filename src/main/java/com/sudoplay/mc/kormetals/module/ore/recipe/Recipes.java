package com.sudoplay.mc.kormetals.module.ore.recipe;

import com.sudoplay.mc.kor.core.recipe.RecipeFile;
import com.sudoplay.mc.kor.core.recipe.furnace.RecipeFurnace;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/17/2016.
 */
public class Recipes extends
    RecipeFile {

  public Recipes() {

    for (MetalType metalType : MetalType.values()) {
      String name = metalType.getName();
      this.recipeFurnaceList.put(String.format("nether_ore_%s to ore_%s", name, name), new RecipeFurnace(
          KorMetals.MOD_ID + ":ore:" + metalType.getMeta() + " * 2",
          KorMetals.MOD_ID + ":nether_ore:" + metalType.getMeta(), 0.7f
      ));
    }

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      String name = metalType.getName();
      this.recipeFurnaceList.put(String.format("nether_ore_alloy_%s to ore_alloy_%s", name, name), new RecipeFurnace(
          KorMetals.MOD_ID + ":ore_alloy:" + metalType.getMeta() + " * 2",
          KorMetals.MOD_ID + ":nether_ore_alloy:" + metalType.getMeta(), 1.0f
      ));
    }
  }
}
