import java.util.Scanner;

public class client{
    public static void main(String []args){
        System.out.println("Choose your package :\n1.Silver\n2.Gold\n3.Diamond\n4.Platinum");
        Scanner sc=new Scanner(System.in);
        String pkg="",net_conn="",framework="";
        int p;
        p = sc.nextInt();
        if(p==1){
            pkg = "silver";
        }else if(p==2){
            pkg = "gold";
        }
        else if(p==3){
            pkg = "diamond";
        }
        else if(p==4){
            pkg = "platinum";
        }

        System.out.println("Internet Connection :\n1.WiFi\n2.GSM\n3.Ethernet");
        //Scanner sc=new Scanner(System.in);
        p = sc.nextInt();
        if(p==1){
            net_conn = "wifi";
        }else if(p==2){
            net_conn = "gsm";
        }
        else if(p==3){
            net_conn = "ethernet";
        }
        System.out.println("Web Framework :\n1.Django\n2.Spring\n3.laravel");
        //Scanner sc=new Scanner(System.in);
        p = sc.nextInt();
        if(p==1){
            framework = "django";
        }else if(p==2){
            framework = "spring";
        }
        else if(p==3){
            framework = "laravel";
        }

        director d = new director(pkg);
        d.make(net_conn , framework);
    }
}