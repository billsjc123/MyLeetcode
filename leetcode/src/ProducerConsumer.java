import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    static LinkedList<Integer> arr = new LinkedList<Integer>();
    static int count = 0;
    static final int MAX = 10;

    static ReentrantLock lock = new ReentrantLock();
    static Condition producer = lock.newCondition();
    static Condition consumer = lock.newCondition();

    public static void get() throws InterruptedException {
        lock.lock();
        while (arr.size() == 0) {
            consumer.await();
        }
        count--;
        int x = arr.removeFirst();
        producer.signalAll();
        System.out.println(Thread.currentThread().getName() + " get:" + x);
        lock.unlock();
    }

    public static void put() throws InterruptedException {
        lock.lock();
        while (arr.size() == MAX) {
            producer.await();
        }

        int x = new Random().nextInt(100);
        arr.add(x);
        count++;
        consumer.signalAll();
        System.out.println(Thread.currentThread().getName() + " put:" + x);
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread("con " + i) {
                @Override
                public void run() {
                    for (int i = 0; i < 2; i++) {
                        try {
                            get();
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread("pro " + i) {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        try {
                            put();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}

// class ShareData {
//     private int number = 0;
//     private ReentrantLock lock = new ReentrantLock();
//     private Condition condition = lock.newCondition();

//     public void increment() throws Exception {
//         lock.lock();
//         try { 
//             while (number != 0) {
//                 //等待，不能生产
//                 condition.await();
//             }
//             number++;
//             System.out.println(Thread.currentThread().getName() + "\t" + number);

//             condition.signalAll();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             lock.unlock();
//         }


//     }

//     public void decrement() throws Exception {
//         lock.lock();
//         try {
//             while (number == 0) {
//                 //等待，不能消费
//                 condition.await();
//             }

//             number--;
//             System.out.println(Thread.currentThread().getName() + "\t" + number);

//             condition.signalAll();
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             lock.unlock();
//         }


//     }
// }

// public class ProducerConsumer{
//     public static void main(String[] args) {
//         ShareData shareData = new ShareData();

//         new Thread(()->{
//             for (int i = 0; i < 5; i++) {
//                 try {
//                     shareData.increment();
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, "AA").start();

//         new Thread(()->{
//             for (int i = 0; i < 5; i++) {
//                 try {
//                     shareData.decrement();
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, "BB").start();

//         new Thread(()->{
//             for (int i = 0; i < 5; i++) {
//                 try {
//                     shareData.increment();
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, "CC").start();

//         new Thread(()->{
//             for (int i = 0; i < 5; i++) {
//                 try {
//                     shareData.decrement();
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, "DD").start();
//     }
// }