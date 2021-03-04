//package pkg1;

import java.util.Scanner;
//import pkg1.bank;

public class Main {
    public static void main(String []args) {
        String current_user="";  ///can hold values:student,savings,fixed_deposit,MD,officer,cashier
        bank b = new bank();
        
        while(true){
            Scanner sc=new Scanner(System.in);
            String s= sc.nextLine();
            String[] str = s.trim().split("\\s+");
            ///create account command
            if(str[0].equalsIgnoreCase("Create")){
                String name = str[1];
                int initial_dep = Integer.parseInt(str[3]);
                ///checking ac type
                if(str[2].equalsIgnoreCase("Student")){
                    students_account ob = new students_account();
                    String msg = ob.create_account(name, initial_dep);
                    b.add_students_acc(ob);
                    current_user = name;
                    System.out.println(msg);
                }

                else if(str[2].equalsIgnoreCase("Savings")){
                    savings_account ob = new savings_account();
                    String msg = ob.create_account(name, initial_dep);
                    b.add_savings_acc(ob);
                    current_user = name;
                    System.out.println(msg);
                }

                else if(str[2].equalsIgnoreCase("fixed deposit")){

                }
            }
            else if(str[0].equalsIgnoreCase("Deposit")){
                int amount = Integer.parseInt(str[1]);
                boolean is_deposited = b.deposit(current_user, amount);
                int curr_balance = b.get_balance(current_user);
                if(is_deposited){
                    System.out.println(str[1] + " deposited.Current balance " + String.valueOf(curr_balance));
                }
                else System.out.println("Invalid Transaction.Current balance " +String.valueOf(curr_balance));
            }
            else if(str[0].equalsIgnoreCase("Query")){
                int curr_balance = b.get_balance(current_user);
                System.out.println("Current balance " + String.valueOf(curr_balance));
            }
            else if(str[0].equalsIgnoreCase("close")){
                System.out.println("Transaction Closed for " + current_user);
                current_user="";
            }
            else if(str[0].equalsIgnoreCase("Withdraw")){
                int amount = Integer.parseInt(str[1]);
                boolean is_withdrawn = b.withdraw(current_user , amount);
                int curr_balance = b.get_balance(current_user);
                if(is_withdrawn){
                    System.out.println(str[1] + " withdrawn.Current Balance " + String.valueOf(curr_balance));
                }
                else System.out.println("Invalid Transaction.Current balance " +String.valueOf(curr_balance));
            }
            else if(str[0].equalsIgnoreCase("Request")){
                int amount = Integer.parseInt(str[1]);
                boolean is_req_accepted = b.request_loan(current_user, amount);
                if(is_req_accepted){
                    System.out.println("Loan request successful, sent for approval");
                }
                else System.out.println("Loan request failed!");
            }

            
            else{
                System.out.println("Give input");
            }
        }
              
    }

    
}
