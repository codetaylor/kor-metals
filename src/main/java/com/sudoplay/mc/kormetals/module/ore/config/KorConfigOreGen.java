package com.sudoplay.mc.kormetals.module.ore.config;

import com.sudoplay.mc.kor.spi.world.KorOreGenConfigEntry;

import java.util.Map;

/**
 * Created by sk3lls on 11/21/2016.
 */
public interface KorConfigOreGen {
  Map<String, KorOreGenConfigEntry> getConfigEntryMap();
}
