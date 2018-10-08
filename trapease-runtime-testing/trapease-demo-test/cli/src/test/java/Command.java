import org.junit.After;
import org.junit.Before;
import org.tomitribe.trapease.movie.rest.cmd.base.TrapeaseCli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Command {
    protected ByteArrayOutputStream outLogs = null;
    protected ByteArrayOutputStream errLogs = null;

    @Before
    public void resetLogs() {
        outLogs = new ByteArrayOutputStream();
        errLogs = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outLogs));
        System.setErr(new PrintStream(errLogs));
    }

    @After
    public void restoreStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    protected static void cmd(final String cmd, final URL url) {
        List<String> params = new ArrayList<>(Arrays.asList(cmd.split(" (?=(([^'\"]*['\"]){2})*[^'\"]*$)")));
        params = params.stream().map(p -> p.replaceAll("\"", "")).collect(Collectors.toList());
        if (url != null) {
            params.add(0, "--url");
            params.add(1, url.toString());
        }
        TrapeaseCli.main(params.toArray(new String[]{}));
    }

    protected static void cmd(final String cmd) {
        List<String> params = new ArrayList<>(Arrays.asList(cmd.split(" (?=(([^'\"]*['\"]){2})*[^'\"]*$)")));
        params = params.stream().map(p -> p.replaceAll("\"", "")).collect(Collectors.toList());
        TrapeaseCli.main(params.toArray(new String[]{}));
    }
}
