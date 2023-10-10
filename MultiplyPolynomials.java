/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplypolynomials;

/**
 *
 * @author heten
 */
import java.text.*;
import java.math.*;
    public class MultiplyPolynomials {
    


static void DiffTable(double x[], double y[][], int a)
{
    for (int i = 1; i < a; i++) {
        for (int j = 0; j < a - i; j++) {
            y[j][i] = (y[j][i - 1] - y[j + 1]
                        [i - 1]) / (x[j] - x[i + j]);
        }
    }
}


static double product(int i,double value, double x[])
{
   double number = 1;
    for (int j = 0; j < i; j++) {
        number = number * (value - x[j]);
    }
    return number;
}
 
//p(x)= -56.0 + 58.493 (x - -1.0) + -22.4445 (x - -1.0) (x - -0.333) + 1.1618 (x - -1.0) (x - -0.3333) (x - 0.0) +2 (x - -1.0) (x - -0.3333333333333333) (x - 0.0) (x - 1.414)
static double Formula(double value, double x[],
                double y[][], int n)
{
   double sum = y[0][0];
 
    for (int i = 1; i < n; i++) {
    sum = sum + (product(i, value, x) * y[0][i]);
    }
    return sum;
}
 

        
            static void printPoly(int poly[], int n) 
    {
        for (int i = 0; i < n; i++) 
        {
            System.out.print(poly[i]);
            if (i != 0) 
            {
                System.out.print("x^" + i);
            }
            if (i != n - 1) 
            {
                System.out.print(" + ");
            }
        }
    }
            static void print(double y[][],int n)
{
    DecimalFormat df = new DecimalFormat("#.####");
    df.setRoundingMode(RoundingMode.HALF_UP);
     
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i; j++) {
            String string = df.format(y[i][j]);
            System.out.print(string+"\t ");
        }
        System.out.println("");
    }
}

            
               static void multiplyfirst(int firstPolynomial[],
            int m, int n, Double x) {
        int[] prod = new int[m + n - 1];

        // Initialize the product polynomial
        for (int i = 0; i < m + n - 1; i++) {
            prod[i] = 0;
        }
        for (int i = 0; i < m; i++) {
          
                prod[i] += firstPolynomial[i];   
        }
        double result = 0;
        for (int i = prod.length - 1; i >= 0; i--) {
            result += prod[i] * (Math.pow(x, i));
        }
        String newResult = String.format("%,.3f", result);
        System.out.println(newResult);

    }             
               static void multiplysecond(int secondPolynomial[],
            int m, int n, Double x) {
        int[] prod = new int[m + n - 1];

        // Initialize the product polynomial
        for (int i = 0; i < m + n - 1; i++) {
            prod[i] = 0;
        }

        for (int i = 0; i < m; i++) {

         
                prod[i] += secondPolynomial[i];
            
        }

        double result = 0;
        for (int i = prod.length - 1; i >= 0; i--) {
            result += prod[i] * (Math.pow(x, i));
        }

        String newResult = String.format("%,.3f", result);
        System.out.println(newResult);

    }
               
 static void multiply(int firstPolynomial[], int secondPolynomial[],
            int m, int n, Double x) {
        int[] product = new int[m + n - 1];

        // Initialize the product polynomial
        for (int i = 0; i < m + n - 1; i++) {
            product[i] = 0;
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                product[i + j] += firstPolynomial[i] * secondPolynomial[j];
            }
        }

        double result = 0;
        for (int i = product.length - 1; i >= 0; i--) {
            result += product[i] * (Math.pow(x, i));
        }

        String newResult = String.format("%,.3f", result);
        System.out.println(newResult);

    }

    public static void main(String[] args) {
                 int line= 5;
    double number;
        int firstPolynomial[] = { -5, 3, 1 };

        int secondPolynomial[] = { 1, -5, 2 };
        int m = firstPolynomial.length;
        int n = secondPolynomial.length;
          
          System.out.println("First polynomial is x");
          printPoly(firstPolynomial, n);
        System.out.println("\nSecond polynomial is x");
        printPoly(secondPolynomial, n);
        
            System.out.println("\nEvaluating p(x)");
           multiplyfirst(firstPolynomial,m, n, -1.0);
           multiplyfirst(firstPolynomial,m, n,  -0.33333);
           multiplyfirst(firstPolynomial,m, n, 0.0);
           multiplyfirst(firstPolynomial,m, n, Math.sqrt(2));
           multiplyfirst(firstPolynomial,m, n, 1.0);
           System.out.println("Evaluating q(x)");
         multiplyfirst(secondPolynomial,m, n, -1.0);
           multiplyfirst(secondPolynomial,m, n,  -0.33333);
           multiplyfirst(secondPolynomial,m, n, 0.0);
           multiplyfirst(secondPolynomial,m, n, Math.sqrt(2));
           multiplyfirst(secondPolynomial,m, n, 1.0);      
         System.out.println("\nOperate");
        multiply(firstPolynomial, secondPolynomial, m, n, -1.0);  
        multiply(firstPolynomial, secondPolynomial, m, n, -0.33333);
multiply(firstPolynomial, secondPolynomial, m, n, 0.0);
        multiply(firstPolynomial, secondPolynomial, m, n, Math.sqrt(2));
        multiply(firstPolynomial, secondPolynomial, m, n, 1.0);
        
        System.out.println("\nDecompress:");

    double y[][]=new double[20][20];
   double x[] = { -1, -0.3333, 0,0.707, 1 };
    y[0][0] = -56;
    y[1][0] = -17.01234;
    y[2][0] = -5;
    y[3][0] = -2.5736;
    y[4][0] = 2;
   DiffTable(x, y, line);

    print(y,line);
     number = 1;
 
    // printing the value
   
     
    System.out.println("\nnumber 2 is  "+" is "+Formula(number, x, y, n));
 
    }
}
