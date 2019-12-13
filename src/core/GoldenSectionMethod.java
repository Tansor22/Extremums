package core;

public class GoldenSectionMethod extends MultiVarsSupport implements ExtremumFinder {
    double EPS = .0001;
    int k = 1000;
    private final double GOLDEN_SECTION_VALUE = (1 + Math.sqrt(5)) / 2;

    @Override
    public double find(double a, double b, MultiVarsFunction f, int extType, int resultType) {
        double[] args1 = args.clone(), args2 = args.clone();
        double fx1, fx2;
        int steps = 0;
        while (Math.abs(b - a) > EPS) {
            //x1 = b - (b - a) / GOLDEN_SECTION_VALUE;
            //x2 = a + (b - a) / GOLDEN_SECTION_VALUE;
            set(b - (b - a) / GOLDEN_SECTION_VALUE, args1);
            set(a + (b - a) / GOLDEN_SECTION_VALUE, args2);
            fx1 = f.$(args1);
            fx2 = f.$(args2);
            if (extType < 0 ? fx1 >= fx2 : fx1 <= fx2) { // <= - max, >= min

                //a = args1;
                a = get(args1);
            } else {
                //b = args2;
                b = get(args2);
            }
            if (++steps > k)
                break;
        }
        return resultType < 0 ? (a + b) / 2 : f.$((a + b) / 2); // neg - arg, pos - func
    }
}
