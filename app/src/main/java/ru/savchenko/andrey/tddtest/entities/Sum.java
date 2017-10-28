package ru.savchenko.andrey.tddtest.entities;

/**
 * Created by Andrey on 28.10.2017.
 */

public class Sum implements Expression{
    public Expression augend;
    public Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to){
        int amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression add) {
        return new Sum(this, add);
    }

    @Override
    public Expression times(int times) {
        return new Sum(augend.times(times), addend.times(times));
    }

    @Override
    public String toString() {
        return "Sum{" +
                "augend=" + augend +
                ", addend=" + addend +
                '}';
    }
}
