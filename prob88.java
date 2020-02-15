// S30 Big N Problem #88 {Medium}
// 275. H-Index II
// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None


// Your code here along with comments explaining your approach
class Solution {
    
    //O(n) solution
    public int hIndex2(int[] citations) {
        int n=citations.length;
        int diff=0;
        for(int i=0;i<n;i++){
            diff=n-i;
            if(citations[i]>=n-i){
                return diff;
            }
        }
        return 0;
    }
    
    //O(log n) solution
    public int hIndex(int[] citations) {
        int n=citations.length;
        return binarySearch(citations,0,n-1,n);
    }
    
    private int binarySearch(int[] citations, int low, int high, int length){
        int diff=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            diff=length-mid;
            if(citations[mid]==diff){
                return diff;
            }else if(citations[mid]<diff){
                low=mid+1;
            }else{
                //citations[mid]>diff
                // mid qualified but need to search further
                high=mid-1;
            }
        }
        return length-low;
    }
    
}