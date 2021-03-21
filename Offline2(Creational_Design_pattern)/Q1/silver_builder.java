import java.util.ArrayList;

public class silver_builder implements builder{
    private product result;
    private component microcontroller_ , weight_measurement_ , identification_ , storage_ , display_ , internet_connection_ , controller_;
    private webserver server;
    private ArrayList<component> comp;
    
    public void build(String net_conn , String framework){
        comp = new ArrayList<component>();
        microcontroller_ = new atmega32();
        weight_measurement_ = new load_sensor();
        identification_ = new rfid_card();
        storage_ = new sd_card();
        display_ = new lcd_screen();
        controller_ = new button();

        set_net_connection(net_conn);
        set_framework(framework);

        add_to_list();
        make_product();
    }

    public void add_to_list(){
        comp.add(microcontroller_);
        comp.add(weight_measurement_);
        comp.add(identification_);
        comp.add(display_);
        comp.add(storage_);
        comp.add(internet_connection_);
        comp.add(controller_);
    }

    public void make_product(){
        result = new product(comp , server);
    }

    public product get_result(){
        return result;
    }

    public void set_net_connection(String net_conn){
        if(net_conn.equalsIgnoreCase("wifi")){
            internet_connection_ = new wifi();
        }
        else if(net_conn.equalsIgnoreCase("gsm")){
            internet_connection_ = new gsm();
        }
        else if(net_conn.equalsIgnoreCase("ethernet")){
            internet_connection_ = new ethernet();
        }
    }

    public void set_framework(String framework){
        if(framework.equalsIgnoreCase("django")){
            server = new django();
        }
        else if(framework.equalsIgnoreCase("spring")){
            server = new spring();
        }
        else if(framework.equalsIgnoreCase("laravel")){
            server = new laravel();
        }
    }
}