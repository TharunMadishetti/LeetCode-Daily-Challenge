class Solution {
    public String convertToTitle(int c) {
        String s=""; 
        while(c!=0) 
            {
       if(c%26==0) 
     { s="Z"+s;  c/=26; c-=1; continue;
     }
         if(c>0)
{ s=Character.toString('A'+c%26 -1)+s;
            c/=26;}
            
            }
        return s;
   
        
    }
}