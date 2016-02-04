package solutions;

public class Q7_ReverseInt {
	public static int reverse(int x) {
		String val = Integer.toString(Math.abs(x));
		StringBuilder result = new StringBuilder(val.length());

		for (int i = val.length() - 1; i >= 0; i--) {
			result.append(val.charAt(i));
		}

		try {
			if (x<0) {
				return Integer.parseInt(result.insert(0, '-').toString());
			} else {
				return Integer.parseInt(result.toString());
			}
		} catch (Exception e) {
			return 0;
		}

	}

	public static void main(String[] args) {
		System.out.println(reverse(100003));

	}
}
