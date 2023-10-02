class Solution {
    public boolean winnerOfGame(String c) {
        int a=0,b=0;
        int i=0;
        char[] s=c.toCharArray();
        while(i<s.length)
        {
            char ch=s[i++];
            int f=1;
            while(i<s.length && ch==s[i])
            {
                f++;
                i++;
            }
            if(f>=3)
                if(ch=='A')
                    a+=f-2;
                else
                    b+=f-2;
        // System.out.println(a+" "+b+" "+i+" "+ch);
        }
        
        return a>b;
    }
}