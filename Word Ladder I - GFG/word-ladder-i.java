//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String start, String target, String[] w)
    {
        // Code here
        HashMap<String,ArrayList<String>> g=new HashMap<>();
        for(int i=0;i<w.length;i++)
        g.put(w[i],new ArrayList<>());
        for(int i=0;i<w.length;i++)
        {
            for(int j=i+1;j<w.length;j++)
            {
                int c=0;
                for(int k=0;k<w[i].length();k++)
                if(w[i].charAt(k)!=w[j].charAt(k))
                c++;
                if(c==1)
                {
                    g.get(w[i]).add(w[j]);
                    g.get(w[j]).add(w[i]);
                }
            }
        }
        
        HashSet<String> vis=new HashSet<>();
        vis.add(start);
        Queue<String> q1=new LinkedList<>();
        for(int i=0;i<w.length;i++)
        {
             int c=0;
            for(int k=0;k<w[i].length();k++)
            if(w[i].charAt(k)!=start.charAt(k))
            c++;
            if(c==1)
            {
                q1.add(w[i]);
                vis.add(w[i]);
            }
        }
        int ans=2;
        // System.out.println(g+" "+ans);
        while(!q1.isEmpty())
        {
            int l=q1.size();
            for(int i=0;i<l;i++)
            {
                String curr=q1.poll();
                if(curr.equals(target))
                return ans;
                
                for(String str:g.get(curr))
                {
                    if(!vis.contains(str) )
                    {
                        vis.add(str);
                        q1.add(str);
                    }
                }
                
                
            }
            ans++;
        }        

        return 0;
    }
}