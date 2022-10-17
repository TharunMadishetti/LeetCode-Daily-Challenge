class Solution {
    public boolean checkIfPangram(String s) {
        if(s.length()<26)
            return false;
        int[] f=new int[26];
        for(int i=0;i<s.length();i++)
        f[s.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++)
        if(f[i]==0)
            return false;
        return true;
    }
}
