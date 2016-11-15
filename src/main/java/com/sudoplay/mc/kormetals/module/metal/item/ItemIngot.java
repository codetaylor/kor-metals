package com.sudoplay.mc.kormetals.module.metal.item;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.core.generation.annotation.*;
import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.item.ISubType;
import com.sudoplay.mc.kor.spi.item.KorSubTypedItem;
import com.sudoplay.mc.kor.spi.registry.KorOreDictionaryEntry;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorTextConfig;
import com.sudoplay.mc.kormetals.KorMetals;
import com.sudoplay.mc.kormetals.KorMetalsCreativeTab;
import com.sudoplay.mc.kormetals.module.metal.ModuleMetal;
import com.sudoplay.mc.kormetals.shared.MetalType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sk3lls on 11/12/2016.
 */

@KorGenerateItemSubTypedAssets(
    name = "ingot",
    modId = KorMetals.MOD_ID,
    subTypes = {
        "brass",
        "copper",
        "electrum",
        "enderium",
        "invar",
        "lead",
        "lumium",
        "nickel",
        "platinum",
        "signalum",
        "silver",
        "tin"
    }
)

@KorGenerateLangEntries(entries = {
    @KorLangEntry(key = "item.ingot_brass.name", value = "Brass Ingot"),
    @KorLangEntry(key = "item.ingot_copper.name", value = "Copper Ingot"),
    @KorLangEntry(key = "item.ingot_electrum.name", value = "Electrum Ingot"),
    @KorLangEntry(key = "item.ingot_enderium.name", value = "Enderium Ingot"),
    @KorLangEntry(key = "item.ingot_invar.name", value = "Invar Ingot"),
    @KorLangEntry(key = "item.ingot_lead.name", value = "Lead Ingot"),
    @KorLangEntry(key = "item.ingot_lumium.name", value = "Lumium Ingot"),
    @KorLangEntry(key = "item.ingot_nickel.name", value = "Nickel Ingot"),
    @KorLangEntry(key = "item.ingot_platinum.name", value = "Platinum Ingot"),
    @KorLangEntry(key = "item.ingot_signalum.name", value = "Signalum Ingot"),
    @KorLangEntry(key = "item.ingot_silver.name", value = "Silver Ingot"),
    @KorLangEntry(key = "item.ingot_tin.name", value = "Tin Ingot")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 7, row = 1, target = "items/ingot_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 1, target = "items/ingot_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 1, target = "items/ingot_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 1, target = "items/ingot_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 1, target = "items/ingot_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 1, target = "items/ingot_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 1, target = "items/ingot_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 1, target = "items/ingot_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 1, target = "items/ingot_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 1, target = "items/ingot_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 1, target = "items/ingot_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 1, target = "items/ingot_tin", source = "KorMetals.png")
})

public class ItemIngot extends
    KorSubTypedItem {

  @KorInject
  public ItemIngot(
      Kor kor,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "ingot",
        filterSubTypes(configData)
    );
    this.setCreativeTab(kor.get(KorMetalsCreativeTab.class));
  }

  private static ISubType[] filterSubTypes(TextConfigData configData) {
    List<ISubType> subTypeList = new ArrayList<>();

    for (ISubType subType : MetalType.values()) {

      if (isEnabled(subType.getName(), configData)) {
        subTypeList.add(subType);
      }
    }
    return subTypeList.toArray(new ISubType[subTypeList.size()]);
  }

  private static boolean isEnabled(String key, TextConfigData configData) {
    return configData.getCategory(ModuleMetal.Config.CATEGORY_ITEM_INGOT).getBoolean(key);
  }

  @Override
  @Nonnull
  public List<KorOreDictionaryEntry> getKorOreDictionaryEntries(@Nonnull List<KorOreDictionaryEntry> store) {
    MetalType[] metalTypes = MetalType.values();

    for (MetalType metalType : metalTypes) {
      String name = metalType.getName();
      name = "ingot" + name.substring(0, 1).toUpperCase() + name.substring(1);
      store.add(new KorOreDictionaryEntry(name, metalType.getMeta()));
    }
    return store;
  }
}
