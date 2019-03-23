package assignment5;
import java.util.Objects;
import java.util.Scanner;
class QuadraticProbingHashTable < K, V > {
  private static final int DEFAULT_TABLE_SIZE = 101;
  static final HashEntry << ? ,
  ? > [] EMPTY_TABLE = {};
  @SuppressWarnings("unchecked")
  transient HashEntry < K,
  V > [] table = (HashEntry < K, V > []) EMPTY_TABLE;
  private int currentSize,
  maxSize;
  HashEntry < K,
  V > [] arrays = null;
  /**
   *
   */
  public QuadraticProbingHashTable() {
      this(DEFAULT_TABLE_SIZE);
  }
  /**
   *
   * @param capacity
   */
  public QuadraticProbingHashTable(int size) {
      currentSize = 0;
      maxSize = size;
      allocateArray(size);
      doClear();
  }
  /**
   *
   * @param n
   * @return
   */
  private static int nextPrime(int n) {
      if (n % 2 == 0)
          n++;
      for (; !isPrime(n); n += 2)
      ;
      return n;
  }
  /**
   *
   * @param n
   * @return
   */
  private static boolean isPrime(int n) {
      if (n == 2 || n == 3)
          return true;
      if (n == 1 || n % 2 == 0)
          return false;
      for (int i = 3; i * i <= n; i += 2)
          if (n % i == 0)
              return false;
      return true;
  }
  private void doClear() {
      for (int i = 0; i < arrays.length; i++)
          arrays[i] = null;
  }
  @SuppressWarnings("unchecked")
  private void allocateArray(int arraySize) {
      arrays = new HashEntry[nextPrime(arraySize)];
  }
  /*
   * private int myhash(K x) { int hashVal = x.hashCode(); hashVal %=
   * arrays.length; if (hashVal < 0) hashVal += arrays.length; return hashVal;
   * }
   */
  private int myhash(K key) {
      return key.hashCode() % maxSize;
  }
  /** Function to get size of hash table **/
  public int getSize() {
      return currentSize;
  }
  /** Function to check if hash table is full **/
  public boolean isFull() {
      return currentSize == maxSize;
  }
  /** Function to check if hash table is empty **/
  public boolean isEmpty() {
      return getSize() == 0;
  }
  /** Fucntion to check if hash table contains a key **/
  public boolean contains(K key) {
      return get(key) != null;
  }
  private int findPos(K x) {
      int offset = 1;
      int currentPos = myhash(x);
      while (arrays[currentPos] != null && !arrays[currentPos].key.equals(x)) {
          currentPos += offset; // Compute ith probe
          offset += 2;
          if (currentPos >= arrays.length)
              currentPos -= arrays.length;
      }
      return currentPos;
  }
  /**
   *
   * @param key
   * @param val
   */
  public void insert(K key, V val) {
      int tmp = myhash(key);
      int i = tmp, h = 1;
      do {
          if (arrays[i] == null) {
              arrays[currentSize] = new HashEntry < K, V > (tmp, key, val, null);
              currentSize++;
              return;
          }
          if (arrays[i].key.equals(key)) {
              arrays[i].value = val;
              return;
          }
          i = (i + h * h++) % maxSize;
      } while (i != tmp);
  }
  public V insert1(K k, V v) {
      if (k == null)
          return putForNullKey(v);
      int hash = myhash(k);
      int i = indexFor(hash, arrays.length);
      for (HashEntry < K, V > e = arrays[i]; e != null; e = e.next) {
          K k1;
          if (e.hash == hash && ((k1 = e.key) == k || k1.equals(k))) {
              V oldValue = e.value;
              e.value = v;
              return oldValue;
          }
      }
      addEntry(hash, k, v, i);
      return null;
  }
  private V putForNullKey(V value) {
      for (HashEntry < K, V > e = table[0]; e != null; e = e.next) {
          if (e.key == null) {
              V oldValue = e.value;
              e.value = value;
              return oldValue;
          }
      }
      addEntry(0, null, value, 0);
      return null;
  }
  void addEntry(int hash, K key, V value, int bucketIndex) {
      if ((currentSize >= maxSize) && (null != arrays[bucketIndex])) {
          rehash();
          hash = (null != key) ? myhash(key) : 0;
          bucketIndex = indexFor(hash, table.length);
      }
      createEntry(hash, key, value, bucketIndex);
  }
  void createEntry(int hash, K key, V value, int bucketIndex) {
      HashEntry < K, V > e = arrays[bucketIndex];
      arrays[bucketIndex] = new HashEntry < K, V > (hash, key, value, e);
      currentSize++;
  }
  private void rehash() {
      HashEntry < K, V > [] oldArray = arrays;
      // Create a new double-sized, empty table
      allocateArray(2 * oldArray.length);
      currentSize = 0;
      maxSize = 0;
      // Copy table over
      for (HashEntry < K, V > entry: oldArray)
          if (entry != null)
              insert1(entry.key, entry.value);
  }
  final HashEntry < K,
  V > getEntry(K key) {
      if (currentSize == 0) {
          return null;
      }
      int hash = (key == null) ? 0 : myhash(key);
      for (HashEntry < K, V > e = arrays[indexFor(hash, arrays.length)]; e != null; e = e.next) {
          Object k;
          if (e.hash == hash &&
              ((k = e.key) == key || (key != null && key.equals(k))))
              return e;
      }
      return null;
  }
  private V getForNullKey() {
      if (maxSize == 0) {
          return null;
      }
      for (HashEntry < K, V > e = table[0]; e != null; e = e.next) {
          if (e.key == null)
              return e.value;
      }
      return null;
  }
  static int indexFor(int h, int length) {
      // assert Integer.bitCount(length) == 1 :
      // "length must be a non-zero power of 2";
      return h & (length - 1);
  }
  /** Function to get value for a given key **/
  public V get(K k) {
      if (k == null)
          return getForNullKey();
      HashEntry < K, V > entry = getEntry(k);
      return null == entry ? null : entry.getValue();
  }
  static class HashEntry < K,
  V > implements java.util.Map.Entry < K,
  V > {
      final K key;
      V value;
      HashEntry < K,
      V > next;
      int hash;
      /**
       * Creates new entry.
       */
      HashEntry(int h, K k, V v, HashEntry < K, V > n) {
          value = v;
          next = n;
          key = k;
          hash = h;
      }
      public final K getKey() {
          return key;
      }
      public final V getValue() {
          return value;
      }
      public final V setValue(V newValue) {
          V oldValue = value;
          value = newValue;
          return oldValue;
      }
      public final boolean equals(Object o) {
          if (!(o instanceof HashEntry))
              return false;
          @SuppressWarnings("unchecked")
          HashEntry < K, V > e = (HashEntry < K, V > ) o;
          Object k1 = getKey();
          Object k2 = e.getKey();
          if (k1 == k2 || (k1 != null && k1.equals(k2))) {
              Object v1 = getValue();
              Object v2 = e.getValue();
              if (v1 == v2 || (v1 != null && v1.equals(v2)))
                  return true;
          }
          return false;
      }
      public final int hashCode() {
          return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
      }
      public final String toString() {
          return getKey() + "=" + getValue();
      }
  }
}
class Map < K, V > {
  private QuadraticProbingHashTable < K,
  V > items;
  public Map() {
      items = new QuadraticProbingHashTable < K, V > (10);
  }
  public Map(int capacity) {
      items = new QuadraticProbingHashTable < K, V > (capacity);
  }
  public void put(K key, V val) {
      items.insert1(key, val);
  }
  public V get(K key) {
      return items.get(key);
  }
  public boolean isEmpty() {
      return items.isEmpty();
  }
  public void makeEmpty() {
      // items.makeEmpty();
  }
}
public class QuadraticProbingHashTableTest {
  public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter Intial capacity for Map or Enter Map size");
      Map < String, String > map = new Map < String, String > (scan.nextInt());
      char ch;
      do {
          System.out.println("\nHash Table Operations\n");
          System.out.println("1. insert ");
          System.out.println("2. get");
          int choice = scan.nextInt();
          switch (choice) {
              case 1:
                  System.out.println("Enter key and value");
                  map.put(scan.next(), scan.next());
                  break;
              case 2:
                  System.out.println("Enter key");
                  System.out.println("Value = " + map.get(scan.next()));
                  break;
              default:
                  System.out.println("Wrong Entry \n ");
                  break;
          }
          System.out.println("\nDo you want to continue (Type y or n) \n");
          ch = scan.next().charAt(0);
      } while (ch == 'Y' || ch == 'y');
  }
}






/*
--------------- End---------------------
Output
-------------
Enter Intial capacity for Map or Enter Map size
5
Hash Table Operations
1. insert
2. get
1
Enter key and value
10
100
Do you want to continue (Type y or n)
y
Hash Table Operations
1. insert
2. get
1
Enter key and value
20
200
Do you want to continue (Type y or n)
y
Hash Table Operations
1. insert
2. get
2
Enter key
20
Value = 200
Do you want to continue (Type y or n)
y
Hash Table Operations
1. insert
2. get
2
Enter key
10
Value = 100
Do you want to continue (Type y or n)
y
Hash Table Operations
1. insert
2. get
3
Wrong Entry

Do you want to continue (Type y or n)
2
*/