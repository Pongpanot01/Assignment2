public class Silver extends Member{
    public Silver (String name, double purchase){
        super(name, purchase);
    }
    
    @Override
    public double cal() {
        return super.getPurchase()*.10d;
    }
    }