public class Main {
    public static void main(String[] args) {

        Source S1 = new Source("S1", 10, 1);
        Source S2 = new Source("S2", 35, 0);
        Source S3 = new Source("S3", 25, 0);
        Destination D1 = new Destination("D1", 20);
        Destination D2 = new Destination("D2", 25);
        Destination D3 = new Destination("D3", 25);
        Problem problem = new Problem();
        int array[][] = {{2, 3, 1}, {5, 4, 8}, {5, 6, 8}};
        problem.setProblem(array, 3);
        Source[] sourceVect = {S1, S2, S3};
        Destination[] destinationVect = {D1, D2, D3};
        problem.matrixSetter(sourceVect, destinationVect, 3);
        problem.printMatrix();
        System.out.println();
        System.out.printf("%s", sourceVect[0].toString());
    }
}
