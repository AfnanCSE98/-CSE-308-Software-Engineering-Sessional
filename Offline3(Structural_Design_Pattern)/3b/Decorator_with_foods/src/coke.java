public class coke extends drink_decorator{
    public coke(beverage bv){
        this.bv = bv;
    }

    public String get_description(){
        return bv.get_description() + " , Coke";
    }

     public double cost(){
        return bv.cost() + 40.0;
    }
}