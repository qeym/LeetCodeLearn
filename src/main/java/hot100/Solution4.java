package hot100;

public class Solution4 {
    public static void main(String[] args) {
        int[] input1 = new int[]{1,3};
        int[] input2 = new int[]{2};
        double medianSortedArrays = new Solution4().findMedianSortedArrays(input1, input2);
        System.out.println(medianSortedArrays);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        return (handle(nums1, nums2, 0, 0 ,( len1+len2+1 )/2) +
                handle(nums1, nums2, 0, 0, ( len1+len2+2 )/2)) * 0.5;
    }

    public int handle(int[] nums1, int[] nums2, int start1, int start2, int k){
        int step = k == 1 ? 1 : k/2;

        if(nums1.length == 0 || start1 == nums1.length){
            return nums2[start2 + k - 1];
        }
        if(nums2.length == 0 || start2 == nums2.length){
            return nums1[start1 + k - 1];
        }

        int index1 = Math.min(step + start1 - 1, nums1.length - 1);
        int index2 = Math.min(step + start2 - 1, nums2.length - 1);

        if(nums1[index1] < nums2[index2]){
            if(k==1){
                return nums1[index1];
            }
            k = k - ( index1 - start1 + 1);
            return handle(nums1, nums2, index1 + 1, start2, k);
        }else{
            if(k == 1){
                return nums2[index2];
            }
            k = k - ( index2 - start2 + 1);
            return handle(nums1, nums2, start1, index2 + 1, k);
        }
    }
}
