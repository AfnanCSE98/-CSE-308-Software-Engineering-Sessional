///editor is a singletyon class
public class Editor{
    private static language_factory lf;
    private static Editor editor;
    private Parser parser;
    private Aestethics ft,col,st;
    private Editor(){} 

    public static Editor getinInstance(){
        if(editor==null){
            editor = new Editor();
        }
        return editor;
    }

    public void set_language_features(String nm){
        lf = factory_creator.create_factory(nm);
        parser = lf.create_parser();
        ft = lf.create_font();
        st = lf.create_style();
        col = lf.create_color();
    }

    public void parse(){
        parser.parse();
    }
    public language_factory get_language_factory(){
        return lf;
    }
}