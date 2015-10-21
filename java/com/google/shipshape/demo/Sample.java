package com.google.shipshape.demo;

import javax.annotation.Nullable;
import java.util.List;

public class Sample {
  void test(@Nullable List<String> list, String str) {
    if (list != null) {
      list.add(str);
    }
    list.add(str);
    if (list == null) {
      return;
    }
    list.add(str);
  }
}
