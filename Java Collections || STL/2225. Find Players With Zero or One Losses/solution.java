// Problem link: https://leetcode.com/problems/find-players-with-zero-or-one-losses/

class Solution {
    public List<List<Integer>> findWinners(int[][] m) {
        int[] l = new int[100001];
        Arrays.fill(l,-1);
        for(int i=0;i<m.length;i++)
        {
            if(l[m[i][0]]==-1)
                l[m[i][0]]++;
            if(l[m[i][1]]==-1)
                l[m[i][1]]++;
            l[m[i][1]]++;
        }
        List<List<Integer>> ll = new ArrayList<>();
        ll.add(new ArrayList<>());
        ll.add(new ArrayList<>());
        for(int i=0;i<l.length;i++)
        {
            if(l[i]==0)
                ll.get(0).add(i);
            if(l[i]==1)
                ll.get(1).add(i);
        }
        return ll;
    }
}
