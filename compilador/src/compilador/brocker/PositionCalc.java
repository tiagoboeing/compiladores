package compilador.brocker;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class PositionCalc {

    public static Integer getLine(Integer absPos, List<Integer> breakList) {
        if (breakList.stream().anyMatch((x) -> x >= absPos)) {
            return breakList.indexOf(breakList.stream().filter((x) -> x >= absPos).findFirst().get()) + 1;
        }
        return breakList.size() + 1;
    }

    public static Integer getColumn(Integer absPos, List<Integer> breakList) {
        Integer line = getLine(absPos, breakList);
        return getColumn(absPos, breakList, line);
    }

    public static Integer getColumn(Integer absPos, List<Integer> breakList, Integer line) {
        if (line == 1) {
            return absPos + 1;
        }
        return absPos - breakList.get(line - 2);
    }

    public static List<Integer> getLineEndings(String input) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Integer> lineEndings = Arrays.asList(input.split("\n")).stream().
                map(String::length).
                map(x -> x+1).
                map(atomicInteger::addAndGet).
                map(x -> x-1).
                collect(Collectors.toList());

        return lineEndings;
    }

}
