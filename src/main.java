public class main {

    static int SumDigits(int n){
        int sum=0;
            while (n != 0) {
                sum = sum + n % 10;
                n = n / 10;
        }
          if(sum>=10)
              return SumDigits(sum);
          else return sum;
    }
    public static void main(String[] args) {
        System.out.println("Hello World\n");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for (int i = 0; i < 10; i++) {
            System.out.print(languages[i]);
            System.out.print(" ");
        }
        System.out.println("\n");

        int n = (int) (Math.random() * 1_000_000);
        System.out.printf("n este =%d\n", n);
        n = n * 3;
        System.out.printf("n inainte de suma %d\n", n);
        String binaryString = "10101";
        int decimal = Integer.parseInt(binaryString, 2);
        n = n + decimal;
        System.out.printf("n dupa suma %d\n", n);
        binaryString = "FF";
        decimal = Integer.parseInt(binaryString, 16);
        n = n+decimal;
        System.out.printf("n dupa suma %d\n", n);
        n=n*6;
        int result=SumDigits(n);
        System.out.printf("suma cif este %d\n",result);
        System.out.printf("Willy-nilly, this semester I will learn %s", languages[result]);
    }
}
