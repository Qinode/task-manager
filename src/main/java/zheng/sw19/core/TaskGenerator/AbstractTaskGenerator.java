package zheng.sw19.core.TaskGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class AbstractTaskGenerator implements TaskGenerator{
    /**
    * @param ranges,    not empty. Each range should be less or equal to batch size.
    * @param parameters path to the CSV file without header containing the task parameter
    * @return
    * @throws IOException
    */
    public  final void generateTask(List<int[]> ranges, Path parameters) throws IOException {
        int lines = 0;
        int offset = 0;
        int range = 0;

        InputStream ins = Files.newInputStream(parameters);
        BufferedReader br = new BufferedReader(new InputStreamReader(ins));
        String line = null;
        while ((line = br.readLine()) != null) {
            if (lines == (ranges.get(range)[0] + offset)) {
                int[] currentRage = ranges.get(range);
                processTask(line, currentRage[0], currentRage[1]);
                if (currentRage[0] + offset + 1 == currentRage[1]) {
                    offset = 0;
                    if ((++range) >= ranges.size()) break;
                } else {
                    offset++;
                }
            }
            lines++;
        }
        ins.close();
    }

}
