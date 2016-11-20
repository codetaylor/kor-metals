package com.sudoplay.mc.kormetals.module.metal.item;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.metal.ModuleMetal;
import com.sudoplay.mc.kormetals.shared.MetalType;

import static com.sudoplay.mc.kormetals.module.metal.ModuleMetal.Config.CATEGORY_ITEM_INGOT;
import static com.sudoplay.mc.kormetals.module.metal.ModuleMetal.Config.FILENAME;

/**
 * Created by sk3lls on 11/12/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "aluminum"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "copper"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "lead"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "nickel"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "platinum"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "silver"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "tin"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_INGOT, key = "zinc")
})

@KorGenerateItemSubTypedAssets(
    name = ItemIngot.NAME,
    modId = KorMetals.MOD_ID,
    subTypes = {
        "aluminum",
        "copper",
        "lead",
        "nickel",
        "platinum",
        "silver",
        "tin",
        "zinc"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_aluminum.name", value = "Alumina Ingot"),
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_copper.name", value = "Copper Ingot"),
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_lead.name", value = "Lead Ingot"),
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_nickel.name", value = "Nickel Ingot"),
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_platinum.name", value = "Platinum Ingot"),
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_silver.name", value = "Silver Ingot"),
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_tin.name", value = "Tin Ingot"),
    @KorLangEntry(key = "item." + ItemIngot.NAME + "_zinc.name", value = "Zinc Ingot")

})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 17, row = 1, target = "items/" + ItemIngot.NAME + "_aluminum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 1, target = "items/" + ItemIngot.NAME + "_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 1, target = "items/" + ItemIngot.NAME + "_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 1, target = "items/" + ItemIngot.NAME + "_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 1, target = "items/" + ItemIngot.NAME + "_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 1, target = "items/" + ItemIngot.NAME + "_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 1, target = "items/" + ItemIngot.NAME + "_tin", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 16, row = 1, target = "items/" + ItemIngot.NAME + "_zinc", source = "KorMetals.png")
})

public class ItemIngot extends
    AbstractItemMetal {

  /* package */ static final String NAME = "ingot";

  @KorInject
  public ItemIngot(
      Kor kor,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        NAME,
        "ingot",
        MetalType.values(),
        configData
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
  }
}
