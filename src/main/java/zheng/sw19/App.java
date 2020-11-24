package zheng.sw19;

import zheng.sw19.model.WorkSpace;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    // Default workspace path
    private static final String DEFAULT_WS = ".";

    public static void main( String[] args ) {
        try {
            WorkSpace ws = new WorkSpace(DEFAULT_WS);
            int[] cmd = parseArgs(args);

            if(cmd[0] != 0) {
                int[] allTask = ws.getAllTask();
                System.out.println(String.format("Task Range: [%s, %s]", allTask[0], allTask[1]));
            }
            if(cmd[1] != 0) {
                List<int[]> completeTasks = ws.getCompleteRanges();
                System.out.println("Completed Task: ");
                completeTasks.forEach( i -> {
                    System.out.println(String.format("    [%s, %s]", i[0], i[1]));
                });
            }
            if(cmd[2] != 0) ws.process(cmd[2]);

        } catch (IOException e) {
           System.out.println(e.getMessage());
        }
    }

    private static int[] parseArgs( String[] args ){
        int[] cmd = new int[]{0, 0, 0};

        Arrays.stream(args).forEach(
            arg -> {
                if(arg.startsWith("--")){
                    String[] batchSize = arg.substring(2) .split("=");
                    if(batchSize.length != 2 || !"batchSize".equals(batchSize[0]))
                        System.out.println(String.format("Unknown arguments: [%s]", arg));

                    try {int bs = Integer.parseInt(batchSize[1]); cmd[2] = bs;}
                    catch (NumberFormatException n) {System.out.println(String.format("Illegal Value: [%s]", batchSize[1]));}
                } else if(arg.startsWith("-")){
                    if("-a".equals(arg)) cmd[0] = 1;
                    if("-c".equals(arg)) cmd[1] = 1;
                    if("-ac".equals(arg) || "-ca".equals(arg)){
                        cmd[0] = 1;
                        cmd[1] = 1;
                    }
                } else {
                    System.out.println(String.format("Unknown arguments: [%s]", arg));
                }
            }
        );

        return cmd;
    }
}
