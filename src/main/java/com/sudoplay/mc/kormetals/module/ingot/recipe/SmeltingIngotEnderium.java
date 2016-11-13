package com.sudoplay.mc.kormetals.module.ingot.recipe;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kormetals.module.ingot.ModuleIngot;
import com.sudoplay.mc.kormetals.module.ingot.config.ConfigSmeltingIngot;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/11/2016.
 */
@KorRegistrationTextConfigDependency(dependsOn = {
    @KorTextConfigDependency(
        filename = ModuleIngot.Config.FILENAME,
        category = ModuleIngot.Config.CATEGORY_INGOT,
        key = "enderium"
    ),
    @KorTextConfigDependency(
        filename = ModuleIngot.Config.FILENAME,
        category = ModuleIngot.Config.CATEGORY_RECIPE_SMELTING,
        key = "enderium"
    )
})

public class SmeltingIngotEnderium extends
    SmeltingIngot {

  private static final MetalType TYPE = MetalType.Enderium;

  @KorInject
  public SmeltingIngotEnderium(
      Kor kor,
      @KorJsonConfig(path = ModuleIngot.MODULE_ID, file = "smelting_ingot.json") ConfigSmeltingIngot config
  ) {
    super(TYPE, kor, config);
  }
}
