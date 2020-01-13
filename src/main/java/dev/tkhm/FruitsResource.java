package dev.tkhm;

import javax.validation.Valid;

import dev.tkhm.api.FruitsApi;
import dev.tkhm.model.Fruit;

public class FruitsResource implements FruitsApi {

    @Override
    public void fruitsDelete(@Valid Fruit fruit) {
        // TODO Auto-generated method stub
    }

    @Override
    public Fruit fruitsGet() {
        // TODO Auto-generated method stub
        Fruit yumFruit = new Fruit();
        yumFruit.setName("マンゴー");
        return yumFruit;
    }

    @Override
    public void fruitsPost(@Valid Fruit fruit) {
        // TODO Auto-generated method stub
    }
}
