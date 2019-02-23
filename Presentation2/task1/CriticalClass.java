package Presentation2.task1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CriticalClass
{

    private Lock lock;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 0; i<10; i++)
        {
            int finalI = i;

            new Thread(() -> new CriticalClass(lock).firstMethod(finalI)).start();
            new Thread(() -> new CriticalClass(lock).secondMethod(finalI)).start();
            new Thread(() -> new CriticalClass(lock).thirdMethod((finalI))).start();
        }
    }


    public CriticalClass(Lock lock) {
        this.lock = lock;
    }

    public void firstMethod(int i) {
        lock.lock();
        try {
            System.out.println("First method, iteration" + i);
        } finally {
            lock.unlock();
        }
    }

    public void secondMethod(int i) {
        lock.lock();
        try {
            System.out.println("Second method, iteration" + i );
        } finally {
            lock.unlock();
        }
    }

    public void thirdMethod(int i) {
        lock.lock();
        try {
            System.out.println("Third method, iteration" + i);
        } finally {
            lock.unlock();
        }
    }
}