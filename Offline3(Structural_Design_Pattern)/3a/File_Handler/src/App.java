public class App {
    public static void main(String[] args) throws Exception {
        file_handler fh = new file_handler();
        //fh.calculate_sum("input.txt");
        file_handler_adapter f_adapter = new file_handler_adapter(fh);
        f_adapter.calculate_sum("input.txt");
        //System.out.println("Hello, World!");
    }
}
