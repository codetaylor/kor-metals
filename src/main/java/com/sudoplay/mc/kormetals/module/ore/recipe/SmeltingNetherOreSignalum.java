package com.sudoplay.mc.kormetals.module.ore.recipe;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.dependency.KorRegistrationTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.dependency.KorTextConfigDependency;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import com.sudoplay.mc.kor.spi.registry.injection.KorJsonConfig;
import com.sudoplay.mc.kormetals.module.ore.ModuleOre;
import com.sudoplay.mc.kormetals.module.ore.config.ConfigSmeltingNetherOre;
import com.sudoplay.mc.kormetals.shared.MetalType;

/**
 * Created by sk3lls on 11/11/2016.
 */
@KorRegistrationTextConfigDependency(dependsOn = {
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_ORE_OVERWORLD,
        key = "signalum"
    ),
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_ORE_NETHER,
        key = "signalum"
    ),
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_RECIPE_SMELTING,
        key = "signalum"
    )
})

public class SmeltingNetherOreSignalum extends
    SmeltingNetherOre {

  private static final MetalType TYPE = MetalType.Signalum;

  @KorInject
  public SmeltingNetherOreSignalum(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "smelting_nether_ore.json") ConfigSmeltingNetherOre config
  ) {
    super(TYPE, kor, config);
  }
}
