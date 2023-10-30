import java.util.Scanner;

public class KalkulatorSederhana {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double angka1, angka2;
        char operator;

        System.out.print("Masukkan angka pertama: ");
        angka1 = input.nextDouble();

        System.out.print("Masukkan operator (+, -, *, /): ");
        operator = input.next().charAt(0);

        System.out.print("Masukkan angka kedua: ");
        angka2 = input.nextDouble();

        double hasil;

        switch (operator) {
            case '+':
                hasil = pertambahan(angka1, angka2);
                break;
            case '-':
                hasil = pengurangan(angka1, angka2);
                break;
            case '*':
                hasil = perkalian(angka1, angka2);
                break;
            case '/':
                if (angka2 != 0) {
                    hasil = pembagian(angka1, angka2);
                } else {
                    System.out.println("Error: Tidak bisa melakukan pembagian oleh nol.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Operator tidak valid.");
                return;
        }

        System.out.println("Hasil: " + hasil);
    }

    public static double pertambahan(double a, double b){
        return a+b;
    }
    public static double perkalian(double a, double b){
        return a*b;
    }
    public static double pengurangan(double a, double b){
        return a-b;
    }
    public static double pembagian(double a, double b){
        return a-b;
    }

}
