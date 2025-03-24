package example.day10.과제1;

public class WebSurfing extends Thread {
    boolean state = false;

    @Override
    public void run() {

        try {
            while (state){
                Thread.sleep(1000);
                System.out.println("웹서핑 중...");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
