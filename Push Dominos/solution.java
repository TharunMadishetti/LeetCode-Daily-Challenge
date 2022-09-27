class Solution {
    public String pushDominoes(String d) {
        if(d.length()==1)
            return d;
        char[] ch=new char[d.length()];
        int dot=0;
        int s=0,e;
    
        while(s<d.length() && d.charAt(s)=='.'){
            ch[s]='.';
            s++;
        }
        System.out.println(s);
        if(s<d.length())
        {
            if(d.charAt(s)=='L')
            {
                for(int j=s-1;j>=0;j--)
                ch[j]='L';
            }
        }
        else 
            return d;
        ch[s]=d.charAt(s);
        // System.out.println(Arrays.toString(ch));
        int i;
        for(i=s+1;i<d.length();i++)
        {
            if(d.charAt(i)=='.')
            ch[i]='.';
            else
            {
                int dots=(i-s-1);
                if(dots==1 && d.charAt(s)==d.charAt(i))
                    ch[i-1]=d.charAt(s);
                if(dots>1)
                {
                    if(ch[s]==d.charAt(i))
                    {
                        for(int m=s+1;m<i;m++)
                            ch[m]=ch[s];
                    }
                    else if(ch[s]=='R' && d.charAt(i)=='L')
                    {
                        int m;
                        for( m=s+1;m<=s+dots/2;m++)
                            ch[m]='R';
                        if(dots%2!=0)
                        {
                            ch[m]='.';
                            m++;
                        }
                        
                        while(m<i)
                            ch[m++]='L';
                    }
                    
                }
                s=i;
                ch[i]=d.charAt(i);
            }
            
        }
        int dots=(i-s-1);
        if(dots==1)
            ch[i-1]=(ch[i-2]=='R')?'R':'.';
        if(dots>1)
        {
            if(d.charAt(s)=='R')
            {
                int m=s+1;
                while(m<i)
                    ch[m++]='R';
            }

        }
        
       return new String(ch);
    }
}
