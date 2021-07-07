public class user implements observer{
  private server my_server;

  public user(){}
  public void set_server (server my_server){
    this.my_server = my_server;
  }

  public server get_server_obj(){
    return my_server;
  }
  public void update(String name , int cnt){
    my_server.get_printwriter().println(name + " Stock cnt set to " + Integer.toString(cnt));
  }

  public void update(String name , double price){
    my_server.get_printwriter().println(name + " Stock price set to " + Double.toString(price));
  }
}
