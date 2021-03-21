public class laravel_creator extends server_creator{
    private webserver ws;
    public webserver create_server(){
        ws = new laravel();
        return ws;
    }
}