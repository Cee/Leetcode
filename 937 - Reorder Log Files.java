class Solution {
    class Log {
        String id;
        String log;
        Log(String id, String log) {
            this.id = id;
            this.log = log;
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) { return logs; }
        String[] ans = new String[logs.length];
        ArrayList<Log> letters = new ArrayList<>();
        ArrayList<String> digits = new ArrayList<>();
        for (String log: logs) {
            int space = log.indexOf(" ");
            String id = log.substring(0, space);
            String l = log.substring(space + 1);
            if (l.charAt(0) >= '0' && l.charAt(0) <= '9') {
                digits.add(log);
            } else {
                letters.add(new Log(id, l));
            }
        }
        Collections.sort(letters, (a, b) -> {
            //remove toLowerCase if you want to disable case insensitivity
            int r= a.log.toLowerCase().compareTo(b.log.toLowerCase());
            if(r==0) {
                return a.id.compareTo(b.id);
            }
            return r;
        });
        int i = 0;
        for (Log l: letters) {
            ans[i++] = l.id + " " + l.log;
        }
        for (String s: digits) {
            ans[i++] = s;
        }
        return ans;
    }
}
