import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

public class unicode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("测试","utf-8"));
    }
}
