public class style implements Aestethics{
    public String name;
    public style(String name){
        this.name = name;
        created();
    }
    public void created() {
        System.out.println(name + " style created");
    }
}