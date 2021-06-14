public class french_fry extends appetizer_decorator{
    public french_fry(beverage bv){
        this.bv = bv;
    }

    public String get_description(){
        return bv.get_description() + " , french fry";
    }

    public double cost(){
        return bv.cost() + 100.0;
    }
}