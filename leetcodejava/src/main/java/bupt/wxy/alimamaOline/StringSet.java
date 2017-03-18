package main.java.bupt.wxy.alimamaOline;


import java.util.*;

/**
 * Created by xiyuanbupt on 3/17/17.
 需要解决问题:
 1. 有一个字符串的集合 string_set , 判断给定字符串 str 是否是字符串集合中某个字符串的前缀
    exa. string_set = set("abcd", "efg", "ehg", "ijk") str = "ab", 那么它是字符串"abcd"的前缀.
    答: 创建字典树, 并使用字典树执行前缀查找
 2. 判断给定字符串 string 是否是字符串集合中某个字符串的子串
    exa. string_set = set("abcd", "efg", "ehg", "ijk") str = "bc", 那么集合中存在字符串"abcd" 满足条件
    答: 集合中的字符串的子串创建索引
 3. 优化上述查询过程
    答:
 */

// 接口定义
interface StringSearchAble {

    /**
     * 从一个字符串的集合构建字符串查找树
     * @param strs
     */
    public void buildFromStrSet(Set<String> strs);

    /**
     * 判断给定前缀是否在字符串集合中
     * @param prefix
     * @return
     */
    public boolean isPrefixInSet(String prefix);

    /**
     * 使用字典树方式创建的索引查找子字符串
     * @param subString
     * @return
     */
    public boolean isSubStringInSetUseTrieIndex(String subString);

    /**
     * 使用hash方式创建的索引查找子字符串
     * @param subString
     * @return
     */
    public boolean isSubStringInSetUseHashIndex(String subString);

}

public class StringSet implements StringSearchAble {

    private TrieNode root; // 字典树的根节点
    private IndexNode index_root; // 索引节点的根节点
    private final int _INDEX_CHAR_COUNT; // 每条索引的字符个数, 例如如果_INDEX_CHAR_COUNT设置为3, 搜索 "abcdef" "abc" 会在索引的字典树里面查找, "def"会在索引指向所有的字典树节点中查找
    Set<String> my_str_set;
    private Map<Integer, List<TrieNode>> hash_index_for_trienode; // 字典树的hash索引, 实际工程中可以自行实现map减小冲突加快查找速度

    /**
     * 字典树的叶子节点和树节点
     */
    // 设置static使其无法访问到外部类的成员变量
    static class TrieNode{
        TrieNode[] childs; // 所有的子节点
        boolean hasWord = false; // 当前节点位置是否是字符串的结尾, 即是否有这个单词
        public TrieNode(){
            childs = new TrieNode[128]; // ASCII 编码, 128个字符
        }
    }

    /**
     * 索引节点
     */
    static class IndexNode{
        private List<TrieNode> remote_childs; // remote_childs中保存了索引在字符串中出现的位置
        private IndexNode[] childs; // 下一层索引
        private boolean isLeaf; // 是否是索引的最后一层
        public IndexNode(boolean isLeaf){
            remote_childs = new LinkedList<>();
            if(!isLeaf)childs = new IndexNode[128]; // 避免叶子节点浪费内存空间
            this.isLeaf = isLeaf;
        }
        protected void addRemoteChilds(TrieNode trieNode){
            remote_childs.add(trieNode);
        }
        /**
         * 递归创建索引, 填充childs数组
         * @param level
         */
        protected void fillSelf(int level) {
            if(level==1){
                for(int i=0; i<childs.length; i++){
                    childs[i] = new IndexNode(true);
                }
            }
            else {
                for(int i=0; i<childs.length; i++){
                    childs[i] = new IndexNode(false);
                    childs[i].fillSelf(level-1);
                }
            }
        }

        public List<TrieNode> getRemote_childs(){
            return remote_childs;
        }
    }

    public StringSet(int index_level){
        root = new TrieNode();
        _INDEX_CHAR_COUNT = index_level;
        index_root = _buildIndexTree();
        hash_index_for_trienode = new HashMap<>();
    }

    /**
     * 创建索引树
     */
    private IndexNode _buildIndexTree(){
        IndexNode root = new IndexNode(false);
        root.fillSelf(_INDEX_CHAR_COUNT);
        return root;
    }

    public StringSet(){
        this(3); // 默认三个字符串创建一个索引.
    }


    @Override
    public void buildFromStrSet(Set<String> strs) {
        my_str_set = strs;
        for(String s:strs){
            insert(s);
        }
    }

    @Override
    public boolean isPrefixInSet(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            if(curr.childs[c]==null)return false;
            curr = curr.childs[c];
        }
        // 有前缀为 prefix 的字符串, 返回true
        return true;
    }

    @Override
    public boolean isSubStringInSetUseTrieIndex(String subString) {
        int len = subString.length();
        char[] chars = subString.toCharArray();
        if(len<_INDEX_CHAR_COUNT)return bruteFind(subString); // 如果被搜索的字符串很短, 字符串集合中很大概率有这个字符串, 暴力搜索很快即可找到
        List<TrieNode> remote_childs = getNodesUseTireIndex(subString);
        for(TrieNode trieNode:remote_childs)if(isTrieNodeMatchPattern(trieNode, chars, _INDEX_CHAR_COUNT))return true;
        return false;
    }

    @Override
    public boolean isSubStringInSetUseHashIndex(String subString) {
        int hashcode = subString.substring(0, _INDEX_CHAR_COUNT).hashCode();
        if(!hash_index_for_trienode.containsKey(hashcode))return false;
        List<TrieNode> nodes = hash_index_for_trienode.get(hashcode);
        for(TrieNode node:nodes){
            if(isStringMatchTrieNode(subString, node))return true;
        }
        return false;
    }

    private boolean isStringMatchTrieNode(String str, TrieNode node){
        TrieNode curr = node;
        for(char c:str.toCharArray()){
            if(curr.childs[c]==null)return false;
            curr = curr.childs[c];
        }
        return true;
    }

    /**
     * 从字典树的一个节点查找是否有符合chars[start_index:] 的序列
     * @param trieNode 待查找的字典树节点
     * @param chars 查找的字符串
     * @param start_index 字符串的起点
     * @return
     */
    private boolean isTrieNodeMatchPattern(TrieNode trieNode, char[] chars, int start_index){
        int i = start_index;
        TrieNode curr = trieNode;
        for(int len = chars.length; i<len; i++){
            if(curr.childs[chars[i]]==null)return false;
            curr = curr.childs[chars[i]];
        }
        return true;

    }

    /**
     * 查找字符串的位置
     * @param s
     * @return
     */
    private List<TrieNode> getNodesUseTireIndex(String s){
        IndexNode curr = index_root;
        char[] chars = s.toCharArray();
        for(int i = 0; i < _INDEX_CHAR_COUNT; i++){
            curr = curr.childs[chars[i]];
        }
        return curr.getRemote_childs();
    }

    /**
     * 暴力求解, 在字符串集合中找是否包含待查找的pattern,
     * 本函数适合pattern长度比较小的查找(例如包含一个字符到三个字符),
     * 因为小字符串被包含的概率较大, 并不一定完整遍历字符串集合既能找到结果
     * exa. 很多字符串都包含 'a' 字符
     * @param pattern
     * @return
     */
    private boolean bruteFind(String pattern){
        for(String s:my_str_set){
            if(isSubStringBad(s, pattern)){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断t 是否是s 的子串, 使用最笨的方法, 有很多优化的方法, 比如KMP, BoyerMoore
     * @param s
     * @param t
     * @return
     */
    private boolean isSubStringBad(String s, String t){
        int len_s = s.length();
        int len_t = t.length();
        if(len_s < len_t)return false;
        for(int i = 0, end = len_s - len_t + 1; i < end; i++){
            boolean equal = true;
            for(int j = 0; j<t.length(); j++){
                if(s.charAt(i+j)!=t.charAt(j))equal = false;
            }
            if(equal)return true;
        }
        return false;
    }

    /**
     * 将字符串插入到字典树中
     * 同时为字符串每一个子串创建字典树索引和hash索引 , 因为字典树索引和hash索引写在一起代码比较混乱,
     * 故hash索引的创建写在另外的函数中, 实际项目中应该写在一起节省插入时间
     * @param word
     */
    private synchronized void insert(String word){
        TrieNode curr = root;
        char[] word_char = word.toCharArray();
        for(int i=0, len = word_char.length; i<len; i++){
            char index = word_char[i];
            if(curr.childs[index] == null){
                // 创建字典树节点
                curr.childs[index] = new TrieNode();
            }
            // 如果字符串前缀个数超过了_INDEX_CHAR_CONT, 那么为当前的节点创建索引
            if(i>=_INDEX_CHAR_COUNT-1 ){
                createIndexForTrieNode(word_char, i - _INDEX_CHAR_COUNT + 1, i , curr.childs[index]);
            }
            curr = curr.childs[index];
        }
        curr.hasWord = true;
        //创建hash索引, 实际工程中创建hash索引应该与上述代码合并, 这里只是为了表达自己创建hash索引的想法
        makeHashIndex(word);
    }

    /**
     * 下面代码在实际工程中应与上述代码合并
     * @param word
     */
    private synchronized void makeHashIndex(String word){
        TrieNode curr = root;
        TrieNode trie_node_hash_value = root;
        int start_point = 0;
        char[] word_char = word.toCharArray();
        for(int i=0, len=word_char.length; i<len; i++){
            char index = word_char[i];
            if(i>=_INDEX_CHAR_COUNT-1){
                createHashIndexForTireNode(word.substring(start_point, start_point + _INDEX_CHAR_COUNT).hashCode(), trie_node_hash_value);
                trie_node_hash_value = trie_node_hash_value.childs[word.charAt(start_point++)];
            }
            curr = curr.childs[index];
        }
    }

    /**
     * 根据hashcode 为trieNode 创建索引, 为了表述方便简单的存入hashmap, 实际工程中可以自行实现的hashmap或者使用各类hash算法减小冲突加快查找
     * @param hashcode
     * @param trieNode
     */
    private void createHashIndexForTireNode(int hashcode, TrieNode trieNode){
        if(!hash_index_for_trienode.containsKey(hashcode))hash_index_for_trienode.put(hashcode, new LinkedList<>());
        hash_index_for_trienode.get(hashcode).add(trieNode);
    }

    /**
     *
     * @param word_char
     * @param start
     * @param end
     * @param trieNode
     */
    private synchronized void createIndexForTrieNode(char[] word_char, int start, int end, TrieNode trieNode){
        IndexNode curr = index_root;
        for(int i = start; i <= end; i++){
            curr = curr.childs[word_char[i]];
        }
        curr.addRemoteChilds(trieNode);
    }

    /**
     * 测试代码
     * @param args
     */
    public static void main(String[] args){
        String[] test_list = {"abcde", "abcdf", "abcdg", "abcdh", "abcdie"};
        Set<String> test_set = new HashSet<String>(Arrays.asList(test_list));
        StringSet stringSet = new StringSet();
        stringSet.buildFromStrSet(test_set);
        // 测试前缀查找
        boolean res = stringSet.isPrefixInSet("abc");
        System.out.println("Search by prefix : "+res);
        assert res;
        // 查找字符串不超过三个字符, 使用暴力查找, exa. 查找"dh", 字符串 "abcdh"满足查找条件
        res = stringSet.isSubStringInSetUseTrieIndex("dh");
        System.out.println("Search by brute : " + res);
        assert res;
        // 查找的字符串超过三个字符, 使用字典树索引查找, exa. 查找cdi, 字符串"abcdi" 满足查找条件
        res = stringSet.isSubStringInSetUseTrieIndex("cdi");
        System.out.println(res);
        assert res;
        res = stringSet.isSubStringInSetUseTrieIndex("bcdf");
        System.out.println(res);
        assert res;
        res = stringSet.isSubStringInSetUseTrieIndex("abc");
        System.out.println(res);
        assert res;
        res = stringSet.isSubStringInSetUseTrieIndex("abd");
        System.out.println(res);
        assert !res;
        res = stringSet.isSubStringInSetUseHashIndex("bcdh");
        System.out.println(res);
        assert res;
        res = stringSet.isSubStringInSetUseHashIndex("bcdb");
        System.out.println(res);
        assert !res;
        System.out.println("abc".hashCode());
    }
}
