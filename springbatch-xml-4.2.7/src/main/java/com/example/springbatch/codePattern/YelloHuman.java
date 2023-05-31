package com.example.springbatch.codePattern;

import com.example.springbatch.codePattern.factoryPattern.Human;

public class YelloHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("yelloHuman laugh");
    }

    @Override
    public void cry() {
        System.out.println("yelloHuman cry");
    }
}
