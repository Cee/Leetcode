/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    boolean eof = false;
    int i = 0;
    int size = 0;
    char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int count = 0;
        while (true) {
            if (eof) { break; }
            while (count < n && i < size) {
                buf[count] = temp[i];
                count++;
                i++;
            }
            if (count == n) { break; }
            size = read4(temp);
            i = 0;
            if (size == 0) {
                eof = true;
                break;
            }
        }
        return count;
    }
}