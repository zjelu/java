package mylib;

public class Matrix { // 类名建议首字母大写

    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) return -1.0;

        double sum = 0.0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y[i];
        }
        return sum;
    }

    public static double[][] multiply(double[][] A, double[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("矩阵维度不匹配，无法相乘");
        }

        double[][] C = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double sum = 0.0;
                for (int k = 0; k < colsA; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }

    public static double[][] transpose(double[][] x) {
        int rowsx = x.length;
        int colsx = x[0].length;
        double[][] C = new double[colsx][rowsx]; // 修正：使用colsx和rowsx
        for (int i = 0; i < rowsx; i++) {
            for (int j = 0; j < colsx; j++) {
                C[j][i] = x[i][j];
            }
        }
        return C;
    }

    public static double[] mult(double[][] a, double[] x) {
        int rowsa = a.length;
        int colsa = a[0].length;
        int length_x = x.length; // 重命名避免混淆

        if (colsa != length_x) {
            return null;
        }

        double[] C = new double[rowsa]; // 修正：结果长度应该是矩阵的行数
        for (int i = 0; i < rowsa; i++) {
            for (int j = 0; j < colsa; j++) {
                C[i] += a[i][j] * x[j]; // 简化写法
            }
        }
        return C;
    }

    public static double[] mult(double[] y, double[][] a) { // 修正：移除方括号
        int vectorLength = y.length; // 修正：使用一致的变量名
        int rows = a.length;
        int cols = a[0].length;

        if (vectorLength != rows) {
            throw new IllegalArgumentException("向量长度必须等于矩阵行数，且向量为行向量！当前向量长度: " +
                    vectorLength + ", 矩阵行数: " + rows);
        }

        double[] result = new double[cols];

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                result[j] += y[i] * a[i][j];
            }
        }
        return result;
    }
}
