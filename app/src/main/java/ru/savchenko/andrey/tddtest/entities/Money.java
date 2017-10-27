package ru.savchenko.andrey.tddtest.entities;

/**
 * Created by Andrey on 27.10.2017.
 */

public class Money {
    protected int amount;
    protected String currency;
    public String currency(){
        return currency;
    }

    public Money plus(Money add){
        return new Money(amount + add.amount/2, currency);
    }

    public Money times(int times) {
        return new Money(times * amount, currency);
    }
//    public abstract Money times(int times);

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (amount != money.amount) return false;
        return currency != null ? currency.equals(money.currency) : money.currency == null;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }
    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }


}
