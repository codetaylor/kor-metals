package com.sudoplay.mc.kormetals.module.nugget.item;

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
import com.sudoplay.mc.kormetals.module.nugget.ModuleNugget;
import com.sudoplay.mc.kormetals.shared.MetalType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sk3lls on 11/12/2016.
 */

@KorGenerateItemSubTypedAssets(
    name = "nugget",
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
    @KorLangEntry(key = "item.nugget_brass.name", value = "Brass Nugget"),
    @KorLangEntry(key = "item.nugget_copper.name", value = "Copper Nugget"),
    @KorLangEntry(key = "item.nugget_electrum.name", value = "Electrum Nugget"),
    @KorLangEntry(key = "item.nugget_enderium.name", value = "Enderium Nugget"),
    @KorLangEntry(key = "item.nugget_invar.name", value = "Invar Nugget"),
    @KorLangEntry(key = "item.nugget_lead.name", value = "Lead Nugget"),
    @KorLangEntry(key = "item.nugget_lumium.name", value = "Lumium Nugget"),
    @KorLangEntry(key = "item.nugget_nickel.name", value = "Nickel Nugget"),
    @KorLangEntry(key = "item.nugget_platinum.name", value = "Platinum Nugget"),
    @KorLangEntry(key = "item.nugget_signalum.name", value = "Signalum Nugget"),
    @KorLangEntry(key = "item.nugget_silver.name", value = "Silver Nugget"),
    @KorLangEntry(key = "item.nugget_tin.name", value = "Tin Nugget")
})

@KorGenerateImageSlices(slices = {
    @KorImageSliceEntry(col = 7, row = 2, target = "items/nugget_brass", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 1, row = 2, target = "items/nugget_copper", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 9, row = 2, target = "items/nugget_electrum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 12, row = 2, target = "items/nugget_enderium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 8, row = 2, target = "items/nugget_invar", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 4, row = 2, target = "items/nugget_lead", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 11, row = 2, target = "items/nugget_lumium", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 5, row = 2, target = "items/nugget_nickel", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 6, row = 2, target = "items/nugget_platinum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 10, row = 2, target = "items/nugget_signalum", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 3, row = 2, target = "items/nugget_silver", source = "KorMetals.png"),
    @KorImageSliceEntry(col = 2, row = 2, target = "items/nugget_tin", source = "KorMetals.png")
})

public class ItemNugget extends
    KorSubTypedItem {

  @KorInject
  public ItemNugget(
      Kor kor,
      @KorTextConfig(path = ModuleNugget.MODULE_ID, file = ModuleNugget.MODULE_ID + ".cfg") TextConfigData configData
  ) {
    super(
        kor.getModId(),
        "nugget",
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
    return configData.getCategory(ModuleNugget.Config.CATEGORY_NUGGET).getBoolean(key);
  }

  @Override
  @Nonnull
  public List<KorOreDictionaryEntry> getKorOreDictionaryEntries(@Nonnull List<KorOreDictionaryEntry> store) {
    MetalType[] metalTypes = MetalType.values();

    for (MetalType metalType : metalTypes) {
      String name = metalType.getName();
      name = "nugget" + name.substring(0, 1).toUpperCase() + name.substring(1);
      store.add(new KorOreDictionaryEntry(name, metalType.getMeta()));
    }
    return store;
  }
}
