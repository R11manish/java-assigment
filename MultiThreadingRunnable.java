class MultiThreadingRunnable {
  public static void main(String[] args) {
    ChildThread t1 = new ChildThread();
    ChildThread t2 = new ChildThread();
    Thread thread1 = new Thread(t1, "t1");
    Thread thread2 = new Thread(t2, "t2");
    thread1.start();
    thread2.start();
    System.out.println("Main Thread Finished Executing");
  }
}

class ChildThread implements Runnable {
  @Override
  public void run() {
    System.out.println("Child Thread Executing " + Thread.currentThread().getName());
    try {
      Thread.sleep(2000);
    } catch (InterruptedException err) {
      err.printStackTrace();
    }
    System.out.println("Child Thread Finished Executing " + Thread.currentThread().getName());
  }
}
