public class director{
    private builder b;

    public director(String pkg){
        if(pkg.equalsIgnoreCase("silver")){
            b = new silver_builder();
        }
        else if(pkg.equalsIgnoreCase("gold")){
            b = new gold_builder();
        } 
        else if(pkg.equalsIgnoreCase("diamond")){
            b = new diamond_builder();
        }
        else if(pkg.equalsIgnoreCase("platinum")){
            b = new platinum_builder();
        }
        
    }

    public void make(String net_conn , String framework){
        b.build(net_conn , framework);
    }

}