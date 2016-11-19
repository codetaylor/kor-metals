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

import static com.sudoplay.mc.kormetals.module.metal.ModuleMetal.Config.CATEGORY_ITEM_NUGGET;
import static com.sudoplay.mc.kormetals.module.metal.ModuleMetal.Config.FILENAME;

/**
 * Created by sk3lls on 11/12/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "aluminum"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "copper"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "lead"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "nickel"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "platinum"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "silver"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "tin"),
    @KorTextConfigDependency(filename = FILENAME, category = CATEGORY_ITEM_NUGGET, key = "zinc")
})

@KorGenerateItemSubTypedAssets(
    name = ItemNugget.NAME,
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
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_aluminum.name", value = "Alumina Nugget"),
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_copper.name", value = "Copper Nugget"),
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_lead.name", value = "Lead Nugget"),
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_nickel.name", value = "Nickel Nugget"),
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_platinum.name", value = "Platinum Nugget"),
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_silver.name", value = "Silver Nugget"),
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_tin.name", value = "Tin Nugget"),
    @KorLangEntry(key = "item." + ItemNugget.NAME + "_zinc.name", value = "Zinc Nugget")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 17, row = 2, target = "items/" + ItemNugget.NAME + "_aluminum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 2, target = "items/" + ItemNugget.NAME + "_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 2, target = "items/" + ItemNugget.NAME + "_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 2, target = "items/" + ItemNugget.NAME + "_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 2, target = "items/" + ItemNugget.NAME + "_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 2, target = "items/" + ItemNugget.NAME + "_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 2, target = "items/" + ItemNugget.NAME + "_tin", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 16, row = 2, target = "items/" + ItemNugget.NAME + "_zinc", source = "KorMetals.png")
})

public class ItemNugget extends
    AbstractItemMetal {

  /* package */ static final String NAME = "nugget";

  @KorInject
  public ItemNugget(
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
