package org.example;

public class Sum {
    public static double calculateSum(int a, int b, int n, int m) {
        double S = 0;

        if (a > n || b > m) {
            return S;
        }

        for (float i = a; i <= n; i++) {
            for (float j = b; j <= m; j++) {
                S += (double) (i % j) / (i + 2);
            }
        }

        return S;
    }
}
