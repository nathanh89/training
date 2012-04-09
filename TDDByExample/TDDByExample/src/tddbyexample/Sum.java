package tddbyexample;

class Sum implements Expression {
    Money augend;
    Money addend;
    
    public Sum(Money augend, Money addend){
        this.augend = augend;
        this.addend = addend;
    }
    
    Money reduce(Expression source, String to) {
        Sum sum = (Sum) source;
        int amount = sum.augend.amount + sum.addend.amount;
        return new Money(amount, to);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }
}
