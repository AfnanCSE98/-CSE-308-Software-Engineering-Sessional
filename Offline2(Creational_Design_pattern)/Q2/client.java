import java.util.Scanner;

public class client{
    public static void main(String[] args) {
        Editor editor = Editor.getinInstance();
        System.out.println("Enter your preferred language: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        editor.set_language_features(str);

        System.out.println("Do you want to parse?(y/n): ");
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        if(str.equalsIgnoreCase("y")){
            editor.parse();
        }
    }
}