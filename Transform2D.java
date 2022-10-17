public class Transform2D {
    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        int n = array.length;
        double[] cop = new double[n];
        for (int i = 0; i < n; i++) {
            cop[i] = array[i];
        }
        return cop;
    }

    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            x[i] = x[i] * alpha;
            y[i] = y[i] * alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            x[i] = x[i] + dx;
            y[i] = y[i] + dy;
        }
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        int n = x.length;
        double beta = Math.toRadians(theta);
        double[] x2 = copy(x);
        double[] y2 = copy(y);
        for (int i = 0; i < n; i++) {
            x[i] = (x2[i] * Math.cos(beta)) - (y2[i] * Math.sin(beta));
            y[i] = (y2[i] * Math.cos(beta)) + (x2[i] * Math.sin(beta));
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        // Create original polygon
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };

        // draw polygon
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(x, y);

        // make a copy of x and y
        double[] x2 = copy(x);
        double[] y2 = copy(y);

        // scale the polygon using x2 and y2
        scale(x2, y2, 3.0);
        // draw new polygon
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x2, y2);

        // translate the polygon
        translate(x2, y2, 1.0, -2.0);
        // draw new polygon
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.polygon(x2, y2);

        // rotate the polygon
        rotate(x2, y2, 45.0);
        // draw new polygon
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.polygon(x2, y2);
    }

}


