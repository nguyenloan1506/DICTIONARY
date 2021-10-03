public class Tries {
    //public static Tries[] trie;
    private int[] child = new int[26];
    private int cnt;
    private String result;
    private static int demChild;

    static Tries[] trie = new Tries[1000005];

    /**
     * Them tu vao cay.
     */
    public static void add(String S) {
        int root = 0;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            int x = (int)(S.charAt(i) - 'a');
            if (trie[root].child[x] == 0) {
                trie[root].child[x] = ++demChild;
            }
            root = trie[root].child[x];
            trie[root].cnt++;
        }
        trie[root].result = S;
    }

    /**
     * Truy vet tu co chung tien to.
     */
    public static void dfs(int root) {
        if (trie[root].result != "") {
            System.out.println(trie[root].result);
        }
        for (int x = 0; x <= 25; x++) {
            if (trie[root].child[x] != 0) {
                dfs(trie[root].child[x]);
            }
        }
    }

    /**
     * dem va truy vet tu chung tien to S.
     */
    public static int query(String S) {
        int root = 0;
        int n = S.length();
        for (int i = 0; i < n; i++) {
            int x = (int)(S.charAt(i) - 'a');
            if (trie[root].child[x] == 0) return 0;
            root = trie[root].child[x];
        }
        dfs(root);
        return trie[root].cnt;
    }

    public static void dictionarySearcher() {
        for (int i = 0; i <= Dictionary.word.size(); i++) {
            add(Dictionary.word.get(i).getWord_target());
        }
        System.out.println(query("trans"));
    }
}
