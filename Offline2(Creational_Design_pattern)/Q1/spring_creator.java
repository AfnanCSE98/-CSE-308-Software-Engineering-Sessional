public class spring_creator extends server_creator{
    private webserver ws;
    public webserver create_server(){
        ws = new spring();
        return ws;
    }
}