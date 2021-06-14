public class user implements observer{
  private int stock_cnt;
  private double stock_price;
  private stock myStock;

  public user(stock myStock){
    this.myStock = myStock;
    myStock.registerUser(this);
  }

  public void update(int cnt ,  double price){
    this.stock_cnt = cnt;
    this.stock_price = price;
    display();
  }

  public void display(){
    System.out.println(stock_cnt);
    System.out.println(stock_price);
  }
}
