package thecompletereferenc;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

    public static void main(String[] args) {
        String a = "111323423323211223242";

        System.out.println(a.replace("1", "A"));
        System.out.println("replace All: 正则表达式替换");
        System.out.println(a.replaceAll("[0-9]", "A"));

    }

    @Test
    public void testPattern() {
        Pattern pat;
        Matcher mat;
        boolean found;

        pat = Pattern.compile("Java");
        mat = pat.matcher("Java");
        found = mat.matches();  //check for match

        System.out.println("Testing Java against Java.");
        if (found)
            System.out.println("Matches");
        else
            System.out.println("No Match");

        System.out.println();

        System.out.println("Testing Java against Java 9.");
        mat = pat.matcher("Java 9");//create a new matcher
        found = mat.matches();
        if (found)
            System.out.println("Matches");
        else
            System.out.println("No Match");

        //查找匹配的子字符串
        found = mat.find();
        String group = mat.group();
        if (found)
            System.out.println("Matches");
        else
            System.out.println("No Match");
        System.out.println("group:" + group);
    }

    @Test
    public void testPatterFind() {
        String testStr = "test 1, 3 3 test";
        Pattern pattern = Pattern.compile("test");
        Matcher matcher = pattern.matcher(testStr);
        while (matcher.find()) {
            System.out.println("find " + matcher.group() + "  /index: " + matcher.start());
        }
    }

    @Test
    public void testPatterQuantifier() {
        Pattern pattern = Pattern.compile("W+");
        Matcher matcher = pattern.matcher("W WW WWW sW");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println(">>>>>>>>>>>>>>");
        //https://img-blog.csdn.net/20171101232909001?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzU5MTc4MDA=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast
        //e****d  greedy behavior 贪婪模式
        pattern = Pattern.compile("e.+d");
        matcher = pattern.matcher("extend cup end table ed");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println(">>>>>>>>>>>>>>");
        //e****d  reluctant behavior 最小匹配模式
        pattern = Pattern.compile("e.+?d");
        matcher = pattern.matcher("extend cup end table ed");

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println(">>>>>>>>>>>>>>");

    }

    @Test
    public void testPatternClassOfCharacters() {
        //匹配小写字母单词
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher("this is a test.");

        while (matcher.find()) {
            System.out.println("Match: " + matcher.group());
        }

    }

    @Test
    public void testPatternReplaceAll() {
        String str = "Jon Jonathan Frank ken Todd";
        //最小匹配，原有表达式上加?  匹配最小字符串jon*空格
        Pattern pattern = Pattern.compile("Jon.*? ");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("|" + matcher.group() + "|");
        }

        str = matcher.replaceAll("Eric ");
        System.out.println("replace with eric");
        System.out.println(str);

        //one time pattern, not efficient in repeated use pattern
        System.out.println("one time matches ");
        System.out.println(Pattern.matches(str, str));
    }

    @Test
    public void tesPatternSplit() {
        Pattern pattern = Pattern.compile("[ ,.!]");
        String str = "one two,alpha9 12!done";
        String sp[] = pattern.split(str);

        for (int i = 0; i < sp.length; i++) {
            System.out.println("Next token: " + sp[i]);
        }

        System.out.println(">>>>>>>>>>");
        sp = str.split("[ ,.!]");
        for (int i = 0; i < sp.length; i++) {
            System.out.println("Next token: " + sp[i]);
        }
    }
}
