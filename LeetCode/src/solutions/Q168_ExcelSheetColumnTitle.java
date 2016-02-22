package solutions;

public class Q168_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        int digit = 0;
        while (n > 26) {
        	digit = n % 26; 
        	n = n / 26;
            result.insert(0, (char) (digit + '@'));
        }
        result.insert(0, (char) (n +'@'));
        return result.toString();
    }
	
	
	public static void main(String[] args) {
		Q168_ExcelSheetColumnTitle q = new Q168_ExcelSheetColumnTitle();
		System.out.println(q.convertToTitle(78));

	}

}
