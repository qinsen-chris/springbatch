package com.example.springbatch.codePattern.factoryPattern.impl;

import com.example.springbatch.codePattern.factoryPattern.Human;

public class BlackHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("black Human laugh");
    }

    @Override
    public void cry() {
        System.out.println("blackHuman cry");
    }
}
