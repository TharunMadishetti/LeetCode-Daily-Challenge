class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int len =s.length();
        for(int i=len/2;i>0;i--)
        {
            if(len%i==0)
            {
                String str=s.substring(0,i);
                //int c=str.length();
                while(str.length()<s.length())
                    str+=s.substring(0,i);
                if(str.equals(s))
                    return true;
            }
        }
        return false;
        
    }
    
}