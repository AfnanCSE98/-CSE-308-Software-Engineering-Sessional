public class font implements Aestethics{
    public String name;

    public font(String name){
        this.name = name;
        created();
    }
    public void created() {
        System.out.println(name + " font created");
    }
}