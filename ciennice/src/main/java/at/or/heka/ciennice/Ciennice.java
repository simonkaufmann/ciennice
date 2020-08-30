package at.or.heka.ciennice;

import com.palantir.common.streams.KeyedStream;
import java.util.Arrays;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public final class Ciennice {

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public static void main(String[] args) throws ParseException {
        CommandLineParser commandLineParser = new DefaultParser();

        Options options = new Options();
        options.addOption(new Option("o", "output", true, "Output File"));
        options.addOption(new Option("i", "input", true, "Input File"));

        CommandLine commandLine = commandLineParser.parse(options, args);

        System.out.println(KeyedStream.of(Arrays.asList(commandLine.getOptions()))
                .mapKeys(Option::getId)
                .map(Option::getValues)
                .collectToMap()
                .toString());
    }

    private Ciennice() {}
}
