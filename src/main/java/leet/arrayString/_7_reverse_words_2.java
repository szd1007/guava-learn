package leet.arrayString;

/**
 * 同6 但是单词之间只有一个空格连接
 * 要求不用额外空间进行反转
 * 允许常数个字段
 *
 */
public class _7_reverse_words_2 {

    public static void reversWords(char[] s){
        reverse(s, 0, s.length-1);
        int start=0,end;
        for (int i = 0; i < s.length;i++) {
            if(s[i]==' '){
                end =i-1;
                reverse(s, start,end);
                start =i+1;
            } else if(i==s.length-1){
                reverse(s, start, i);
                break;
            }
        }
    }
    static void reverse(char[]s,int start, int end){
        if (s.length ==0 || end<=start|| end>=s.length) {
            return;
        }
        char t ;
        int i=start,j=end;
        while (i<j){
            t= s[i];
            s[i]=s[j];
            s[j]=t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[]s = "hello world".toCharArray();
        reversWords(s);
        System.out.println(s);
    }
}
