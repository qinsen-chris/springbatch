package com.example.springbatch.codePattern.factoryPattern.impl;

import com.example.springbatch.codePattern.factoryPattern.Human;

public class WhiteHuman implements Human {

    @Override
    public void laugh() {
        System.out.println("white huan laugh");
    }

    @Override
    public void cry() {
        System.out.println("white huan cry");
    }
}
