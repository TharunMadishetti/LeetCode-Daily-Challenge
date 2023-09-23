class Solution {
    HashMap<String,List<String>>adj;
    HashMap<String,Integer>cnt;
    public int longestStrChain(String[] words) {
        int n = words.length;

        int ans = -1;
        adj = new HashMap<>();
        cnt = new HashMap<>();
        for(int i = 0; i < words.length;i++){
            if(!adj.containsKey(words[i]))
                adj.put(words[i],new ArrayList<>());
            for(int j = 0; j < words.length;j++){
                if(words[j].equals(words[i])) continue;
                if(check(words[i],words[j])){
                    adj.get(words[i]).add(words[j]);
                }
            }
            if(cnt.containsKey(words[i])) continue;
            cnt.put(words[i],1);
        }


        for(String s : words){
            HashSet<String> visited = new HashSet<>();
          ans = Math.max(dfs(s,adj.get(s),cnt,visited),ans);
        }


        return ans;
    }
      public int dfs(String s,List<String>a,HashMap<String,Integer>cnt,HashSet<String>visited){
         int count = 1;
        visited.add(s);
        for(String v : adj.get(s)){
            if(!visited.contains(v)){
               dfs(v,adj.get(v),cnt,visited);

            }
            int t = cnt.get(s);
            t=Math.max(cnt.get(s),1+cnt.get(v));
            cnt.put(s,t);
            count = t;
            
        }
        return count;


    }
     public boolean check(String a, String b){
        if(b.length() - a.length()!=1)
            return false;
        int[]cntA = new int[26];
        int[]cntB = new int[26];
        for(char c : b.toCharArray()){
            cntB[c-'a']++;
        }
        for(char c : a.toCharArray()){
            cntA[c-'a']++;
        }
        char f = ' ';
        for(int i = 0; i < 26;i++){
            if( cntB[i]-cntA[i]>1){
                return false;
            }
            else if (cntB[i]-cntA[i]==1){
                f =(char) (i+(int)'a');
                break;
            }

        }
        List<Integer>index = new ArrayList<>();
        for(int i = 0; i < b.length();i++){
            if(b.charAt(i)==f)index.add(i);
        }
        for(int i = 0; i < index.size();i++){
            StringBuilder temp = new StringBuilder(b);
            temp.deleteCharAt(index.get(i));
            if(temp.toString().equals(a))
                return true;
        }

        return false;

    }
}