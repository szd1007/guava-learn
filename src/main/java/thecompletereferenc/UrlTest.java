package thecompletereferenc;

import org.junit.Test;
import util.TimeUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author szd1007@github.com
 * @date 2018-12-28 12:01
 */
public class UrlTest {

    @Test
    public void testURL() throws IOException {
        URL url = new URL("http://www.baidu.com/index.html");
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Port: " + url.getPort());
        System.out.println("Host: " + url.getHost());
        System.out.println("File: " + url.getFile());
        System.out.println("Ext: " + url.toExternalForm());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        URLConnection urlConnection = url.openConnection();
        Map<String, List<String>> heads = urlConnection.getHeaderFields();
        System.out.println("expired: " + TimeUtil.getTime(urlConnection.getExpiration()));
        System.out.println("headers: " + heads);
        System.out.println(urlConnection.getContentType());
        int contentLen = urlConnection.getContentLength();
        System.out.println("contentLen: " +contentLen);
        byte[] bytes = new byte[contentLen];
        int len = urlConnection.getInputStream().read(bytes);
        System.out.println("readLen: " + len);

        System.out.println("Content: " + new String(bytes));
        //        try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
//            br.lines().forEach(System.out::println);
//        }
    }

    @Test
    public void testHttpUrlConnection() throws IOException {
        URL hp = new URL("http://www.baidu.com");

        HttpURLConnection con = (HttpURLConnection) hp.openConnection();

        System.out.println("RequestMethod is :" + con.getRequestMethod());
        System.out.println("Response code is : " + con.getResponseCode());
        System.out.println("Response message is :" + con.getResponseMessage());
        System.out.println("header :" + con.getHeaderFields());
    }
}
