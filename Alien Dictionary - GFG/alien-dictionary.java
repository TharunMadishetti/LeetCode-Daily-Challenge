//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] d, int N, int K)
    {
        // Write your code here
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<K;i++)
        g.add(new ArrayList<>());
        
        for(int i=0;i<d.length-1;i++)
        {
            for(int j=0;j<Math.min(d[i].length(),d[i+1].length());j++)
            {
                if(d[i].charAt(j)!=d[i+1].charAt(j))
                {
                    g.get(d[i+1].charAt(j)-'a').add(d[i].charAt(j)-'a');
                    break;
                }
                
            }
        }
        // System.out.println(g);
        int[] in=new int[K];
        for(int i=0;i<g.size();i++)
        {
            for(int x:g.get(i))
            in[x]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int k=0;k<K;k++)
        if(in[k]==0)q.add(k);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty())
        {
            int x = q.poll();
            sb.append((char)(x+'a'));
            for(int j:g.get(x))
            {
                in[j]--;
                if(in[j]==0)
                q.add(j);
            }
        }
    //   System.out.println(ans);
        return sb.reverse().toString();
    }
}