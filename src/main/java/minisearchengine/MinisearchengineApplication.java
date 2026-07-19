package minisearchengine;

import minisearchengine.service.Indexer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MinisearchengineApplication {

    public static Indexer indexer;

    public static void main(String[] args) {

        indexer = new Indexer();

        try {
            indexer.buildIndex("documents");
            System.out.println("Index built successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        SpringApplication.run(MinisearchengineApplication.class, args);
    }
}