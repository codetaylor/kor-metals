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

import static com.sudoplay.mc.kormetals.module.metal.ModuleMetal.Config.*;

/**
 * Created by sk3lls on 11/12/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "aluminum"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "copper"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "lead"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "nickel"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "platinum"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "silver"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "tin"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_DUST, key = "zinc")
})

@KorGenerateItemSubTypedAssets(
    name = ItemDust.NAME,
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
    @KorLangEntry(key = "item." + ItemDust.NAME + "_aluminum.name", value = "Alumina Dust"),
    @KorLangEntry(key = "item." + ItemDust.NAME + "_copper.name", value = "Copper Dust"),
    @KorLangEntry(key = "item." + ItemDust.NAME + "_lead.name", value = "Lead Dust"),
    @KorLangEntry(key = "item." + ItemDust.NAME + "_nickel.name", value = "Nickel Dust"),
    @KorLangEntry(key = "item." + ItemDust.NAME + "_platinum.name", value = "Platinum Dust"),
    @KorLangEntry(key = "item." + ItemDust.NAME + "_silver.name", value = "Silver Dust"),
    @KorLangEntry(key = "item." + ItemDust.NAME + "_tin.name", value = "Tin Dust"),
    @KorLangEntry(key = "item." + ItemDust.NAME + "_zinc.name", value = "Zinc Dust")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 17, row = 3, target = "items/" + ItemDust.NAME + "_aluminum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 3, target = "items/" + ItemDust.NAME + "_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 3, target = "items/" + ItemDust.NAME + "_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 3, target = "items/" + ItemDust.NAME + "_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 3, target = "items/" + ItemDust.NAME + "_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 3, target = "items/" + ItemDust.NAME + "_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 3, target = "items/" + ItemDust.NAME + "_tin", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 16, row = 3, target = "items/" + ItemDust.NAME + "_zinc", source = "KorMetals.png")
})

public class ItemDust extends
    AbstractItemMetal {

  /* package */ static final String NAME = "dust";

  @KorInject
  public ItemDust(
      Kor kor,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        NAME,
        MetalType.values(),
        configData
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
  }
}
