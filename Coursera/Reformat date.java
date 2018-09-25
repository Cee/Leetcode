public class Solution {
	public String[] reformatDate(String[] dates) {
		if (dates == null || dates.length == 0) { return dates; }
		Map<String, Integer> months = new HashMap<>();
		months.put("Jan", 1); months.put("Feb", 2); months.put("Mar", 3);
		months.put("Apr", 4); months.put("May", 5); months.put("Jun", 6);
		months.put("Jul", 7); months.put("Aug", 8); months.put("Sep", 9);
		months.put("Oct", 10); months.put("Nov", 11); months.put("Dec", 12);
		String[] ans = new String[dates.length];
		for (int i = 0; i < dates.length; i++) {
			String date = dates[i];
			String[] parts = date.split(" ", -1);
			ans[i] = String.format("%s-%02d-%02d",
								   parts[2],
								   months.get(parts[1]),
								   Integer.valueOf(parts[0].substring(0, parts[0].length() - 2)));
		}
		return ans;
	}
}