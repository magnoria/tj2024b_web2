package example.day10.과제1;

public class WebSurfing extends Thread {
    boolean state = false;

    @Override
    public void run() {

        try {
            while (true){
                if (state) {
                    Thread.sleep(1000);
                    System.out.println("웹서핑 중...");
                }else {
                    System.out.println("웹서핑 종료");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
