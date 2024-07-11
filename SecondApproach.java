package com.interviewprep.leetcode.hard.medianoftwosortedarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class SecondApproach {

	public static void main(String[] args) {
		
		int[] nums1 =  {2,2,4,4};
		int[] nums2 = {2,2,4,4};
		
		ThirdApproach ta = new ThirdApproach();
		double med = ta.findMedianSortedArrays(nums1, nums2);
		
		System.out.println(med);
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double med = 0;

		int i = 0;
		int j = 0;
		int k = 0;

		int m = nums1.length;
		int n = nums2.length;
		
		// declare third array - this will contain the merged sorted array 
		int[] nums3 = new int[m+n];
		
		// merge the given two sorted arrays into the third array
		while(i < m  &&  j < n){

			if (nums1[i] < nums2[j]) {
				
				nums3[k++] = nums1[i++];
			} 
			else {
				
				nums3[k++] = nums2[j++];
			}
		}
		
		/* append any integers that are left */
		
		while (i < m) {
			nums3[k++] = nums1[i++];
		}

		while (j < n) {
			nums3[k++] = nums2[j++];
		}
		
		/* now find the median of third array below */
		
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
