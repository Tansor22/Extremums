package app;

import core.AlternatingVariableDescentMethod;
import core.MultiVarsFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

public class AlternatingVariableDescentMethodDemo {
    private static final Map<Integer, Map<String, Object>> TEST_CASES = new HashMap();

    static {
        Map<String, Object> testCase = new HashMap<>();
        testCase.put("f", (MultiVarsFunction) x -> 2 * sqr(x[0]) + sqr(x[1]) - x[0] * x[1]);
        testCase.put("args", new double[]{2.0, 1.0});
        testCase.put("eps", .00001);
        TEST_CASES.put(1, testCase);

        testCase = new HashMap<>();
        testCase.put("f", (MultiVarsFunction) x -> 4 * sqr(x[0] - 5) + sqr(x[1] - 6));
        testCase.put("args", new double[]{8.0, 9.0});
        testCase.put("eps", .001);
        TEST_CASES.put(2, testCase);

        testCase = new HashMap<>();
        testCase.put("f", (MultiVarsFunction) x -> sqr(x[0] + x[1] * 3) - sqr(x[1] + 20 * x[0]));
        testCase.put("args", getArgs(0, 10, 2));
        testCase.put("eps", .001);
        TEST_CASES.put(3, testCase);

    }

    public static void main(String[] args) {
        double a = -5000;
        double b = 5000;
        AlternatingVariableDescentMethod avdm = new AlternatingVariableDescentMethod();
        Map<String, Object> testCase = TEST_CASES.get(2);

        avdm.find(1000,
                (double) testCase.get("eps"),
                a, b,
                (MultiVarsFunction) testCase.get("f"),
                (double[]) testCase.get("args"));

    }

    private static double[] getArgs(double a, double b, int n) {

        return DoubleStream.generate(() -> a + (Math.random() * (b - a))).limit(n).toArray();
    }
    private static double sqr(double x) {return x * x;}
}
