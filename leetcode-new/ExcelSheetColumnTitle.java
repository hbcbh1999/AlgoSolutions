/*
Given a positive integer, return its corresponding column title as appear in an 
Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        long exp = 1;
        String result = "";
        while (n > 0) {
            int remainder = (n - 1) % (26 * exp) + 1;
            result = (char) (remainder / exp + 64) + result;
            exp *= 26;
            n -= remainder;
        }
        return result;
    }

}
