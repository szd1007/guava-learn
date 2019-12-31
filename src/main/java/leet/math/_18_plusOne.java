package leet.math;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Question:
 * Given a number represented as an array of digits, plus one to the number.
 * Example Questions Candidate Might Ask:
 * Q: Could the number be negative?
 * A: No. Assume it is a non-negative number.
 * Q: How are the digits ordered in the list? For example, is the number 12 represented by [1,2] or [2,1]?
 * A: The digits are stored such that the most significant digit is at the head of the list.
 * Q: Could the number contain leading zeros, such as [0,0,1]? A: No.
 */
public class _18_plusOne {
    public static int[] plusOne(int[] digits) {
        int carry=1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if(carry==0){
                break;
            }
            if (digits[i] + carry == 10) {
                digits[i]=0;
                carry=1;
            } else {
                digits[i]=digits[i]+1;
                carry=0;
            }
        }
        if (carry == 1) {
            int[] ret = new int[digits.length+1];
            ret[0]=1;
//            for (int i = 0; i < digits.length; i++) {
//                ret[i+1]= digits[i];
//            }
            System.arraycopy(digits, 0, ret, 1, digits.length);
            return ret;
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] a = new int[]{9,9,9};
        int[] b = new int[]{1,2,9};
        int[] c = new int[]{1,2,3};
        printArray(plusOne(a));
        printArray(plusOne(b));
        printArray(plusOne(c));
    }

    private static void printArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.print(" "+ints[i]);
        }
        System.out.println();
    }


}
