# 阿里妈妈面试编程

题目：实现字符串集合中的前缀检索, 以及子串检索
****

### 前缀检索

使用字典树, 不再啰嗦

### 子串检索

****

#### 创建字典树索引

实现思想如下图（限定了索引的层数为3）

![字典树创建索引](http://7xrgjg.com1.z0.glb.clouddn.com/WeChat_1489810732.jpeg)  

索引和字符串集合均存储在字典树中, 例如在上图的字符串空间，查找"abcd", 会先根据字符串前缀"abc" 在索引中查找到所有的remote_childs, 然后再对所有的childs从'c'节点做字典树查找。

****

#### 创建hash索引

实现思想如下图（假设 "abc".hashCode()\=="bcf".hashCode()\==96354）  

![hash创建索引](http://7xrgjg.com1.z0.glb.clouddn.com/WeChat_1489811493.jpeg)

##### 索引创建
每三个字符求一下hashCode并加入到hash索引中。

##### 查找

例如查找"abcf"：

求 "abc".hashCode(), 找到所有remote_childs, 为了避免hashCode相同的情况，需要在字典树中重头开始匹配，最后返回结果。

## 代码实现


