package com.sxg;

/**
 * @author foreversxg
 * create in 2021/6/22
 */
public class VectorCalculate {

    public static void main(String[] args) {
        double[] vector1 = new double[]{2.0, 3.1, 4.5, 3.1};
        double[] vector2 = new double[]{2.0, 9.1, 4.5, 4.1};

        double sum = 0.0;
        Double v1Len = 0.0;
        Double v2Len = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            sum += vector1[i] * vector2[i];
            v1Len += vector1[i] * vector1[i];
        }
        for (int k = 0; k < vector2.length; k++) {
            v2Len += vector2[k] * vector2[k];
        }
        // Math.sqrt 开平方根
        System.out.println("v1,v2:" + sum / (Math.sqrt(v1Len) * Math.sqrt(v2Len)));

        double[] vector3 = new double[]{100.0, 7.1, 4.5, 4.1};
        double[] vector4 = new double[]{10.0, 7.1, 4.5, 900.1};
        Double v3Len = 0.0;
        Double v4Len = 0.0;
        for (int i = 0; i < vector3.length; i++) {
            sum += vector3[i] * vector4[i];
            v3Len += vector3[i] * vector3[i];
        }
        for (int k = 0; k < vector4.length; k++) {
            v4Len += vector4[k] * vector4[k];
        }
        System.out.println("v3,v4:" + sum / (Math.sqrt(v3Len) * Math.sqrt(v4Len)));
    }
}
