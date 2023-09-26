//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.checkRedundancy(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int checkRedundancy(String str) {
        // code here
        char[] s=str.toCharArray();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length;i++)
        {
            if(s[i]=='(' || s[i]=='+' || s[i]=='*' || s[i]=='-' || s[i]=='/')
            st.push(s[i]);
            else if(s[i]==')')
            {
                if(!st.isEmpty() && st.peek()=='(')
                return 1;
                while(!st.isEmpty() && st.peek()!='(')
                {
                    st.pop();
                }
                if(!st.isEmpty())
                st.pop();
            }
        }
        return 0;
        
    }
}
        
