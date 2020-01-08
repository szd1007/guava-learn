package leet.misc;

import leet.ICodePoints;

import java.util.ArrayList;
import java.util.List;

/**
 *循环输出矩阵
 Given a matrix of m ✕ n elements (m rows, n columns), return all elements of the matrix in spiral order.
 For example, given the following matrix:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]

 [[6,9,7]]

 You should return [1,2,3,6,9,8,7,4,5].
 */
public class _35_Matrix_print {


    /**
     [ 1, 2, 3 ],
     [ 4, 5, 6 ],
     [ 7, 8, 9 ]
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if(matrix.length==0)
            return results;
        @ICodePoints("m n 控制 左右下上每次的个数")
        int m = matrix.length, n = matrix[0].length;
        @ICodePoints(" nm nm -m -n -m -n ")
        int row=0, col=-1;
//        @ICodePoints("row col控制下标 ，+ + - -")
        while (true){
            for (int i = 0; i < n; i++) {
                results.add(matrix[row][++col]);
            }
            if(--m==0)break;;
            for (int i = 0; i < m; i++) {
                results.add(matrix[++row][col]);
            }
            if(--n==0)break;
            for (int i = 0; i < n; i++) {
                results.add(matrix[row][--col]);
            }
            if(--m==0)break;
            for (int i = 0; i < m; i++) {
                results.add(matrix[--row][col]);
            }
            if(--n==0)break;;
        }
        return results;
    }




    @ICodePoints("wrong answer 有死循环")
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0)
            return result;
        int iEnd = matrix.length;
        int jEnd = matrix[0].length;
        int j = 0;
        int i = 0;
        for (; j < jEnd && i<iEnd;i++,j++,iEnd--,jEnd--) {
            for (int k = j; k < jEnd; k++) {
                result.add(matrix[i][k]);
            }
            for (int k = i+1; k < iEnd; k++) {
                result.add(matrix[k][jEnd-1]);
            }
            for (int k = jEnd-2; k >=j && iEnd-1>i ; k--) {
                result.add(matrix[iEnd-1][k]);
            }
            for (int k = iEnd-2; k >i ; k--) {
                result.add(matrix[k][j]);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        /**
         *  [ 1, 2, 3 ],
         *  [ 4, 5, 6 ],
         *  [ 7, 8, 9 ]
         *
         *
         *  [1, 2, 3, 4],
         *  [5, 6, 7, 8],
         *  [9,10,11, 12]
         *  ]
         *
         *  [1,2,3,4,8,12,11,10,9,5,6,7,6]
         * 预期结果
         *  [1,2,3,4,8,12,11,10,9,5,6,7]
         *
         */
        int [][]matrix = {{1,2,3},{4,5,6},{7, 8, 9}};

        System.out.println(spiralOrder(matrix));

//        int [][]matrix2={{1,2},{4,5}};
//        System.out.println(spiralOrder2(matrix2));
//        int [][]matrix3={{1}};
//        System.out.println(spiralOrder2(matrix3));
    }
}
