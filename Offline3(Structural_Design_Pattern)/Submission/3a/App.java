import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        file_handler_adapter f_adapter = new file_handler_adapter("input.txt");

        f_adapter.calculate_sum();
    }
}
