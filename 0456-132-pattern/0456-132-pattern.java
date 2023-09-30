class Solution {
    public boolean find132pattern(int[] nums) {
         int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < mins.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        Stack<Integer> s = new Stack<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            if (x == mins[i]) continue;
            while (!s.isEmpty() && s.peek() <= mins[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                int y = s.peek();
                if (mins[i] < y && y < x) {
                    return true;
                }
            }
            s.push(x);
        }

        return false;
    }
}