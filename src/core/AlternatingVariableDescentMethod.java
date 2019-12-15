package core;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static core.ExtremumLogicConstants.ARG;
import static core.ExtremumLogicConstants.MIN;

public class AlternatingVariableDescentMethod {
    private ExtremumFinder ef = new GoldenSectionMethod();
    private static double EPS = .0000001;
    int k = 1000;

    public void find(double a, double b, MultiVarsFunction f, double... args) {
        // TODO
        ((MultiVarsSupport) ef).n = args.length;

        // TODO
        ((GoldenSectionMethod) ef).EPS = EPS;
        double B = f.$(args), A;
        int stepsElapsed = 0;
        double delta = 0.0;
        boolean isCalculated = false;

        for (int i = 0; i < k; i++) {
            A = B;
            for (int j = 0; j < args.length; j++) {
                // TODO
                ((MultiVarsSupport) ef).args = args;
                // TODO
                ((MultiVarsSupport) ef).currentIndex = j;

                double arg = ef.find(a, b, f, MIN, ARG);
                // TODO
                ((MultiVarsSupport) ef).set(arg, args);
            }
            B = f.$(args);

            delta = Math.abs(A - B);
            if (delta <= EPS) {
                isCalculated = true;
                stepsElapsed = i + 1;
                break;
            }
        }
        if (!isCalculated) {
            // fail
            System.out.println("Program has failed: Steps elapsed: " + stepsElapsed);
        } else {
            // success
            System.out.println("Program has finished successfully: Steps elapsed: " + stepsElapsed + " , " + "Error: " + delta);
        }
        Supplier<String> $ = () -> Arrays.stream(args)
                .mapToObj(Double::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Arg = " + $.get());
        System.out.println("Min = " + f.$(args));
    }

}
