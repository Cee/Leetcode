class Solution {
    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isBlock = false;
        for (String s: source) {
            for (int i = 0; i < s.length(); i++) {
                if (isBlock) {
                    if (s.charAt(i) == '*' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                        isBlock = false;
                        i += 1;
                    }
                } else {
                    if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                        break;
                    } else if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                        isBlock = true;
                        i += 1;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!isBlock && sb.length() > 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return list;
    }
}