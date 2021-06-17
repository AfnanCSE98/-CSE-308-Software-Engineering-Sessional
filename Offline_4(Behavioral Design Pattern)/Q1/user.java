public class user implements observer{
  private int stock_cnt;
  private double stock_price;
  private stock myStock;
  private server my_server;

  public user(stock myStock){
    this.myStock = myStock;
    myStock.registerUser(this);
  }

  public user(){}
  public void set_server (server my_server){
    this.my_server = my_server;
  }

  public void update(String name , int cnt){
    for(server u : my_server.loggedInUsers){

      if(u==my_server)u.get_printwriter().println(name + " Stock cnt set to " + Integer.toString(cnt));
    }
    //my_server.get_printwriter().println(name + " Stock cnt set to " + Integer.toString(cnt));
  }

  public void update(String name , double price){
    for(server u : my_server.loggedInUsers){
      if(u==my_server)u.get_printwriter().println(name + " Stock price set to " + Double.toString(price));
    }
  }
}
