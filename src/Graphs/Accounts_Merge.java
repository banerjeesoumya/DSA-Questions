package Graphs;

import java.util.*;

public class Accounts_Merge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        // Call the merge function and print the result
        List<List<String>> mergedAccounts = accountsMerge(accounts);
        System.out.println("Merged Accounts:");
        for (List<String> account : mergedAccounts) {
            System.out.println(account);
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < accounts.get(i).size(); j ++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }
        ArrayList<String>[] merged = new ArrayList[n];
        for (int i = 0; i < n; i ++) {
            merged[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findParent(entry.getValue());
            merged[node].add(mail);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (merged[i].isEmpty()) {
                continue;
            }
            Collections.sort(merged[i]);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for (String mail : merged[i]) {
                list.add(mail);
            }
            result.add(list);
        }
        return result;
    }
}
