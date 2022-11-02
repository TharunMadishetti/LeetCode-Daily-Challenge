//Problem link : https://leetcode.com/problems/minimum-genetic-mutation/
import java.util.*;
import java.io.*;

class Node {
    String val;
    ArrayList<Node> n;

    public Node(String w) {
        val = w;
        n = new ArrayList<>();
    }

    public String toString() {
        String res = "(" + val;
        for (Node k : n)
            res += " " + k.val + " ";
        return res + ")";
    }
}

public class GeneMutation {
    public static void main(String[] args) throws IOException {
        GeneMutation g = new GeneMutation();
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String str = b.readLine();
        String[] bank = b.readLine().split(" ");
        String end = b.readLine();
        System.out.println((g.solve(str, end, bank)));

    }

    public int solve2(Node s, Node e) {
        HashSet<String> vis = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(s);
        vis.add(s.val);
        int c = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                // System.out.println(q);
                Node pre = q.poll();
                if (pre.val.equals(e.val))
                    return c;
                for (Node k : pre.n) {
                    if (vis.contains(k.val))
                        continue;
                    else {
                        vis.add(k.val);
                        q.add(k);
                    }
                }

            }
            c++;
        }
        return -1;
    }

    public int solve(String s, String e, String[] b) {
        Node start = new Node(s);
        Node end = new Node(e);
        if (diff(start.val, end.val) == 1)
            return 1;
        Node[] bank = new Node[b.length];
        for (int i = 0; i < b.length; i++)
            bank[i] = new Node(b[i]);
        for (int i = 0; i < b.length; i++) {
            if (diff(bank[i].val, start.val) == 1) {
                bank[i].n.add(start);
                start.n.add(bank[i]);
            }
            if (diff(bank[i].val, end.val) == 1) {
                bank[i].n.add(end);
                end.n.add(bank[i]);
            }
        }
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b.length; j++) {
                if (i == j)
                    continue;

                if (diff(bank[i].val, bank[j].val) == 1) {
                    bank[i].n.add(bank[j]);
                    bank[j].n.add(bank[i]);
                }
            }
        // System.out.println(start + " " + end);
        return solve2(start, end);
    }

    public int diff(String s, String s2) {
        int err = 0;
        if (s.length() != s2.length())
            return -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s2.charAt(i))
                err++;
        }
        return err;
    }
}
