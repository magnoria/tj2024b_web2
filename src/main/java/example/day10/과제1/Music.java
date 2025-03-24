package example.day10.과제1;

public class Music implements Runnable {
    boolean state = false;

    @Override
    public void run() {
        try {
            while (true) {
                if( state ) {
                    Thread.sleep(1000);
                    System.out.println("음악재생중...");
                }else{
                    System.out.println("음악종료");
                    break;
                }
            }


        } catch (Exception e) {
            System.out.println(e);
        }
    }

}