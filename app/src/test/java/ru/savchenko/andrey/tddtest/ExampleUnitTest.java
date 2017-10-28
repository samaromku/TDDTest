package ru.savchenko.andrey.tddtest;

import org.junit.Test;

import ru.savchenko.andrey.tddtest.entities.Bank;
import ru.savchenko.andrey.tddtest.entities.Expression;
import ru.savchenko.andrey.tddtest.entities.Money;
import ru.savchenko.andrey.tddtest.entities.Sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static ru.savchenko.andrey.tddtest.entities.Const.CHF;
import static ru.savchenko.andrey.tddtest.entities.Const.USD;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void dollarEquality(){
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertEquals(Money.franc(5), Money.franc(5));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testFrancMultiply(){
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }

    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void convertFrancInDollar(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
    @Test
    public void testIdentyRate(){
        assertEquals(1, new Bank().rate(USD, USD));
    }

    @Test
    public void testSimpleAddition(){
        Bank bank = new Bank();
        Expression sum = Money.dollar(5).plus(Money.dollar(5));
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testReturnSum(){
        Expression sum = new Sum(Money.dollar(5), Money.dollar(10));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testMiAdd(){
        Expression fiveBuck = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(CHF, USD, 2);
        Money result = bank.reduce(fiveBuck.plus(tenFranc), USD);
        assertEquals(result, Money.dollar(10));
    }

    @Test
    public void testPlusMoney(){
        Expression fiveBuck = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(CHF, USD, 2);
        Expression sum = new Sum(fiveBuck, tenFranc).plus(fiveBuck);
        Money result = bank.reduce(sum, USD);
        assertEquals(result, Money.dollar(15));
    }

    @Test
    public void testTimesMoney(){
        Expression fiveBuck = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(CHF, USD, 2);
        Expression sum = new Sum(fiveBuck, tenFranc).times(2);
        Money result = bank.reduce(sum, USD);
        assertEquals(result, Money.dollar(20));
    }
}