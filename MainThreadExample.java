public class MainThreadExample {

  public static void main(String[] args) {
    Thread thread = new ChildThread();

    thread.start();

    try {
      thread.join(); // Wait for the thread to complete
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Resuming main thread execution.");
  }

  static class ChildThread extends Thread {

    @Override
    public void run() {
      System.out.println("Child thread started.");
      // Simulate some work
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Child thread completed.");
    }
  }
}
