package com.sudoplay.mc.kormetals;

import java.util.Arrays;

/**
 * Created by sk3lls on 11/17/2016.
 */
public class Test {

  public static void main(String... args) {

    String[] data = {
        "minecraft:clay_ball * 4",
        "minecraft:clay",
        "ctkormetals:ore_brass * 2",
        "minecraft:wool:4",
        "ore:plankWood"
    };

    for (String d : data) {
      parse(d);
      System.out.println();
    }
  }

  private static void parse(String data) {
    String[] split = data.split("\\*");

    System.out.println(Arrays.toString(split));

    if (split.length == 0) {
      throw new RuntimeException("BAD!");
    }

    if (split.length > 1) {
      Integer integer = Integer.valueOf(split[1].trim());
      System.out.println("Count: " + integer);
    }

    split = split[0].split(":");

    if (split.length < 2 || split.length > 3) {
      throw new RuntimeException("BAD!");
    }

    if (split.length == 3) {
      Integer integer = Integer.valueOf(split[2].trim());
      System.out.println("Meta: " + integer);
    }

    System.out.println("Domain: " + split[0].trim());
    System.out.println("Path: " + split[1].trim());
  }

}
