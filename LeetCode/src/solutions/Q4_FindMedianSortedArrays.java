package solutions;

public class Q4_FindMedianSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int count = 0;
		int m = 0, n = 0; //indices of nums1 and nums2

		int[] newArray = new int[nums1.length + nums2.length]; //merged array
		int medianPos; 

		medianPos = (nums1.length + nums2.length) / 2;

		while (count <= medianPos) {
			if (m < nums1.length && nums1[m] < nums2[n]) {
				newArray[count] = nums1[m];
				m++;
			} else {
				newArray[count] = nums2[n];
				n++;
			}
			count++;
		}

		if ((nums1.length + nums2.length) % 2 == 1) {
			return newArray[medianPos];
		} else {
			return (double) (newArray[medianPos] + newArray[medianPos-1]) / 2;
		}
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {5,6,7,10, 10};
		System.out.println(findMedianSortedArrays(arr1, arr2));
	}

}
