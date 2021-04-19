import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class JUCTest {

    public static volatile int count = 0;
    ReentrantLock rlock = new ReentrantLock();
    Condition xCon = rlock.newCondition();
    Condition yCon = rlock.newCondition();
    Condition zCon = rlock.newCondition();

    int n = 1;

    @Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());
        Thread t3 = new Thread(new C());

        t1.start();
        t2.start();
        t3.start();
        t2.join();
        return;
    }

    class A implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    rlock.lock();
                    while (count % 3 != 0)// 注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        xCon.await();
                    System.out.println("X");
                    count++;
                    yCon.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rlock.unlock();
                }
            }
        }
    }

    class B implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    rlock.lock();
                    while (count % 3 != 1)// 注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        yCon.await();
                    System.out.println("Y");
                    count++;
                    zCon.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rlock.unlock();
                }
            }
        }
    }

    class C implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    rlock.lock();
                    while (count % 3 != 2)// 注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        zCon.await();
                    System.out.println("Z");
                    count++;
                    xCon.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rlock.unlock();
                }
            }
        }

    }
}