public class HelloWorld {
    public static String hello(String msg) {
        if (msg == null || msg.equals("")) {
            return "Hello, World!";
        } else {
            return String.join(msg, "Hello, ", "!");
        }
    }
}
