package solutions;

public class Q8_MyAtoi {

	//Too many cases; usually indicates it does not work
	public static int myAtoi(String str) {
		int len = str.length();
		int sign = 1;
		int result = 0;

		boolean overflow = false;

		if (len == 0) return 0;

		int start = 0;
		int end = len-1;

		while (str.charAt(start) == 32) {
			start++;
		}

		while (str.charAt(end) == 32) {
			end--;
		}

		if (str.charAt(start) == '-') {
			sign = -1;
		}

		for (int i = start; i <= end; i++) {
			if (i == start && (str.charAt(start) == '-'  || str.charAt(start) == '+')) continue;

			switch (str.charAt(i)) {
			case 48 : 
				result += 0; 
				break;
			case 49 : 
				result += Math.pow(10, end - i); 
				break;
			case 50 : 
				result += 2 * Math.pow(10, end - i);
				break;
			case 51 : 
				result += 3 * Math.pow(10, end - i);
				break;
			case 52 : 
				result += 4 * Math.pow(10, end - i);
				break;
			case 53 :
				result += 5 * Math.pow(10, end - i);
				break;
			case 54 : 
				result += 6 * Math.pow(10, end - i);
				break;
			case 55 :
				result += 7 * Math.pow(10, end - i);
				break;
			case 56 : 
				result += 8 * Math.pow(10, end - i);
				break;
			case 57 : 
				result += 9 * Math.pow(10, end - i);
				break;
			default :
				result /= Math.pow(10, end - i + 1);
				i = end+1;
				break;
			}

			if (result == 2147483647) {
				if (i != end) {
					overflow = true;
				} else if (str.charAt(end) != '7') {
					overflow = true;
				}
				break;
			}

		}

		result *= sign;

		if (result == -2147483647 && overflow) {
			result--;
		}

		return result;
	}

	//The idea is very cool: whenever there is a valid digit, add itself to 10 * previous number 
	public static int myAtoi2(String str) {
		int len = str.length();
		int sign = 1;
		long base = 0;
		int index = 0;
		
		
		while (str.charAt(index) == ' ' ) { //32 for ‘ ‘
			index++;
		}

		if (str.charAt(index) == '-' || str.charAt(index) == '+') {
			sign = str.charAt(index++) == '-' ? -1 : 1;
		}

		while (index < len && str.charAt(index) <= '9' && str.charAt(index) >= '0') {
			base = base * 10 + str.charAt(index++) - '0';
			if (base >= Integer.MAX_VALUE) {
				if (sign == 1) return Integer.MAX_VALUE;
				if (sign == -1 && base != Integer.MAX_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
		}

		return sign * (int) base;


	}

	public static void main(String[] args) {
		System.out.println(myAtoi2("-2141117483649"));

	}

}
