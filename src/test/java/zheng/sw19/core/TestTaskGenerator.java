package zheng.sw19.core;

import org.junit.Test;
import zheng.sw19.core.TaskGenerator.ConsoleTaskGenerator;
import zheng.sw19.core.TaskGenerator.TaskGenerator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TestTaskGenerator {

    TaskGenerator console = new ConsoleTaskGenerator();

    @Test
    public void test1() throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource("parameters/test1.csv").toURI());
        List<int[]> ranges = Arrays.asList(
            new int[] {2, 4},
            new int[] {6, 10}
        );

        console.generateTask(ranges, path);
    }
}
