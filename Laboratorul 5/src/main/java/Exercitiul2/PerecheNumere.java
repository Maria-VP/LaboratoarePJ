package Exercitiul2;

public class PerecheNumere {
    private int number1;
    private int number2;

    public PerecheNumere(){}

    public PerecheNumere(int number1, int number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    public int getNumber1(){
        return number1;
    }

    public int getNumber2(){
        return number2;
    }

    public void setNumber1(int n){
        number1 = n;
    }

    public void setNumber2(int n){
        number2 = n;
    }

    public boolean suntConsecutiveFibonacci() {
        int a = 0, b = 1;
        while (b < number2) {
            int aux = a + b;
            a = b;
            b = aux;
            if (a == number1 && b == number2) {
                return true;
            }
        }
        return false;
    }

    private int cmmdc(int a, int b) {
        while (b != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    public int celMicMultipluComun() {
        return (number1 * number2) / cmmdc(number1, number2);
    }

    private int sumaCifrelor(int n) {
        int suma = 0;
        while (n > 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    public boolean auSumaCifrelorEgala() {
        return sumaCifrelor(number1) == sumaCifrelor(number2);
    }

    private int numaraCifrePare(int n) {
        int count = 0;
        while (n > 0) {
            if ((n % 10) % 2 == 0) count++;
            n /= 10;
        }
        return count;
    }

    public boolean auAcelasiNumarCifrePare() {
        return numaraCifrePare(number1) == numaraCifrePare(number2);
    }

    @Override
    public String toString() {
        return "(" + number1 + "; " + number2 + ")";
    }
}
