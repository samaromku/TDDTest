package ru.savchenko.andrey.tddtest.entities;

/**
 * Created by Andrey on 28.10.2017.
 */

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression add);

    Expression times(int times);
}
