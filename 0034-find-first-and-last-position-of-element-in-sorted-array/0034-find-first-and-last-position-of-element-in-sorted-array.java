class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums,target,0);
        int last = lastOcc(nums,target,nums.length-1);
        return new int[]{first,last};
    }

    private int firstOcc(int arr[], int target, int i){
        int low = 0, high = arr.length-1;
        int frst = -1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid] == target){
                frst = mid;
                high = mid-1;
            }else if(target > arr[mid]){
                low=mid+1;
            }else{
                high = mid-1;
            }

        }
        return frst;
    }

  
    private int lastOcc(int arr[], int target, int i){
        int low = 0, high = arr.length-1;
        int lst = -1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(arr[mid] == target){
                lst = mid;
                low  = mid+1;
            }else if(target > arr[mid]){
                low=mid+1;
            }else{
                high = mid-1;
            }

        }
        return lst;
    }
}