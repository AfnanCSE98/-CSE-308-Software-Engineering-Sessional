/*
Construct a class indicating the following using decorator pattern:
1. Beef Pizza with French fry
2. Veggi Pizza with onion rings
3. A combo meal with Veggi Pizza, French Fry and Coke
4. A combo meal with Veggi Pizza, Onion Rings and Coffee
5. A Beef Pizza only
*/

public class App {
    public static void main(String[] args) throws Exception {
        beverage bp = new beef_pizza();
        beverage bv1 = new french_fry(bp); //Beef Pizza with French fry
        System.out.print(bv1.get_description() + " Cost : ");
        System.out.println(bv1.cost());

        beverage vp = new veggi_pizza();
        beverage bv2 =  new onion_rings(vp);//Veggi Pizza with onion rings
        System.out.print(bv2.get_description() + " Cost : ");
        System.out.println(bv2.cost());

        beverage vp_ff = new french_fry(vp);
        beverage bv3 = new coke(vp_ff);//A combo meal with Veggi Pizza, French Fry and Coke
        System.out.print(bv3.get_description() + " Cost : ");
        System.out.println(bv3.cost());

        beverage bv4 = new coffee(bv2);//A combo meal with Veggi Pizza, Onion Rings and Coffee
        System.out.print(bv4.get_description() + " Cost : ");
        System.out.println(bv4.cost());

        beverage bv5 = new beef_pizza();//A Beef Pizza only
        System.out.print(bv5.get_description() + " Cost : ");
        System.out.println(bv5.cost());

    }
}
