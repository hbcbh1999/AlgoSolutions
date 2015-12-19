/*
 * Given an array of n objects with k different colors (numbered 
 * from 1 to k), sort them so that objects of the same color are 
 * adjacent, with the colors in the order 1, 2, ... k.

Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors 
in-place to [1, 2, 2, 3, 4].

Note
You are not suppose to use the library's sort function for this 
problem.

Challenge
A rather straight forward solution is a two-pass algorithm using 
counting sort. That will cost O(k) extra memory. Can you do it 
without using extra memory?
 */
public class SortColorsII {

    public void sortColors2(int[] colors, int k) {
        for (int i = 0; i < colors.length; ++i) {
            if (colors[i] > 0) {
                int position = colors[i];
                if (colors[position] > 0) {
                    colors[position] = -1;
                    colors[i] = colors[position];
                    i--;
                } else {
                    colors[position]--;
                    colors[i] = 0;
                }
            }
        }
        for (int i = colors.length - 1, position = k - 1; position >= 0; --position) {
            while (colors[position] < 0) {
                colors[position]++;
                colors[i--] = position + 1;
            }
        }
    }

/*******************************************************************/

    public void sortColors2(int[] colors, int k) {
        int low = 0;
        int high = colors.length - 1;
        for (int i = 1; i <= k / 2; ++i) {
            for (int j = low; j <= high; ++j) {
                if (colors[j] == i) {
                    swap(colors, j, low++);
                } else if (colors[j] == k - i + 1) {
                    swap(colors, j--, high--);
                }
            }
        }
    }

/*******************************************************************/

    public void sortColors2(int[] colors, int k) {
        quicksort(colors, 0, colors.length - 1);    
    }

    public void quicksort(int[] A, int low, int high) {
        if (low >= high) {
            return;
        } 
        int index = low;
        for (int i = low; i < high; ++i) {
            if (A[i] < A[high]) {
                swap(A, index++, i);
            }
        }
        swap(A, index, high);
        quicksort(A, low, index - 1);
        quicksort(A, index + 1, high);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

/*******************************************************************/

    public void sortColors2(int[] colors, int k) {
        int[] count = new int[k];
        for (int color : colors) {
            count[color - 1]++;
        }
        int color = 1;
        for (int i = 0; i < colors.length; ++i) {
            colors[i] = color;
            count[color - 1]--;
            while (color <= k && count[color - 1] == 0) {
                color++;
            }
        }
    }

}
