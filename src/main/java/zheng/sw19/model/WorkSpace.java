package zheng.sw19.model;

import zheng.sw19.core.TaskGenerator.ConsoleTaskGenerator;
import zheng.sw19.core.util.RangeUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class WorkSpace {
    private final String path;
    private final String completeTaskDir;
    private final static String OUT_PATH = "out";
    private final static String PARAMETERS = ".params";

    public WorkSpace(String path) throws IOException{
        this.path = path;
        if(!Files.exists(Paths.get(path)))
            throw new IOException("WorkSpace not found. Target path: " + path);

        if(!Files.isDirectory(Paths.get(path)))
            throw new IOException("WorkSpace must be a directory. Target path: " +path);

        if(!Files.exists(Paths.get(path, PARAMETERS)))
            throw new IOException(".params file not found. Target path: " + Paths.get(path, PARAMETERS).toString());

        Path out = Paths.get(path, OUT_PATH);
        if(!Files.exists(out) || !Files.isDirectory(out)){
            Files.createDirectory(out);
        }

        this.completeTaskDir = out.toString();
    }

    /**
     * Read number of lines of '.param' file
     *
     * @return a int array of size 2, forming a continuous range (inclusive, exclusive).
     */
    public int[] getAllTask() throws IOException {
        long lines = Files.lines(Paths.get(path, PARAMETERS)).count();
        return new int[] {0, (int) lines};
    }

    public List<int[]> getCompleteRanges() throws IOException {
        List<int[]> result = new ArrayList<int[]>();

        Stream<Path> allCompleteTask = Files.list(Paths.get(completeTaskDir));
        allCompleteTask.filter(p -> !Files.isDirectory(p)).forEach(
                p -> result.add(parseCompleteRange(p))
        );

        result.sort(Comparator.comparingInt(el -> el[0]));
        return result;
    }

    private int[] parseCompleteRange(Path result){
        String completeRange = result.getFileName().toString().replaceFirst("[.][^.]+$", "");
        String[] range = completeRange.split("-");
        return new int[] {Integer.parseInt(range[0]), Integer.parseInt(range[1])};
    }

    public void process(int batchSize) throws IOException {
        int[] allTasks = getAllTask();
        List<int[]> getCompleted = getCompleteRanges();
        List<int[]> incomplete = RangeUtil.allRangeDifference(getCompleted, allTasks);
        List<int[]> todoRange = new ArrayList<int[]>() ;
        incomplete.forEach(r -> todoRange.addAll(RangeUtil.divideRange(r, batchSize)));

        new ConsoleTaskGenerator().generateTask(todoRange, Paths.get(this.path, PARAMETERS));
    }
}
