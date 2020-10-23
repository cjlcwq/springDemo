package com.cjl.csdn;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveUseIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("8");
        list.add("4");
        list.add("2");
        list.add("6");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str + "  ");
            if ("8".equals(str)){
                iterator.remove();
            }
        }
    }
}
