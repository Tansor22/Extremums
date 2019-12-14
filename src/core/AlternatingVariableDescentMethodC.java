package core;

public class AlternatingVariableDescentMethodC {
    private double f(double ... x){return  Math.pow(x[0], 2) - x[1] / 2.0;}

    private double goldenSection(int var_index, double eps, double a, double b, int max_steps_count, double... vars)
    {
        double res = 0.0;
        double phi = (1 + Math.sqrt(5.0)) / 2.0;
        double A = 0.0f, B = 0.0f;
        double x1 = a + phi * (b - a), x2 = b - phi * (b - a);

        int step = 0;

        while((b - a > eps))
        {
            x1 = b - ((b - a) / phi);
            vars[var_index] = x1;
            A = f(vars);
            x2 = a + ((b - a) / phi);
            vars[var_index] = x2;
            B = f(vars);
            if(A > B)
                a = x1;
            else
                b = x2;

            step++;
            if(step > max_steps_count)
                break;
        }

        res = (a + b) / 2;
        return res;
    }
    public void go(double eps, int max_steps_count, double... vars)
    {
        double B = f(vars), A = 0;
        boolean was_counted = false;
        int stpes_ellapsed = 0;
        double delta = 0.0;
        for(int i = 0; i < max_steps_count; i++){
            A = B;

            for(int var_index = 0; var_index < vars.length; var_index++)
                vars[var_index] = goldenSection(var_index, eps, -5000, 5000, max_steps_count, vars);

            B = f(vars);

            delta = Math.abs(A - B);

            if(delta <= eps)
            {
                stpes_ellapsed = i + 1;
                was_counted = true;
                break;
            }
        }

        System.out.println("Результат поиска минимума функции exp(x1 + x2 + x3) / (x1 * x2^2 * x3^3)");

        if(!was_counted)
            System.out.println("За максимально указанное количество шагов ( " + max_steps_count + " ) минимум не был посчитан.");
        else {
            System.out.println("Количество итераций: " + stpes_ellapsed);
            System.out.println("Погрешность: " + delta);
        }

        System.out.print("\nТочка: X(");
        for(int i = 0; i < vars.length; i++){
            System.out.print(", ");

        }

        System.out.println("\b\b" + ")");
        System.out.println("Значение фукнции f(X): " + f(vars));
    }
}
