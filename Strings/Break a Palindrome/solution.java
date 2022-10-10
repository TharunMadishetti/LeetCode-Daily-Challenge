class Solution {
    public String breakPalindrome(String p) {
        if(p.length()==1)
            return "";
        for(int i=0;i<p.length();i++)
        {
            int j=p.length()-i-1;
            if(i==j)
                continue;
            if(p.charAt(i)!='a')
            {
                char ch[] = p.toCharArray();
                ch[i]='a';
                return new String(ch);
            }
                
        }
         char ch[] = p.toCharArray();
        ch[ch.length-1]='b';
        
        return new String(ch);
        
    }
}
