package top.whatimiss.littlenote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication
public class LittleNoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(LittleNoteApplication.class, args);
    }

}
