class Solution {
    public String reverseWords(String s) {
     int i=s.length()-1;
     String rev="";
     while(i>=0)
    {
         
      String w="";
      while(i>=0 && s.charAt(i)!=' ')
          w+=s.charAt(i--);
      
     if(rev.length()>0)
     rev=w+" "+rev;
     else 
     rev=w;
     i--;
    }
        return rev;
}
}