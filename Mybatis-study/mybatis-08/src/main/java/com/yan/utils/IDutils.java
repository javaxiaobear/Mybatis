package com.yan.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

@SuppressWarnings("all")//抑制警告
public class IDutils {

    public static String getTd(){
        return UUID.randomUUID().toString().replaceAll(".","-");
    }

    @Test
    public void test(){

    }
}
