//package pkg1;

import java.util.ArrayList;

//import pkg1.savings_account;
//import pkg1.students_account;

public class bank {
    private int internal_fund;
    private ArrayList<savings_account> list_sav ;
    private ArrayList<students_account> list_st ;

    public bank(){
        internal_fund = 1000000;
        list_sav = new ArrayList<savings_account>();
        list_st = new ArrayList<students_account>();
        System.out.println("Bank Created;");
    }

    public int get_internal_fund(){
        return internal_fund;
    }

    public void add_savings_acc(savings_account ob){
        list_sav.add(ob);
    }

    public void add_students_acc(students_account ob){
        list_st.add(ob);
    }

    public account find_acc(String nm){
        for(students_account ob : list_st){
            if(ob.name.equalsIgnoreCase(nm)){
                return ob;
            }
        }
        for(savings_account ob : list_sav){
            if(ob.name.equalsIgnoreCase(nm)){
                return ob;
            }
        }
        return null;
    }


    public boolean deposit(String nm , int amount){
        for(students_account sa : list_st){
            if(sa.name.equalsIgnoreCase(nm)){
                sa.deposit(amount);
                return true;
            }
        }
        for(savings_account sv : list_sav){
            if(sv.name.equalsIgnoreCase(nm)){
                sv.deposit(amount);
                return true;
            }
        }
        return false;
    }

    public int get_balance(String nm){
        for(students_account sa : list_st){
            if(sa.name.equalsIgnoreCase(nm)){
                return sa.query();
            }
        }
        for(savings_account sv : list_sav){
            if(sv.name.equalsIgnoreCase(nm)){
                return sv.query();
            }
        }
        return -1;
    }

    public boolean withdraw(String nm , int amount){
        for(students_account sa : list_st){
            if(sa.name.equalsIgnoreCase(nm)){
                sa.withdraw(amount);
                return sa.get_withdraw_status();
            }
        }
        for(savings_account sv : list_sav){
            if(sv.name.equalsIgnoreCase(nm)){
                sv.withdraw(amount);
                return sv.get_withdraw_status();
            }
        }
        return false;
    }

    public boolean request_loan(String nm , int amount){
        if(amount > get_internal_fund()){
            return false;
        }
        for(students_account sa : list_st){
            if(sa.name.equalsIgnoreCase(nm)){
                sa.request_loan(amount);
                return sa.getloan_status();
            }
        }
        for(savings_account sv : list_sav){
            if(sv.name.equalsIgnoreCase(nm)){
                sv.request_loan(amount);
                return sv.getloan_status();
            }
        }
        return false;
    }
    
}
