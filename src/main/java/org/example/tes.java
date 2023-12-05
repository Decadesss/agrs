package org.example;

import java.util.ArrayList;
import java.util.List;

public class tes {
    public static void main(String[] args) {
        List<Flag<?>> list = new ArrayList<>();
        Flag<Integer> integerFlag = new Flag<>("l", "a", Integer.class);
        integerFlag.setValue(1);
        list.add(integerFlag);
        System.out.println(list);
        func(list);
        System.out.println(list);

    }

    private static void func(List<Flag<?>> list) {
        Flag<?> flag = list.get(0);
        flag.setValue(2);
    }
}
