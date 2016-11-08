package com.sudoplay.mc.kormetals;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.kor.spi.registry.injection.KorInject;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import javax.annotation.Nonnull;

/**
 * Created by sk3lls on 11/7/2016.
 */
public class KorMetalsCreativeTab extends
    CreativeTabs {

  private Kor kor;

  @KorInject
  public KorMetalsCreativeTab(
      Kor kor
  ) {
    super(CreativeTabs.getNextID(), KorMetals.MOD_ID + "_tab");
    this.kor = kor;
  }

  @Nonnull
  @Override
  public Item getTabIconItem() {
    return Items.EMERALD;
  }
}
