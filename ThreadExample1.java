class ThreadExample1 implements Runnable {

  public String name;

  public ThreadExample1(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(name + "thread started working");

    for (int i = 0; i < 10; i++) {
      System.out.println(name + ":" + i);
      Thread.yield();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException err) {
        err.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    ThreadExample1 worker1 = new ThreadExample1("worker 1 ->");
    ThreadExample1 worker2 = new ThreadExample1("worker 2 ->");
    Thread thread1 = new Thread(worker1);
    Thread thread2 = new Thread(worker2);
    thread1.start();
    thread2.start();
  }
}