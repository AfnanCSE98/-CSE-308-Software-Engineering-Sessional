import java.util.ArrayList;

public class product{
    private ArrayList<component> comp;
    private webserver server;

    public product(ArrayList<component> ara , webserver ws){
        comp = ara;
        server = ws;
    }
}