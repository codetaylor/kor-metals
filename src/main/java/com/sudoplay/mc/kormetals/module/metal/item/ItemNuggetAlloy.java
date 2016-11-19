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
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;

/**
 * Created by sk3lls on 11/12/2016.
 */

@KorRegistrationTextConfigDependency(dependsOnAtLeastOneOf = {
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "aluminum_brass"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "brass"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "bronze"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "constantan"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "electrum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "enderium"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "invar"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "lumium"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "signalum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_NUGGET, key = "steel")
})

@KorGenerateItemSubTypedAssets(
    name = ItemNuggetAlloy.NAME,
    modId = KorMetals.MOD_ID,
    subTypes = {
        "aluminum_brass",
        "brass",
        "bronze",
        "constantan",
        "electrum",
        "enderium",
        "invar",
        "lumium",
        "signalum",
        "steel"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_aluminum_brass.name", value = "Alumina Brass Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_brass.name", value = "Brass Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_bronze.name", value = "Bronze Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_constantan.name", value = "Constantan Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_electrum.name", value = "Electrum Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_enderium.name", value = "Enderium Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_invar.name", value = "Invar Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_lumium.name", value = "Lumium Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_signalum.name", value = "Signalum Nugget"),
    @KorLangEntry(key = "item." + ItemNuggetAlloy.NAME + "_steel.name", value = "Steel Nugget")

})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 18, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_aluminum_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 7, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 15, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_bronze", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 14, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_constantan", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 13, row = 2, target = "items/" + ItemNuggetAlloy.NAME + "_steel", source = "KorMetals.png")

})

public class ItemNuggetAlloy extends
    AbstractItemMetal {

  /* package */ static final String NAME = "nugget_alloy";

  @KorInject
  public ItemNuggetAlloy(
      Kor kor,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        NAME,
        MetalAlloyType.values(),
        configData
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
  }
}
