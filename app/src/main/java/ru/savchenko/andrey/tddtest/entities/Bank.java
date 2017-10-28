package ru.savchenko.andrey.tddtest.entities;

import java.util.Hashtable;

/**
 * Created by Andrey on 28.10.2017.
 */

public class Bank {
    private Hashtable rates = new Hashtable();

    public Money reduce(Expression expression, String to) {
        return expression.reduce(this, to);
    }

    public int rate(String from, String to){
        if(from.equals(to))return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }

    public void addRate(String from, String to, int rate){
        rates.put(new Pair(from, to), new Integer(rate));
    }
}
