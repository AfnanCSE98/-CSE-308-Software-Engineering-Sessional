import java.util.*;

public class stock implements subject{
  private int cnt;
  private double price;
  private List<observer> users;

  public stock(){
    users = new ArrayList<observer>();
  }

  public void registerUser(observer ob){
    users.add(ob);
  }

  public void removeUser(observer ob){
    users.remove(ob);
  }

  public void notifyUser(){
    for(observer ob : users){
      ob.update(cnt , price);
    }
  }

  public void values_changed(){
    notifyUser();
  }

  public void set_cnt(int cnt){
    this.cnt = cnt;
    values_changed();
  }

  public void set_price(double price){
    this.price = price;
    values_changed();
  }
}
