public class laravel_creator extends server_creator{
    private static webserver ws;
    public static webserver create_server(){
        ws = new laravel();
        return ws;
    }
}