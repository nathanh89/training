package tddbyexample;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyTest {
    
    Expression fiveBucks = Money.dollar(5);
    Expression tenFrancs = Money.franc(10);
    Bank bank = new Bank();
    
    
    @Before
    public void setup(){
        bank.addRate("CHF", "USD", 2);
    }
    
    @Test
    public void testMultiplication() {
         assertEquals(Money.dollar(10), fiveBucks.times(2));
         assertEquals(Money.dollar(15), fiveBucks.times(3));
    }
    
    @Test
    public void testEquality(){
        assertTrue(Money.dollar(5).equals(fiveBucks));
        assertFalse(fiveBucks.equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(fiveBucks));
    }
    
    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
    
    @Test
    public void testSimpleAddition(){
        Expression sum = fiveBucks.plus(fiveBucks);
        Money reduced = bank.exchange(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
    
    @Test
    public void testPlusReturnsSum(){
        Expression result = fiveBucks.plus(fiveBucks);
        Sum sum = (Sum) result;
        assertEquals(fiveBucks, sum.augend);
        assertEquals(fiveBucks, sum.addend);
    }
    
    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Money result = bank.exchange(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }
    
    @Test
    public void testReduceMoney(){
        Money result = bank.exchange(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
    
    @Test
    public void testReduceMoneyDifferentCurrency(){
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
        Money result = bank.exchange(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }
    
    @Test
    public void testSumPlusMoney(){
        Expression sum = new Sum(fiveBucks,tenFrancs).plus(fiveBucks);
        Money result = bank.exchange(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }
    
    @Test
    public void testSumTimes(){
        Expression sum = new Sum(fiveBucks,tenFrancs).times(2);
        Money result = bank.exchange(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }
    
    @Test
    public void testExpressionOperations(){
        Expression sum = fiveBucks.plus(tenFrancs);
        Expression product = fiveBucks.times(10);
        Sum combined = new Sum(sum,product);
        Money result = bank.exchange(combined, "USD");
        assertEquals(Money.dollar(60), result);
    }
}
