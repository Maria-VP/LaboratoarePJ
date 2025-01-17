package Exercitiul5;

public class Fibonacci {
    public void sirulFiboncci(int firstNo, int secondNo, int randomNo)
    {
        if(randomNo > 0) {
            System.out.print(firstNo + " " + secondNo + " ");

            int previousNo, currentNo, penultimateNo;
            previousNo = firstNo + secondNo;

            System.out.print(previousNo + " ");

            penultimateNo = secondNo;

            while (previousNo <= randomNo) {
                currentNo = previousNo + penultimateNo;

                System.out.print(currentNo + " ");

                penultimateNo = previousNo;
                previousNo = currentNo;
            }
        }
        else
            System.out.println("Numarul trebuie sa fie mai mare decat 0.");
    }
}
