package tddbyexample;

public class Money {
    protected int amount;
    protected String currency; 
    
    public Money(int amount, String currency){ 
        this.amount = amount; 
        this.currency = currency;
    }

    public Money times(int multiplier){ 
        return new Money(amount *multiplier, currency);
    }
    
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount &&
                this.currency().equals(money.currency());
    }
    
    static Money dollar(int amount){
        return new Money(amount, "USD");
    }
    
    static Money franc(int amount){
        return new Money(amount, "CHF");
    }
    
    String currency(){ return currency; }
    
    @Override
    public String toString(){
        return amount + " " + currency;
    }

    Money plus(Money addend) {
        return new Money(amount+addend.amount, currency);
    }
}
