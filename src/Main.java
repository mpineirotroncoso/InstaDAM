import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> confidencial = new HashMap<>();
        ArrayList<String> postlist = new ArrayList<>();
        confidencial.put("a","a");
        confidencial.put("b","b");
        new Login(confidencial,postlist);
    }
}