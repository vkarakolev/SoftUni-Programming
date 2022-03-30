package AutoMappingObjectsEx;

import AutoMappingObjectsEx.exceptions.UserNotLoggedException;
import AutoMappingObjectsEx.exceptions.ValidationException;
import AutoMappingObjectsEx.services.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final ExecutorService executorService;

    @Autowired
    public ConsoleRunner(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String result;

        try {
            result = this.executorService.execute(command);
        } catch (ValidationException | UserNotLoggedException ex) {
            result = ex.getMessage();
        }

        System.out.println(result);
    }
}
