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
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "aluminum_brass"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "brass"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "bronze"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "constantan"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "electrum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "enderium"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "invar"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "lumium"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "signalum"),
    @KorTextConfigDependency(filename = ModuleMetal.Config.FILENAME, category = ModuleMetal.Config.CATEGORY_ITEM_DUST, key = "steel")
})

@KorGenerateItemSubTypedAssets(
    name = ItemDustAlloy.NAME,
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
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_aluminum_brass.name", value = "Alumina Brass Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_brass.name", value = "Brass Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_bronze.name", value = "Bronze Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_constantan.name", value = "Constantan Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_electrum.name", value = "Electrum Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_enderium.name", value = "Enderium Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_invar.name", value = "Invar Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_lumium.name", value = "Lumium Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_signalum.name", value = "Signalum Dust"),
    @KorLangEntry(key = "item." + ItemDustAlloy.NAME + "_steel.name", value = "Steel Dust")

})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 18, row = 3, target = "items/" + ItemDustAlloy.NAME + "_aluminum_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 7, row = 3, target = "items/" + ItemDustAlloy.NAME + "_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 15, row = 3, target = "items/" + ItemDustAlloy.NAME + "_bronze", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 14, row = 3, target = "items/" + ItemDustAlloy.NAME + "_constantan", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 3, target = "items/" + ItemDustAlloy.NAME + "_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 3, target = "items/" + ItemDustAlloy.NAME + "_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 3, target = "items/" + ItemDustAlloy.NAME + "_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 3, target = "items/" + ItemDustAlloy.NAME + "_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 3, target = "items/" + ItemDustAlloy.NAME + "_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 13, row = 3, target = "items/" + ItemDustAlloy.NAME + "_steel", source = "KorMetals.png")

})

public class ItemDustAlloy extends
    AbstractItemMetal {

  /* package */ static final String NAME = "dust_alloy";

  @KorInject
  public ItemDustAlloy(
      Kor kor,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        NAME,
        "dust",
        MetalAlloyType.values(),
        configData
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
  }
}
