public class Sierpinski {
    // Height of an equilateral triangle with the specified side length.
    public static double height(double length) {
        // calculate height using the formula
        double height = length * (Math.sqrt(3) / 2);
        return height;
    }

    // Draws a filled equilateral triangle with the specified side length
    // whose bottom vertex is (x, y).
    public static void filledTriangle(double x, double y, double length) {
        // calculate x and y coordinates
        double a = x - (length / 2);
        double b = y + height(length);
        double c = x + (length / 2);
        double d = y + height(length);

        // Create original triangle
        double[] xd = { a, c, x };
        double[] yd = { b, d, y };

        // draw triangle
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledPolygon(xd, yd);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled
    // triangle has the specified side length and bottom vertex (x, y).
    public static void sierpinski(int n, double x, double y, double length) {
        // base case
        if (n < 1) return;

        // call the drawing function
        filledTriangle(x, y, length);

        // call the recursive function three times
        sierpinski(n - 1, x - (length / 2), y, length / 2);
        sierpinski(n - 1, x, y + height(length), length / 2);
        sierpinski(n - 1, x + (length / 2), y, length / 2);
    }

    // Takes an integer command-line argument n;
    // draws the outline of an upwards equilateral triangle of length 1
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0);
    // and draws a Sierpinski triangle of order n that fits inside the outline.
    public static void main(String[] args) {
        // call function height
        // double len = height(2.0);
        //  System.out.print(len);

        // call function filledTriangle
        // filledTriangle(1.0, 3.0, 2.0);
        //  filledTriangle(4.0, 3.0, 3.0);
        //  filledTriangle(6.0, 1.0, 7.0);

        // call function sierpinski
        // integer command-line argument
        int n = Integer.parseInt(args[0]);
        // outline equilateral triangle
        double x = 0.5;
        double y = height(1.0);
        double[] px = { 0, 1, x };
        double[] py = { 0, 0, y };
        StdDraw.polygon(px, py);

        // sierpinski drawing
        sierpinski(n, 0.5, 0.0, 0.5);
    }

}






