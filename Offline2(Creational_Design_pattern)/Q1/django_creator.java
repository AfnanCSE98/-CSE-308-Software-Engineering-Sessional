public class django_creator extends server_creator{
    private webserver ws;
    public webserver create_server(){
        ws = new django();
        return ws;
    }
}