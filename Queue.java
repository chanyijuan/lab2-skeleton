class Queue {
  private Object[] items;
  private int first;
  private int last;
  private int maxSize;
  private int len;

  public Queue(int size) {
    this.maxSize = size;
    this.items = new Object[size];
    this.first = -1;
    this.last = -1;
    this.len = 0;
  }

  public boolean enq(Object q) {
    if (this.isFull()) {
      return false;
    }
    if (this.isEmpty()) {
      this.first = 0;
      this.last = 0;
    } else {
      this.last = (this.last + 1) % this.maxSize;
    }
    this.items[last] = q;
    this.len += 1;
    return true;
  }

  public Object deq() {
    if (this.isEmpty()) {
      return null;
    }
    Object item = this.items[this.first];
    this.first = (this.first + 1) % this.maxSize;
    this.len -= 1;
    return item;
  }

  boolean isFull() {
    return (this.len == this.maxSize);
  }

  boolean isEmpty() {
    return (this.len == 0);
  }

  @Override
  public String toString() {
    String str = "[ ";
    int i = this.first;
    int count = 0;
    while (count < this.len) {
      str += this.items[i] + " ";
      i = (i + 1) % this.maxSize;
      count++;
    } 
    return str + "]";
  }

  public int length() {
    return this.len;
  }
}
