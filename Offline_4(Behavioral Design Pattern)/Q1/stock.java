import java.util.*;

public class stock implements subject{
  private int cnt;
  private String name;
  private double price;
  private List<observer> users;

  public stock(String name , int cnt , double price){
    users = new ArrayList<observer>();
    this.name = name;
    this.cnt = cnt;
    this.price = price;
  }

  public void registerUser(observer ob){
    users.add(ob);
    System.out.println(users.size());
  }

  public void removeUser(observer ob){
    users.remove(ob);
  }

  public void notify_of_price(double new_price){
    for(observer ob : users){
      ob.update(name , new_price);
    }
  }

  public void notify_of_cnt(int new_cnt){
    //System.out.print("new cnt ");
    //System.out.println(users.size());
    for(observer ob : users){
      ob.update(name , new_cnt);
    }
  }

  public void set_cnt(int cnt){
    this.cnt = cnt;
    notify_of_cnt(cnt);
  }

  public void set_price(double price){
    this.price = price;
    notify_of_price(price);
  }

  public String get_name(){
    return name;
  }

  public int get_subscribers_cnt(){
    return users.size();
  }
}
