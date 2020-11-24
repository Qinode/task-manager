package zheng.sw19.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class TestWorkSpace {

    @Test
    public void test1() throws IOException {
        WorkSpace ws = new WorkSpace(getClass().getClassLoader().getResource("workspaces/ws1/").getPath());
        Assert.assertNotEquals(ws, null);

        int[] range = ws.getAllTask();
        Assert.assertEquals(range[0], 0);
        Assert.assertEquals(range[1], 10);
    }

    @Test
    public void test2() throws IOException {
        WorkSpace ws = new WorkSpace(getClass().getClassLoader().getResource("workspaces/ws2/").getPath());
        Assert.assertNotEquals(ws, null);

        int[] range = ws.getAllTask();
        Assert.assertEquals(range[0], 0);
        Assert.assertEquals(range[1], 0);
    }

    @Test
    public void test3() throws IOException {
        WorkSpace ws = new WorkSpace(getClass().getClassLoader().getResource("workspaces/ws3/").getPath());
        Assert.assertNotEquals(ws, null);

        int[] range = ws.getAllTask();
        Assert.assertEquals(range[0], 0);
        Assert.assertEquals(range[1], 1);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void test4() throws IOException {
        expectedException.expect(IOException.class);
        expectedException.expectMessage(".params file not found");
        WorkSpace ws = new WorkSpace(getClass().getClassLoader().getResource("workspaces/ws4/").getPath());
    }
}
