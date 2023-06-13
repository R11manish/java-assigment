public class MainThreadExample2 {
  public static void main(String[] args) {
    Thread mainThread = Thread.currentThread();
    Thread childThread = new ChildThread(mainThread);
    childThread.start();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException err) {
      err.printStackTrace();
    }
    System.out.println("Main thread finished executing");
  }
}

class ChildThread extends Thread {
  private Thread mainThread;

  ChildThread(Thread mainThread) {
    this.mainThread = mainThread;
  }

  @Override
  public void run() {
    try {
      mainThread.join();
    } catch (InterruptedException err) {
      err.printStackTrace();
    }
    System.out.println("Child Thread Resumed Executing");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException err) {
      err.printStackTrace();
    }
    System.out.println("Child Thread Finished Executing");
  }
}
