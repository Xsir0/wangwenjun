package com.example.wangwenjun.readwritelock;

/**
 * @ClassName WriteLock
 * @Description
 * @Author xsir
 * @Date 2021/9/26 上午6:11
 * @Version V1.0
 */
public class WriteLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    public WriteLock(ReadWriteLockImpl readWriteLock) {
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()){
            try {
                readWriteLock.incrementWaitingWriters();
                while (readWriteLock.getReadingReaders()>0 || readWriteLock.getWritingWriters()>0){
                    readWriteLock.getMutex().wait();
                }
            }finally {
                this.readWriteLock.decrementWaitingWriters();
            }
            readWriteLock.incrementWritingWriters();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()){
            readWriteLock.decrementWaitingWriters();
            readWriteLock.changePrefer(false);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
