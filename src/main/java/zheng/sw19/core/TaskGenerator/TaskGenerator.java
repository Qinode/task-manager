package zheng.sw19.core.TaskGenerator;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface TaskGenerator {
    public void generateTask(List<int[]> ranges, Path parameters) throws IOException;

    /**
     *
     * A template method called by {@link #generateTask(List, Path)} )}
     *
     * @param line, the task need to be run
     * @param start, the start id of the batch contains {@code line}
     * @param end, the end id of the batch contains {@code line}
     */
    public void processTask(String line, int start, int end);
}
