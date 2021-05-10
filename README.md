# Cuckoo Hash

This repo show the functions of cuckoo hash with a stash.


## Functions

1. main: 主函数，选用一个数据库并调用cuckoo类构造，最后进行测试查找;
2. cuckoo: cuckoo hash的实现;
3. util/Hash: 实现 cuckoo hash 中用到的哈希函数.

## Tech Stack

- BackEnd
  - Java version: 8(1.8)




## Reference

1.Adam Kirsch, Michael Mitzenmacher, and Udi Wieder. 2009. More Robust Hashing:
Cuckoo Hashing with a Stash. SIAM J. Comput. 39, 4 (2009), 1543–1561.

2.Daniel Lemire. 2019. Fast Random Integer Generation in an Interval. ACM Trans. Model. Comput. Simul. 29, 1, Article 3 (Jan. 2019), 12 pages.
