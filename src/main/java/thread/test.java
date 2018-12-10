package thread;

public class test {
    public static void main(String[] args) {
        MyRun run = new MyRun();
        Thread thread = new Thread(run);
        thread.start();
        System.out.println("hi");
    }
}
