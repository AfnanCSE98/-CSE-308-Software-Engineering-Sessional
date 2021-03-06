import java.util.ArrayList;

public class Managing_director extends employee {
    
    public Managing_director(String nm){
        setname(nm);
    }

    public int see_internal_fund(bank b){
        return b.get_internal_fund();
    }

    public void change_students_interest_rate(bank b , double new_rate){

        ArrayList<students_account> list_st = b.get_students(); 
        for(students_account sa : list_st){
            sa.change_interest_rate(new_rate);
        }
    }

    public void change_savings_interest_rate(bank b , double new_rate){

        ArrayList<savings_account> list_sv = b.get_savings(); 
        for(savings_account sv : list_sv){
            sv.change_interest_rate(new_rate);
        }
    }

    public void change_fd_interest_rate(bank b , double new_rate){

        ArrayList<fixed_deposit_account> list_sfd = b.get_fixed_deposit(); 
        for(fixed_deposit_account sfd : list_sfd){
            sfd.change_interest_rate(new_rate);
        }
    }

    public String approve_loan(bank b){       ///returns the names of ppl whose loans were approved
        String users_whose_loan_approved="";
        String msg;

        ArrayList<fixed_deposit_account> list_fd = b.get_fixed_deposit(); 
        ArrayList<savings_account> list_sav = b.get_savings(); 
        ArrayList<students_account> list_st = b.get_students(); 
        
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
    
}
