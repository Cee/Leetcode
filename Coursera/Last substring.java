// "static void main" must be defined in a public class.
public class Main {
    public static String lastSubstring(String s) {
        if (s == null || s.length() == 0) { return s; }
        String last = "";
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i);
            if (str.compareTo(last) > 0) { last = str; }
        }
        return last;
    }
    public static void main(String[] args) {
        System.out.println(lastSubstring("helloworldwp"));
    }
}