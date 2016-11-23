package com.sudoplay.mc.kormetals.util;

import com.sudoplay.mc.kor.core.config.text.TextConfigData;
import com.sudoplay.mc.kor.spi.config.KorConfigUtil;
import com.sudoplay.mc.kormetals.shared.MetalAlloyType;
import com.sudoplay.mc.kormetals.shared.MetalType;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by sk3lls on 11/15/2016.
 */
public class ConfigUtil {

  public static void setAlloyMetals(String category, Configuration configuration, TextConfigData textConfigData, boolean enabled) {

    for (MetalAlloyType metalAlloyType : MetalAlloyType.values()) {
      KorConfigUtil.adaptBoolean(category, metalAlloyType.getName(), enabled, configuration, textConfigData);
    }
  }

  public static void setBaseMetals(String category, Configuration configuration, TextConfigData textConfigData, boolean enabled) {

    for (MetalType metalType : MetalType.values()) {
      KorConfigUtil.adaptBoolean(category, metalType.getName(), enabled, configuration, textConfigData);
    }
  }

  public static void setAllMetals(String category, Configuration configuration, TextConfigData textConfigData, boolean enabled) {
    ConfigUtil.setBaseMetals(category, configuration, textConfigData, enabled);
    ConfigUtil.setAlloyMetals(category, configuration, textConfigData, enabled);
  }
}
