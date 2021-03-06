//package pkg1;

 public abstract class account{
    public String name;
    public int balance;
    
    abstract String create_account(String nm , int initial_dep);
    abstract void deposit(int amount);
    abstract void withdraw(int amount);
    abstract int query();
    abstract void request_loan(int amount);

}