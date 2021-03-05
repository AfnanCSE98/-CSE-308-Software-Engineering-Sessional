

public class fixed_deposit_account extends account {

    private int loan;
    final private int loan_upper_bound = 100000;
    private double interest_rate;
    private boolean took_loan;
    final private double loan_interest_rate = 0.1;
    private int requested_loan;  ///holds the total valid loan amount
    private boolean withdrawal_status;
    private boolean deposited_status;
    final private int min_initial_dep = 100000;
    private int year;

    @Override
    public String create_account(String nm , int initial_dep){
        if(initial_dep<min_initial_dep){
            return "Account creation failed.Need initial deeposit at least " + String.valueOf(min_initial_dep);
        }
        else{
            name = nm;                      ///if same name exists,show error msg from main.java
            balance = initial_dep;
            year = 0;
            loan = 0;
            requested_loan = 0;
            year = 0;
            interest_rate = 0.05;
            took_loan = false;
            withdrawal_status = false;

        return "Fixed deposit account for " + nm + " created.Initial balance is " + String.valueOf(balance);
    
        }
    }

    public void change_interest_rate(double rate){
        interest_rate = rate;
    }

    @Override
    public void deposit(int amount){
        if(amount>=50000){
            balance += amount;
            deposited_status = true;
        }
        else deposited_status = false;
    }

    public boolean get_deposited_status(){
        return deposited_status;
    }

    public int get_year(){
        return year;
    }
    
    @Override
    public void withdraw(int amount){
        if(year==0 || amount>balance){
            withdrawal_status = false;
        }
        else{
            balance -= amount;    
            withdrawal_status = true;    
        }
    }

    public boolean get_withdraw_status(){
        return withdrawal_status;
    }

    @Override
    public int query(){
        return balance;
    }

    public int getloan_amount(){
        return loan;
    }

    public boolean getloan_status(){
        return took_loan;
    }

    @Override 
    public void request_loan(int amount){
        if(amount<=loan_upper_bound){                //need to check if bank has that much initial fund also
            took_loan = true;
            requested_loan += amount;
        }else took_loan = false;
        
    }    

    public String loan_approved(){
        loan += requested_loan;
        balance += loan;

        requested_loan = 0;
        
        if(loan_pending()){
            return name+" ";
        }else return "";
    }

    public boolean loan_pending(){
        return requested_loan>0;
    }

    public void year_inc(){
        year++;
        balance += (balance*interest_rate);
        balance -= (loan*loan_interest_rate);
        balance -= 500;
    }

}
