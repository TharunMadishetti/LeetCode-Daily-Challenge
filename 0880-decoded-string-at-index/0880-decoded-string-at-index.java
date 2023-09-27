class Solution {
    public String decodeAtIndex(String str, int k) {
        char[] s=str.toCharArray();
        long sz=0;
        for(int i=0;i<s.length;i++)
        {
            if(s[i]<='9')
                sz*=s[i]-'0';
            else
                sz++;
        }
        // System.out.println(sz);
        for(int i=s.length-1;i>=0;i--)
        {
            k%=sz;
            if(k==0 && s[i]>'9')
                return s[i]+"";
            if(s[i]<='9')
                sz/=s[i]-'0';
            else
                sz--;
        }
        return "";
    }
}