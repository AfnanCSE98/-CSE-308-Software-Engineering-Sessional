public class coffee extends drink_decorator{
    public coffee(beverage bv){
        this.bv = bv;
    }

    public String get_description(){
        return bv.get_description() + " , Coffee";
    }

    public double cost(){
        return bv.cost() + 50.0;
    }
}