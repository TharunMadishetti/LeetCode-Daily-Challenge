class Solution {
    public int compress(char[] chars) {
        int i=0,j=0;        //i pointer for counting occurences
                            //j pointer for holding the index to be filled 
        while(i<chars.length){
            char ch=chars[i];
            int c=0;
            while(i<chars.length && chars[i]==ch){
                i++;
                c++;
            }
            if(j<chars.length)
            chars[j++]=ch;
            if(c/10==0){        //if the frequency is one digit
                if(c%10>1){             //ignore if the frequency is only one
                chars[j++]=(char)(c%10+'0');
                }
                continue;   
            }
            //if the frequency is more than one digit 
            String count=""+c;      
            
            int k=0;        //appending digit by digit
            while(k<count.length()){
                if(j<chars.length)
                chars[j++]=count.charAt(k++);
            }

        }
        return j;

    }
}
