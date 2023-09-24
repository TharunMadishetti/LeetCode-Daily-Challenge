//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> li = new ArrayList<Integer>();
        int[] a = new int[n];
        Arrays.fill(a,0);
        for(int i=0;i<n;i++)
        {
            a[arr[i]]++;
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]>1)
            li.add(i);
        }
        if(li.size()==0)
        li.add(-1);
        return li;
    }
}
