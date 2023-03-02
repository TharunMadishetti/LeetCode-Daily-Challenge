class Solution {
    public int compress(char[] chars) {
        int i=0,j=0;
        while(i<chars.length){
            char ch=chars[i];
            int c=0;
            while(i<chars.length && chars[i]==ch){
                i++;
                c++;
            }
            if(j<chars.length)
            chars[j++]=ch;
            if(c/10==0){
                if(c%10>1){
                if(j<chars.length)
                chars[j++]=(char)(c%10+'0');
                }
                continue;
            }
            String count=""+c;
            int k=0;
            while(k<count.length()){
                if(j<chars.length)
                chars[j++]=count.charAt(k++);
            }

        }
        return j;

    }
}
