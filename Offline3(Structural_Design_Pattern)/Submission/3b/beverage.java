public abstract class beverage{
    String description = "Unknown beverage";
    double cost;
    public String get_description(){
        return description;
    }

    public abstract double cost();
}