package com.thunisoft.booksdemo.controller;

import java.lang.reflect.Method;

public class haha {
    public static void main(String[] args) throws Exception {
        Class<?> clazz =  Class.forName("com.thunisoft.demo.bean.Person");
        String col = (String) "name";
        String val = (String) "123";
        String str = "set"+col.substring(0, 1).toUpperCase() + col.substring(1);
        System.out.println(str);
//                if ("name".equals(map.get("column"))) {
//                    per.setName((String) map.get("value"));
//                } else if ("pwd".equals(map.get("column"))) {
//                    per.setPwd((String) map.get("value"));
//                }
        Method printMethod = clazz.getMethod("setName", String.class);
        printMethod.invoke(clazz.newInstance(),val);
    }
}
