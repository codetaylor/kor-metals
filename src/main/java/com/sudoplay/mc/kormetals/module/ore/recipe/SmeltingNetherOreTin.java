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
        key = "tin"
    ),
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_ORE_NETHER,
        key = "tin"
    ),
    @KorTextConfigDependency(
        filename = ModuleOre.Config.FILENAME,
        category = ModuleOre.Config.CATEGORY_RECIPE_SMELTING,
        key = "tin"
    )
})

public class SmeltingNetherOreTin extends
    SmeltingNetherOre {

  private static final MetalType TYPE = MetalType.Tin;

  @KorInject
  public SmeltingNetherOreTin(
      Kor kor,
      @KorJsonConfig(path = ModuleOre.MODULE_ID, file = "smelting_nether_ore.json") ConfigSmeltingNetherOre config
  ) {
    super(TYPE, kor, config);
  }
}
