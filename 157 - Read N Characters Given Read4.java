/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        char[] temp = new char[4];
        while (true) {
            int size = read4(temp);
            if (size == 0) { break; }
            int i = 0;
            while (count < n && i < size) {
                buf[count] = temp[i];
                count++;
                i++;
            }
            if (count == n) { break; }
        }
        return count;
    }
}