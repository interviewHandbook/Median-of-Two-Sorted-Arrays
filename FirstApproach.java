package com.interviewprep.leetcode.hard.medianoftwosortedarrays;

import java.util.Arrays;
import java.util.Collections;

public class FirstApproach {

	
	public static void main(String[] args) {
		
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		
		FirstApproach fa = new FirstApproach();
		double med = fa.findMedianSortedArrays(nums1, nums2);
		
		
		System.out.println(med);
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double med = 0;

		// declare a third array
		int[] nums3 = new int[nums1.length + nums2.length];

		// add elements from first given array
		for(int i=0; i<nums1.length; i++) {

			nums3[i] = nums1[i];
		}

		// add elements from second given array
		int idx = nums1.length;
		for(int i=0; i<nums2.length; i++) {

			nums3[idx] = nums2[i];
			idx++;
		}

		// Sort the arrays
		Arrays.sort(nums3);
		
		// can use the below call also for sort
		//Arrays.parallelSort(nums3);
		
		int len3 = nums3.length;

		// if array length is even
		if(len3 == 0) {

			med = 0;
		}
		else {
			if(len3 % 2 == 0) {

				int n1 = nums3[len3/2 - 1];
				int n2 = nums3[len3/2] ;

				med =  (double)( n1 + n2  ) / 2 ;
			}
		}


		// if array length is odd
		if(len3 % 2 != 0) {

			if(len3 == 1 ) {

				med = nums3[0];
			}
			else {

				med = nums3[len3 / 2 ];
			}
		}

		return med;
	}

}
