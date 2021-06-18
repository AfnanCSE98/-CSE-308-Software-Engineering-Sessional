public interface subject{
  public void registerUser(observer ob);
  public void removeUser(server ob);
  public void notify_of_price(double new_price);
  public void notify_of_cnt(int new_cnt);
}
