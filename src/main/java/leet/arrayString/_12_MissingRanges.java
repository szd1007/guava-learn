package leet.arrayString;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]
 * Example Questions Candidate Might Ask:
 * Q: What if the given array is empty?
 * A: Then you should return [“0->99”] as those ranges are missing.
 * Q: What if the given array contains all elements from the ranges? A:
 * Return an empty list, which means no range is missing.
 */
public class _12_MissingRanges {

    private static List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> res = new ArrayList<>();
        if (vals.length == 0) {
            res.add(start + "->" + end);
            return res;
        }
        if (start < vals[0]) {
            String t = (start + 1 == vals[0]) ? String.valueOf(start) : start + "->" + (vals[0] - 1);
            res.add(t);
        }
        for (int i = 0; i < vals.length-1; i++) {
            if (vals[i + 1] - vals[i] >= 2) {
                res.add(range((vals), i, i + 1));
            }
        }
        if (end > vals[vals.length - 1]) {
            String t = (end == vals[vals.length - 1] + 1)?String.valueOf(end):vals[vals.length - 1]+1+"->"+end;
            res.add(t);
        }
        return res;
    }

    private static String range(int[] vals, int s, int e) {
        if (vals[s] + 2 == vals[e]) {
            return String.valueOf(vals[s]+1);
        }
        return (vals[s]+1) + "->" + (vals[e]-1);
    }

    private static List<String> findMissingRanges2(int[] vals, int start, int end) {
        List<String> res = new ArrayList<>();
        int pre = start-1;
        for (int i = 0; i <= vals.length; i++) {
            int cur = i==vals.length?end+1:vals[i];
            if(cur-pre>=2)
              res.add(range(pre + 1, cur - 1));
            pre=cur;
        }
        return res;
    }

    private static String range(int s, int e) {
        if (s == e) {
            return String.valueOf(s);
        }
        return s + "->" + e;
    }

    public static void main(String[] args) {
        int vals[]=new int[]{0, 1, 3, 50, 75};
        System.out.println(findMissingRanges2(vals,0,99));
        vals=new int[]{0, 99};
        System.out.println(findMissingRanges2(vals,0,99));
        vals=new int[]{};
        System.out.println(findMissingRanges2(vals,0,99));
        vals=new int[]{0, 1, 3, 50, 99};
        System.out.println(findMissingRanges2(vals,0,99));
    }
}
