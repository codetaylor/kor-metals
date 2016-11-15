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
    name = "dust",
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
    @KorLangEntry(key = "item.dust_brass.name", value = "Brass Dust"),
    @KorLangEntry(key = "item.dust_copper.name", value = "Copper Dust"),
    @KorLangEntry(key = "item.dust_electrum.name", value = "Electrum Dust"),
    @KorLangEntry(key = "item.dust_enderium.name", value = "Enderium Dust"),
    @KorLangEntry(key = "item.dust_invar.name", value = "Invar Dust"),
    @KorLangEntry(key = "item.dust_lead.name", value = "Lead Dust"),
    @KorLangEntry(key = "item.dust_lumium.name", value = "Lumium Dust"),
    @KorLangEntry(key = "item.dust_nickel.name", value = "Nickel Dust"),
    @KorLangEntry(key = "item.dust_platinum.name", value = "Platinum Dust"),
    @KorLangEntry(key = "item.dust_signalum.name", value = "Signalum Dust"),
    @KorLangEntry(key = "item.dust_silver.name", value = "Silver Dust"),
    @KorLangEntry(key = "item.dust_tin.name", value = "Tin Dust")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 7, row = 3, target = "items/dust_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 3, target = "items/dust_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 3, target = "items/dust_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 3, target = "items/dust_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 3, target = "items/dust_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 3, target = "items/dust_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 3, target = "items/dust_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 3, target = "items/dust_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 3, target = "items/dust_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 3, target = "items/dust_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 3, target = "items/dust_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 3, target = "items/dust_tin", source = "KorMetals.png")
})

public class ItemDust extends
    KorSubTypedItem {

  @KorInject
  public ItemDust(
      Kor kor,
      @KorTextConfig(path = ModuleMetal.MODULE_ID, file = ModuleMetal.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "dust",
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
    return configData.getCategory(ModuleMetal.Config.CATEGORY_ITEM_DUST).getBoolean(key);
  }

  @Override
  @Nonnull
  public List<KorOreDictionaryEntry> getKorOreDictionaryEntries(@Nonnull List<KorOreDictionaryEntry> store) {
    MetalType[] metalTypes = MetalType.values();

    for (MetalType metalType : metalTypes) {
      String name = metalType.getName();
      name = "dust" + name.substring(0, 1).toUpperCase() + name.substring(1);
      store.add(new KorOreDictionaryEntry(name, metalType.getMeta()));
    }
    return store;
  }
}
