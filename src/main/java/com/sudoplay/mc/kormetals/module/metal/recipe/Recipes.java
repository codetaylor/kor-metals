package com.sudoplay.mc.kormetals.module.metal.recipe;

import com.sudoplay.mc.kor.core.recipe.RecipeFile;
import com.sudoplay.mc.kor.core.recipe.furnace.RecipeFurnace;
import com.sudoplay.mc.kor.core.recipe.shaped.RecipeShaped;
import com.sudoplay.mc.kor.core.recipe.shapeless.RecipeShapeless;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/19/2016.
 */
public class Recipes extends
    RecipeFile {

  public Recipes() {

    // Nuggets

    for (MetalType metalType : MetalType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapelessMap.put(String.format("ingot_%s to nugget_%s", name, name), new RecipeShapeless(
          KorMetals.MOD_ID + ":nugget:" + meta + " * 9",
          KorMetals.MOD_ID + ":ingot:" + meta
      ));
    }

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapelessMap.put(String.format("ingot_alloy_%s to nugget_alloy_%s", name, name), new RecipeShapeless(
          KorMetals.MOD_ID + ":nugget_alloy:" + meta + " * 9",
          KorMetals.MOD_ID + ":ingot_alloy:" + meta
      ));
    }

    for (MetalType metalType : MetalType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapedMap.put(String.format("nugget_%s to ingot_%s", name, name), new RecipeShaped(
          KorMetals.MOD_ID + ":ingot:" + meta,
          new String[]{
              KorMetals.MOD_ID + ":nugget:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget:" + meta,
              KorMetals.MOD_ID + ":nugget:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget:" + meta,
              KorMetals.MOD_ID + ":nugget:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget:" + meta,
          }
      ));
    }

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapedMap.put(String.format("nugget_alloy_%s to ingot_alloy_%s", name, name), new RecipeShaped(
          KorMetals.MOD_ID + ":ingot_alloy:" + meta,
          new String[]{
              KorMetals.MOD_ID + ":nugget_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget_alloy:" + meta,
              KorMetals.MOD_ID + ":nugget_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget_alloy:" + meta,
              KorMetals.MOD_ID + ":nugget_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":nugget_alloy:" + meta,
          }
      ));
    }

    // Blocks

    for (MetalType metalType : MetalType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapelessMap.put(String.format("block_%s to ingot_%s", name, name), new RecipeShapeless(
          KorMetals.MOD_ID + ":ingot:" + meta + " * 9",
          KorMetals.MOD_ID + ":block:" + meta
      ));
    }

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapelessMap.put(String.format("block_alloy_%s to ingot_alloy_%s", name, name), new RecipeShapeless(
          KorMetals.MOD_ID + ":ingot_alloy:" + meta + " * 9",
          KorMetals.MOD_ID + ":block_alloy:" + meta
      ));
    }

    for (MetalType metalType : MetalType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapedMap.put(String.format("ingot_%s to block_%s", name, name), new RecipeShaped(
          KorMetals.MOD_ID + ":block:" + meta,
          new String[]{
              KorMetals.MOD_ID + ":ingot:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot:" + meta,
              KorMetals.MOD_ID + ":ingot:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot:" + meta,
              KorMetals.MOD_ID + ":ingot:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot:" + meta,
          }
      ));
    }

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeShapedMap.put(String.format("ingot_alloy_%s to block_alloy_%s", name, name), new RecipeShaped(
          KorMetals.MOD_ID + ":block_alloy:" + meta,
          new String[]{
              KorMetals.MOD_ID + ":ingot_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot_alloy:" + meta,
              KorMetals.MOD_ID + ":ingot_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot_alloy:" + meta,
              KorMetals.MOD_ID + ":ingot_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot_alloy:" + meta + ", " +
                  KorMetals.MOD_ID + ":ingot_alloy:" + meta,
          }
      ));
    }

    // Dusts

    for (MetalType metalType : MetalType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeFurnaceMap.put(String.format("dust_%s to ingot_%s", name, name), new RecipeFurnace(
          KorMetals.MOD_ID + ":ingot:" + meta,
          KorMetals.MOD_ID + ":dust:" + meta,
          0.7f
      ));
    }

    for (MetalAlloyType metalType : MetalAlloyType.values()) {
      String name = metalType.getName();
      int meta = metalType.getMeta();
      this.recipeFurnaceMap.put(String.format("dust_alloy_%s to ingot_alloy_%s", name, name), new RecipeFurnace(
          KorMetals.MOD_ID + ":ingot_alloy:" + meta,
          KorMetals.MOD_ID + ":dust_alloy:" + meta,
          0.7f
      ));
    }

  }
}
