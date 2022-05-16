package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    Lock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftIdx = philosopher, rightIdx = (philosopher + 1) % 5;
        forks[leftIdx].lock();
        pickLeftFork.run();
        forks[rightIdx].lock();
        pickRightFork.run();
        eat.run();
        forks[leftIdx].unlock();
        putLeftFork.run();
        forks[rightIdx].unlock();
        putRightFork.run();
    }
}
