public class Member {
    private String name;
    private double purchase;
    
    public Member(String name, double purchase) {
        this.name = name;
        this.purchase = purchase;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPurchase() {
        return purchase;
    }
    
    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }
    public double cal (){
        return 0;
    }
    public void display(){
        System.out.println("Customer Name: "+name);
        System.out.println("Purchase Amount: "+purchase);
        System.out.println("Discount: "+cal());
        System.out.println("Total Amount:"+(purchase - cal()));
    
    }
    }