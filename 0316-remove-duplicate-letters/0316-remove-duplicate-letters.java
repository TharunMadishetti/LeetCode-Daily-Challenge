class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st=new Stack<>();
        int[] f=new int[26];
        int[] fl=new int[26];
        for(int i=0;i<s.length();i++)
            f[s.charAt(i)-'a']++;
        int i=0;
        while(i<s.length())
        {
            char ch=s.charAt(i);
            f[ch-'a']--;
            if(fl[ch-'a']==1)
            {
                i++;
                continue;
            }
            // System.out.println(st);
            while(!st.isEmpty() && ch<=st.peek() && f[st.peek()-'a']>0)
                fl[st.pop()-'a']=0;
            if(fl[ch-'a']==0)
            {
                st.push(ch);
                fl[ch-'a']=1;
            }
            i++;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}