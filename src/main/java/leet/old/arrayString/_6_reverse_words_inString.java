package leet.old.arrayString;

import com.google.gson.internal.$Gson$Preconditions;
import effectiveJava.EfLanguagePoints;
import leet.ICodePoints;

/**
 * Given an input string s, reverse the string word by word.
 * For example, given s = "the sky is blue", return "blue is sky the".
 * 面试中要提问问题
 * Example Questions Candidate Might Ask:
 * Q: What constitutes a word?
 * A: A sequence of non-space characters constitutes a word.
 * Q: Does tab or newline character count as space characters?
 * A: Assume the input does not contain any tabs or newline characters.
 * Q: Could the input string contain leading or trailing spaces?
 * A: Yes. However, your reversed string should not contain leading or trailing spaces.
 * Q: How about multiple spaces between two words?
 * A: Reduce them to a single space in the reversed string.
 */
@ICodePoints("算法题做的过程中要提问，确定算法的适用场景")
public class _6_reverse_words_inString {

    public static String reverse(String line) {
        StringBuilder stringBuilder =new StringBuilder(line.length());
        for (int i = line.length() - 1; i >= 0;) {
            while (i>=0 && ' '==line.charAt(i))i--;
            int j=i-1;
            while (j>=0 && ' '!=line.charAt(j))j--;
            //@ICodePoints("注意边界条件")
            if (j + 1 < 0) {
                break;
            }
            stringBuilder.append(line, j+1, i+1).append(" ");
            i=j;
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverse(" hello world!  "));
    }
}
