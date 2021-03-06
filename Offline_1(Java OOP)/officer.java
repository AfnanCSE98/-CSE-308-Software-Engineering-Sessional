import java.util.ArrayList;

public class officer extends employee {

    public officer(String nm){
        setname(nm);
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
