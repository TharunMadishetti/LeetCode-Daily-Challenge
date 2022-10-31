//Problem link :https://leetcode.com/problems/toeplitz-matrix/
while(j<m[0].length)
        {
            int x=m[0][j];
            int k=0,l=j;
        while(k<m.length && l<m[0].length)
        {
            if(m[k++][l++]!=x)
                return false;
        }
            j++;
        }
