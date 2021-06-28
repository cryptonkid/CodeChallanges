import java.util.HashMap;

public class MaxTime {

	public static String largestTimeFromDigitsI(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			if (map.containsKey(A[i])) {
				int count = map.get(A[i]);
				map.put(A[i], map.get(A[i]) + 1);
				continue;
			}
			map.put(A[i], 1);
		}
		boolean flag = false;
		String time = "";
		// setting first digit //hours
		for (int i = 2; i >= 0; i--) {
			if (isDigitPresent(map, i)) {
				flag = true;
				time = time + i;
				break;
			}
		}
		if (!flag) {
			return "";
		}
		flag = false;
		// Second digit
		if (time.charAt(0) == '2') {
			for (int i = 3; i >= 0; i--) {
				if (isDigitPresent(map, i)) {
					flag = true;
					time = time + i;
					break;
				}
			}
		} else {// for 1-0 in hours place
			for (int i = 9; i >= 0; i--) {
				if (isDigitPresent(map, i)) {
					flag = true;
					time = time + i;
					break;
				}
			}
		}

		if (!flag) {
			return "";
		}

		time = time + ":";
		flag = false;
		for (int i = 5; i >= 0; i--) {
			if (isDigitPresent(map, i)) {
				flag = true;
				time = time + i;
				break;
			}
		}
		if (!flag) {
			return "";
		}
		for (int i = 9; i >= 0; i--) {
			if (isDigitPresent(map, i)) {
				flag = true;
				time = time + i;
				break;
			}
		}
		if (!flag) {
			return "";
		}

		return time;
	}

	private static boolean isDigitPresent(HashMap<Integer, Integer> map, int i) {
		if (map.containsKey(i) && (map.get(i) > 0)) {
			map.put(i, map.get(i) - 1);
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(largestTimeFromDigits(new int[]{1,2,3,4}));
		// System.out.println(largestTimeFromDigits(new int[]{5,5,5,5}));
		System.out.println(largestTimeFromDigitsI(new int[] { 0, 0, 0, 0 })); // o/p : 00:00
		System.out.println(largestTimeFromDigitsI(new int[] { 4, 2, 4, 4 })); // o/p : "" not "2:44" this comes when you
																				// dont make flag to false.
		System.out.println(largestTimeFromDigitsI(new int[] { 2, 0, 6, 6 }));// o/p : 06:26
	}

	// Accepted solution.
	public String largestTimeFromDigits(int[] A) {
		String maxTime = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (i == j || j == k || k == i)
						continue; // remove reusing the same values.
					String hours = A[i] + "" + A[j];// by adding "" we convert it into string
					// Important trick : here 6 repesents the maximum value while iterating
					String min = A[k] + "" + A[6 - i - j - k];

					if (hours.compareTo("24") < 0 && min.compareTo("60") < 0) {
						String currentTime = hours + ":" + min;
						if (maxTime.compareTo(currentTime) < 0) {
							maxTime = currentTime;
						}
					}

				}
			}
		}
		return maxTime;
	}
}
