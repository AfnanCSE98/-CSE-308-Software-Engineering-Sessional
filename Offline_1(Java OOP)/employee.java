import java.util.ArrayList;

public class employee {
    private String name;

    public String getname(){
        return name;
    }
    public void setname(String nm){
        name = nm; 
    }

    public int lookup_user(bank b , String nm){     
        
        ArrayList<fixed_deposit_account> list_fd = b.get_fixed_deposit(); 
        ArrayList<savings_account> list_sav = b.get_savings(); 
        ArrayList<students_account> list_st = b.get_students(); 

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
    
}
