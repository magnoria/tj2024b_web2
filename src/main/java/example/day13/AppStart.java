package example.day13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // scheduled 쓸려면 stat에 적용해야함
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);

    }
}
