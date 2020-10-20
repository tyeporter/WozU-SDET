package com.tyeporter.dwightslist;

import com.tyeporter.dwightslist.util.ExpandableList;

public class Main {

    public static void main(String[] args) {
        ExpandableList<String> list = new ExpandableList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        System.out.println(list.toString());

        list.add("j");
        list.add("k");
        System.out.println(list.toString());

        list.remove(5);
        System.out.println(list.toString());
        
        list.remove(5);
        System.out.println(list.toString());

        list.add(new String[]{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"});
        System.out.println(list.toString());

        list.remove(10);
        list.remove(10);
        list.remove(10);
        System.out.println(list.toString());

        list.remove(18);
        System.out.println(list.toString());

        list.add("m");
        System.out.println(list.toString());




        // list.remove(0);
        // System.out.println(list.toString());
    }

}
