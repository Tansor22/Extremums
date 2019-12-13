package app;

import core.ExtremumFinder;
import core.GoldenSectionMethod;
import core.MultiVarsFunction;

import java.util.stream.DoubleStream;

import static java.lang.Math.*;
import static core.ExtremumLogicConstants.*;

public class GoldenSectionMethodDemo {

    public static void main(String[] args) {
        double a = 5.7;
        double b = 8.0;
        MultiVarsFunction f = x -> log(1 + x[0] * x[0] - cos(x[0])) - exp(sin(PI * x[0]));
        ExtremumFinder ef = new GoldenSectionMethod();
        double min = ef.find(a, b, f, MIN, FUNC);
        System.out.println("Min = " + min);
        double max = ef.find(a, b, f, MAX, FUNC);
        System.out.println("Max = " + max);
    }
}
