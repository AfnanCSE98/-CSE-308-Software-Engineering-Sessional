//package pkg1;

import java.security.PublicKey;
import java.util.ArrayList;

public class bank {
    private int internal_fund;
    ///accounts
    private ArrayList<savings_account> list_sav ;
    private ArrayList<students_account> list_st ;
    private ArrayList<fixed_deposit_account> list_fd ;
    ///employees
    private Managing_director md;
    private officer o1,o2;
    private ArrayList<cashier> cashiers;
    final private int no_of_cashiers = 5;

    public bank(){
        internal_fund = 1000000;
        list_sav = new ArrayList<savings_account>();
        list_st = new ArrayList<students_account>();
        list_fd = new ArrayList<fixed_deposit_account>();
        md = new Managing_director("MD");
        o1 = new officer("O1");
        o2 = new officer("O2");
        cashiers = new ArrayList<cashier>();
        for(int i=0; i<no_of_cashiers; i++){
            cashier ob = new cashier("C" + String.valueOf(i+1));
            cashiers.add(ob);
        }
        System.out.print("Bank Created;");
        System.out.print(md.getname()+","+o1.getname()+","+o2.getname()+",");
        for(int i=0; i<no_of_cashiers; i++){
            System.out.print(cashiers.get(i).getname() + ",");
        }
        System.out.println(" Created");
    }

    public void inc_year(){
        for(students_account sa : list_st){
            sa.year_inc();
        }
        for(savings_account sv : list_sav){
            sv.year_inc();
        }
        for(fixed_deposit_account sfd : list_fd){
           sfd.year_inc();
        }
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

    public void add_fixed_deposit_acc(fixed_deposit_account ob){
        list_fd.add(ob);
    }
/*
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
        for(fixed_deposit_account ob : list_fd){
            if(ob.name.equalsIgnoreCase(nm)){
                return ob;
            }
        }
        return null;
    }
*/

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
        for(fixed_deposit_account sfd : list_fd){
            if(sfd.name.equalsIgnoreCase(nm)){
              sfd.deposit(amount);
              return sfd.get_deposited_status();   ///different from the other two  
            }                                      ///student and savings acc can deposit anything
        }                                           ///but fixed deposit has some conditions
        return false;
    }

    public int get_balance(String nm){     ///also works as lookup user by employee
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
        for(fixed_deposit_account sfd : list_fd){
            if(sfd.name.equalsIgnoreCase(nm)){
                return sfd.query();
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
        for(fixed_deposit_account sfd : list_fd){
            if(sfd.name.equalsIgnoreCase(nm)){
                sfd.withdraw(amount);
                return sfd.get_withdraw_status();
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
        for(fixed_deposit_account sfd : list_fd){
            if(sfd.name.equalsIgnoreCase(nm)){
                sfd.request_loan(amount);
                return sfd.getloan_status();
            }
        }
        return false;
    }

    public int get_loan(String nm){
        for(students_account sa : list_st){
            if(sa.name.equalsIgnoreCase(nm)){
                return sa.getloan_amount();
            }
        }
        for(savings_account sv : list_sav){
            if(sv.name.equalsIgnoreCase(nm)){
                return sv.getloan_amount();
            }
        }
        for(fixed_deposit_account sfd : list_fd){
            if(sfd.name.equalsIgnoreCase(nm)){
                return sfd.getloan_amount();
            }
        }
        return -1;
    }

    public boolean if_employee(String nm){
        if(nm.equalsIgnoreCase("MD") || nm.equalsIgnoreCase("O1") || nm.equalsIgnoreCase("O2")){
            return true;
        }
        for(int i=0; i<no_of_cashiers; i++){
            if(cashiers.get(i).getname().equalsIgnoreCase(nm)){
                return true;
            }
        }
        return false;
    }

    public boolean isMD(String nm){
        return nm.equalsIgnoreCase("MD");
    }

    public boolean is_MD_or_officer(String nm){
        return nm.equalsIgnoreCase("MD") || nm.equalsIgnoreCase("O1") || nm.equalsIgnoreCase("O2");
    }

    public String approve_loan(){       ///returns the names of ppl whose loans were approved
        String users_whose_loan_approved="";
        String msg;
        for(students_account sa : list_st){
           msg = sa.loan_approved();
           users_whose_loan_approved += msg;
        }
        for(savings_account sv : list_sav){
            msg = sv.loan_approved();
            users_whose_loan_approved += msg;
        }
        for(fixed_deposit_account sfd : list_fd){
            msg = sfd.loan_approved();
            users_whose_loan_approved += msg;
        }
        return users_whose_loan_approved;
    }

    ///following 3 are done by MD only
    public void change_students_interest_rate(double new_rate){
        for(students_account sa : list_st){
            sa.change_interest_rate(new_rate);
         }
    }

    public void change_savings_interest_rate(double new_rate){
        for(savings_account sv : list_sav){
            sv.change_interest_rate(new_rate);
         }
    }

    public void change_fixed_deposit_interest_rate(double new_rate){
        for(fixed_deposit_account sfd : list_fd){
            sfd.change_interest_rate(new_rate);
         }
    }





    
}
