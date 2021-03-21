public class color implements Aestethics{
    public String name;
    public color(String name){
        this.name = name;
        created();
    }
    public void created() {
        System.out.println(name + " color created");
    }
}