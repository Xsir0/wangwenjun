package com.example.wangwenjun.readwritelock;

/**
 * @ClassName ReadLock
 * @Description
 * @Author xsir
 * @Date 2021/9/26 上午6:04
 * @Version V1.0
 */
public class ReadLock implements Lock {

    private final ReadWriteLockImpl readWriteLock;

    ReadLock(ReadWriteLockImpl readWriteLock){
        this.readWriteLock = readWriteLock;
    }

    @Override
    public void lock() throws InterruptedException {
        synchronized (readWriteLock.getMutex()){
            while (readWriteLock.getWritingWriters()>0||(readWriteLock.getPreferWriter() && readWriteLock.getWaitingWriters()>0)){
                readWriteLock.getMutex().wait();
            }
        readWriteLock.incrementReadingReaders();
        }
    }

    @Override
    public void unlock() {
        synchronized (readWriteLock.getMutex()){
            readWriteLock.decrementReadingReaders();
            readWriteLock.changePrefer(true);
            readWriteLock.getMutex().notifyAll();
        }
    }
}
