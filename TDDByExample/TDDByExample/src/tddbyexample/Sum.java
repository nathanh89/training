package tddbyexample;

class Sum implements Expression {
    Expression augend;
    Expression addend;
    
    public Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }
    
    Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        int amount = ((Money)(sum.augend)).amount + 
                     ((Money)(sum.addend)).amount;
        return new Money(amount, to);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.reduce(bank, to).amount + 
                addend.reduce(bank, to).amount;
        return new Money(amount, to);
    }
    
    @Override
    public Expression plus(Expression addend){
        return null;
    }
}
