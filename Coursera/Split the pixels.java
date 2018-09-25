public class Main {
    class Color {
        int r;
        int g;
        int b;
        Color(String s) {
            r = Integer.valueOf(s.substring(0, 8), 2);
            g = Integer.valueOf(s.substring(8, 16), 2);
            b = Integer.valueOf(s.substring(16, 24), 2);
            // System.out.println(r + " " + g + " " + b);
        }
        Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
            // System.out.println(r + " " + g + " " + b);
        }
        long distance(Color that) {
            long ans = 0;
            ans += Math.pow(this.r - that.r, 2);
            ans += Math.pow(this.g - that.g, 2);
            ans += Math.pow(this.b - that.b, 2);
            return ans;
        }
    }
    public List<String> splitThePixels(List<String> pixels) {
        List<String> ans = new ArrayList<>();
        if (pixels == null || pixels.size() == 0) { return ans; }
        List<Color> base = new ArrayList<>();
        base.add(new Color(0, 0, 0));
        base.add(new Color(255, 255, 255));
        base.add(new Color(255, 0, 0));
        base.add(new Color(0, 255, 0));
        base.add(new Color(0, 0, 255));
        String[] colors = new String[]{"Black", "White", "Red", "Green", "Blue"};
        for (String pixel: pixels) {
            Color c = new Color(pixel);
            long min = Long.MAX_VALUE;
            String s = "";
            for (int i = 0; i < colors.length; i++) {
                long dis = c.distance(base.get(i));
                if (dis == min) {
                    s = "Ambiguous";
                    break;
                } else if (dis < min) {
                    min = dis;
                    s = colors[i];
                }
            }
            ans.add(s);
        }
        for (String s: ans) {
            System.out.println(s);
        }
        return ans;
    }
    public static void main(String[] args) {
        Main m = new Main();
        List<String> pixels = new ArrayList<>();
        pixels.add("101111010110011011100100");
        pixels.add("110000010101011111101111");
        pixels.add("100110101100111111101101");
        pixels.add("010111011010010110000011");
        pixels.add("000000001111111111111111");
        m.splitThePixels(pixels);
    }
}