package zheng.sw19.core.TaskGenerator;

public class ConsoleTaskGenerator extends AbstractTaskGenerator{

    @Override
    public void processTask(String line, int start, int end) {
        System.out.println(String.format("[%s, %s] %s", start, end, line));
    }
}
