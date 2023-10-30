public class buffer {
  private int count = 100;
  public synchronized void increment(int value) {
    this.count += value;
    System.out.println(count);
  }
  public synchronized void decrement(int value) {
    this.count -= value;
    System.out.println(count);
  }
}
class increase extends Thread
{
 buffer b;
 increase(buffer b)
 {
  this.b=b;
 }
public void run()
 {
  b.increment(10);
 }
}
class decrease extends Thread
{
 buffer b;
 decrease(buffer b)
 {
  this.b=b;
 }
public void run()
 {
  b.decrement(15);
 }
}
class test
{
 public static void main(String[] s)
 {
  buffer b=new buffer();
  increase i=new increase(b);
  decrease d=new decrease(b);
  i.start();
  d.start();
}
} 