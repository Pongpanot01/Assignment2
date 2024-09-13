public class Gold extends Member{
    public Gold(String name, double purchase){
        super(name, purchase);
    }

    @Override
    public double cal() {
        return getPurchase () * .15f;
    }

}
