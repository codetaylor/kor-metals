package com.sudoplay.mc.kormetals.util;

/**
 * Created by sk3lls on 11/16/2016.
 */
public class Util {

  public static String getOreDictName(String name) {
    String[] parts = name.split("_");

    String newName = "";

    for (String part : parts) {
      newName += part.substring(0, 1).toUpperCase() + name.substring(1);
    }
    return newName;
  }

}
