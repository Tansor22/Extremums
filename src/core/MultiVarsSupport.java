package core;

public class MultiVarsSupport {

    // setup for single var function
    int n = 1;
    double[] args = new double[n];
    int currentIndex = 0;
    // in order to calculate proper need, change currentIndex value before finding an ext and set n to number of vars
    void set(double value, double[] args) {
            args[currentIndex] = value;
    }
    double get(double[] args) {
        return args[currentIndex];
    }


}
