public class onion_rings extends appetizer_decorator{
    public onion_rings(beverage bv){
        this.bv = bv;
    }

    public String get_description(){
        return bv.get_description() + " , onion rings";
    }

    public double cost(){
        return bv.cost() + 100.0;
    }
}