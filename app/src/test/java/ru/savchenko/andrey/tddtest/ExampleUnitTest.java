package ru.savchenko.andrey.tddtest;

import org.junit.Test;

import ru.savchenko.andrey.tddtest.entities.Money;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
    public void plus(){
        Money sum = Money.dollar(5).plus(Money.franc(10));
        assertEquals(sum, Money.dollar(10));
    }

}