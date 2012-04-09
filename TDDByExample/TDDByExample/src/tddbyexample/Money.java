package tddbyexample;

public class Money implements Expression {
    protected int amount;
    protected String currency; 
    
    public Money(int amount, String currency){ 
        this.amount = amount; 
        this.currency = currency;
    }

    @Override
    public Expression times(int multiplier){ 
        return new Money(amount *multiplier, currency);
    }
    
    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount &&
                this.currency().equals(money.currency());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.amount;
        hash = 17 * hash + (this.currency != null ? this.currency.hashCode() : 0);
        return hash;
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

    
    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
    
    @Override
    public Money reduce(Bank bank, String to){
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}
