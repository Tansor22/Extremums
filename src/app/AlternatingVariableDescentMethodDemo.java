package app;

import core.AlternatingVariableDescentMethod;
import core.AlternatingVariableDescentMethodC;
import core.MultiVarsFunction;

import java.util.function.Supplier;
import java.util.stream.DoubleStream;

public class AlternatingVariableDescentMethodDemo {
    public static void main(String[] args) {
       /* double a = -50;
        double b = 50;
        MultiVarsFunction f = x -> Math.exp(x[0] + x[1] + x[2]) / (x[0] * x[1] * x[1] * x[2] * x[2] * x[2]);
        MultiVarsFunction f2 = x -> x[0] * x[0] + Math.pow(x[1] - 50, 2) + Math.pow(x[2] + 30, 2) - 100;
        MultiVarsFunction f3 = x -> Math.pow(x[0], 2) - x[1] / 2.0;
                AlternatingVariableDescentMethod avdm = new AlternatingVariableDescentMethod();
        Supplier<double[]> argsSupplier = () -> getArgs(a, b, 2);
        avdm.find(a, b, f3, argsSupplier.get());*/
        AlternatingVariableDescentMethodC m = new AlternatingVariableDescentMethodC();
        m.go(.0001,100, getArgs(1, 20, 2));

    }

    private static double[] getArgs(double a, double b, int n) {
        return DoubleStream.generate(() -> a + (Math.random() * (b - a))).limit(n).toArray();
    }
}
