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
  }

  public void removeUser(server s_ob){
    for(observer o:users){
      if(o.get_server_obj()==s_ob){
        users.remove(o);
        break;
      }
    }
  }

  public void notify_of_price(double new_price){
    for(observer ob : users){
      ob.update(name , new_price);
    }
  }

  public void notify_of_cnt(int new_cnt){
    for(observer ob : users){
      ob.update(name , new_cnt);
    }
  }

  public void set_cnt(int cnt){
    this.cnt = cnt;
    notify_of_cnt(cnt);
  }

  public void increase_price(double price){
    this.price += price;
    notify_of_price(this.price);
  }

  public void decrease_price(double price){
    this.price -= price;
    notify_of_price(this.price);
  }

  public String get_name(){
    return name;
  }

  public int get_subscribers_cnt(){
    return users.size();
  }

  public List<observer> get_user_list(){
    return users;
  }
}
