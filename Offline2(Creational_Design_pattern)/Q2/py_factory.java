public class py_factory implements language_factory{

    public Parser create_parser(){
        Parser p = new py_parser(); 
        return p;
    }

   public Aestethics create_font(){
        Aestethics f = new font("Consolas");
        return f;
    }

    public Aestethics create_style(){
        Aestethics s = new style("Normal");
        return s;
    }    

    public Aestethics create_color(){
        Aestethics c = new color("Blue");
        return c;
    }    
}