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
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "aluminum_brass"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "brass"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "bronze"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "constantan"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "electrum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "enderium"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "invar"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "lumium"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "signalum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_INGOT, key = "steel")
})

@KorGenerateItemSubTypedAssets(
    name = ItemIngotAlloy.NAME,
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
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_aluminum_brass.name", value = "Alumina Brass Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_brass.name", value = "Brass Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_bronze.name", value = "Bronze Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_constantan.name", value = "Constantan Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_electrum.name", value = "Electrum Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_enderium.name", value = "Enderium Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_invar.name", value = "Invar Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_lumium.name", value = "Lumium Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_signalum.name", value = "Signalum Ingot"),
    @KorLangEntry(key = "item." + ItemIngotAlloy.NAME + "_steel.name", value = "Steel Ingot")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 18, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_aluminum_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 7, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 15, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_bronze", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 14, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_constantan", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 13, row = 1, target = "items/" + ItemIngotAlloy.NAME + "_steel", source = "KorMetals.png")
})

public class ItemIngotAlloy extends
    AbstractItemMetal {

  /* package */ static final String NAME = "ingot_alloy";

  @KorInject
  public ItemIngotAlloy(
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
