public class Art {
    // draw circle of center x and y and radius r
    private static void circle(double x, double y, double r) {
        // colour generator
        // equally likely 0 or 1
        int randomBit = StdRandom.uniformInt(2);

        // pick circle color
        if (randomBit == 0)
            StdDraw.setPenColor(StdDraw.RED);
        else
            StdDraw.setPenColor(StdDraw.BLUE);

        // draw circle
        StdDraw.filledCircle(x, y, r);

        // draws gray outline around each circle
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(x, y, r);
    }

    // recursive function
    private static void matrix(int n, double x, double y, double r) {
        // base case
        if (n < 1) return;
        circle(x, y, r);
        // recursive function

        matrix(n - 1, x + r, y, r / 2.0);
        matrix(n - 1, x, y + r, r / 2.0);
        matrix(n - 1, x - r, y, r / 2.0);
        matrix(n - 1, x, y - r, r / 2.0);
    }

    public static void main(String[] args) {
        // command-line arguments
        int n = Integer.parseInt(args[0]);

        // call recursive function
        matrix(n, 0.5, 0.5, 0.25);
    }


}

