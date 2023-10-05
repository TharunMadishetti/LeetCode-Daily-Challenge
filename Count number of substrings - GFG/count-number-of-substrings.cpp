//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution
{
  public:
    long long int substrCount (string S, int K) {
    	//code here.
    	 vector<int> f(26,0);
        int j=0,i=0,curr=0;
        long long ans=0;
        while(i<S.size())
        {
            if(f[S[i]-'a']==0)
            curr++;
            f[S[i]-'a']++;
            while(curr>K)
            {
                f[S[j]-'a']--;
                if(f[S[j]-'a']==0)
                curr--;
                j++;
            }
            ans+=i-j+1;
            i++;
        }
       curr=0;
        K--;
        i=0;
        j=0;
         f=vector<int>(26,0);
        long long ans2=0;
        while(i<S.size())
        {
            if(f[S[i]-'a']==0)
            curr++;
            f[S[i]-'a']++;
            while(curr>K)
            {
                f[S[j]-'a']--;
                if(f[S[j]-'a']==0)
                curr--;
                j++;
            }
            // System.out.println(i+" "+j);
            ans2+=i-j+1;
            i++;
        }
        return ans-ans2;
    }
};

//{ Driver Code Starts.


int main()
{
    int t; cin >> t;
    while (t--)
	{
		string s; cin >> s;
		int k; cin >> k;
		Solution ob;
		cout <<ob.substrCount (s, k) << endl;
	}
}
// } Driver Code Ends