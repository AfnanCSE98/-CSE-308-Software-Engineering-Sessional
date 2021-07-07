public interface observer{
  public void update(String name , int cnt);
  public void update(String name , double price);
  public void set_server (server my_server);
  public server get_server_obj();
}
