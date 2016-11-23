package com.sudoplay.mc.kormetals.module.metal.item;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.item.ISubType;
import com.sudoplay.mc.kor.spi.item.KorSubTypedItem;
import com.sudoplay.mc.kor.spi.registry.KorOreDictionaryEntry;
import com.sudoplay.mc.kormetals.module.metal.ModuleMetal;
import com.sudoplay.mc.kor.spi.oredict.OreDictUtil;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sk3lls on 11/18/2016.
 */
/* package */ abstract class AbstractItemMetal extends
    KorSubTypedItem {

  private String oreDictPrefix;

  /* package */ AbstractItemMetal(
      String modId,
      String name,
      String oreDictPrefix,
      ISubType[] subTypes,
      TextConfigData configData
  ) {
    super(
        modId,
        name,
        filterSubTypes(subTypes, configData)
    );
    this.oreDictPrefix = oreDictPrefix;
  }

  private static ISubType[] filterSubTypes(ISubType[] subTypes, TextConfigData configData) {
    List<ISubType> subTypeList = new ArrayList<>();

    for (ISubType subType : subTypes) {

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

    for (ISubType subType : this.getSubTypes()) {
      String name = this.oreDictPrefix + OreDictUtil.convertSnakeCaseToCamelCase(subType.getName());
      store.add(new KorOreDictionaryEntry(name, subType.getMeta()));
    }
    return store;
  }
}
