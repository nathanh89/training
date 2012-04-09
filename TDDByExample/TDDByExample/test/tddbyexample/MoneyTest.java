package tddbyexample;

import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyTest {
    
    @Test
    public void testMultiplication() {
         Money five = Money.dollar(5);
         assertEquals(Money.dollar(10), five.times(2));
         assertEquals(Money.dollar(15), five.times(3));
    }
    
    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
    
    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
    
    @Test
    public void testSimpleAddition(){
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.exchange(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
    
    @Test
    public void testPlusReturnsSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }
    
    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.exchange(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }
    
    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.exchange(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
    
    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.exchange(Money.franc(2), "USD");
        assertEquals(Money.dollar(1),result);
    }
    
    @Test
    public void testArrayEquals(){
        assertEquals(new Object[]{"abc"}, new Object[]{"abc"});
    }
    
    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }
    
    @Test
    public void testMixedAddition(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.exchange(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }
}
