package Day15;

public class numberofoccurence {
    public static void main(String[] args) {
        int[] arr={1, 1, 1, 2, 2, 3, 3};
        int n=arr.length;
        int x=3;
        System.out.println(count(arr,n,x));
    }
    public static int count(int arr[], int n, int x) {
        //Your code goes here
        // int count=0;
        // for(int i=0;i<n;i++){
        //     if(arr[i]==x){
        //         count++;
        //     }
        // }
        // return count;

        int[] ans = firstAndLastPosition(arr, n, x);
        if (ans[0] == -1) return 0;
        return (ans[1] - ans[0] + 1);
    }
    //Your code goes here
    // int count=0;
    // for(int i=0;i<n;i++){
    //     if(arr[i]==x){
    //         count++;
    //     }
    // }
    // return count;

    public static int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                first = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                last = mid;
                // look for larger index on the right
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return last;
    }

    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);
        if (first == -1) return new int[] { -1, -1};
        int last = lastOccurrence(arr, n, k);
        return new int[] {first, last};
    }
}
