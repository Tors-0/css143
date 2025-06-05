ICA
1. What do we use Big O notation for, and why do we use it?
   1. it represents the time complexity of an algorithm relative to its input. we use it to compare the speed of different algorithms
2. What reference function g should you choose such that the function f(w)=w+log2(w) is O(g(w))? 
   1. n log n
3. Use the following code to answer the questions.
```java
    public static int num_occurrences(int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                 if( i == j ) continue;
                 if(strings[i] == strings[j]) {
                   count++;
                 }
            }
        }
        return count;
    }
```
LAB
1. estimate g(x) given f(x)
   1. g(n) = n^5
   2. g(t) = t^3
   3. g(x) = x^2 * log(x)
   4. g(w) = w * log(w)
2. counting ops to produce...
   1. f(x) = 1
   2. f(x) = 1 + 3n
   3. f(x) = 2 + 4n
3. demonstrating ...
   1. isEmpty()
      1. f(x) = 1
      2. g(x) = 1
      3. c > 1
      4. k = 0
   2. c(n)
      1. f(x) = 1 + 3n
      2. g(x) = n
      3. c = 4
      4. k = 1
   3. isPrime(n)
      1. f(x) = 2 + 4n
      2. g(x) = n
      3. c = 6
      4. k = 1