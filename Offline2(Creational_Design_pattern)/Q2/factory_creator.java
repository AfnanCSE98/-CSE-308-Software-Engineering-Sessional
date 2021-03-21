public class factory_creator{

    private static language_factory lf;

    public static language_factory create_factory(String nm){
        if(nm.equalsIgnoreCase("c")){
            lf =  new c_factory();        
        }
        else if(nm.equalsIgnoreCase("cpp")){
            lf = new cpp_factory();         
        }
        else if(nm.equalsIgnoreCase("python")){
            lf = new py_factory();
        }

        return lf;

    }
}