public class Problem {
    int[][] cost;
    Source[] SourceVector;
    Destination[] DestinationVector;


    public void setProblem(int[][] cost, int number) {
        SourceVector = new Source[number];
        DestinationVector = new Destination[number];
        this.cost = new int[3][3];
        for (int i = 0; i < number; i++)
            for (int j = 0; j < number; j++)
                this.cost[i][j] = cost[i][j];
    }

    public Source getSourceVect(int value) {
        return SourceVector[value];
    }

    public Destination getDestinationVect(int value) {
        return DestinationVector[value];
    }

    public Problem() {
    }

    public void matrixSetter(Source[] SourceVect, Destination[] DestinationVect, int size) {
        for (int i = 0; i < size; i++) {
            this.SourceVector[i] = SourceVect[i];
            this.DestinationVector[i] = DestinationVect[i];
        }
    }

    public void printMatrix() {

        System.out.printf("%s ", SourceVector[0].name);
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", cost[0][i]);
        System.out.printf("%d", SourceVector[0].supply);
        System.out.println();
        System.out.printf("%s ", SourceVector[1].name);
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", cost[1][i]);
        System.out.printf("%d", SourceVector[1].supply);
        System.out.println();
        System.out.printf("%s ", SourceVector[2].name);
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", cost[2][i]);
        System.out.printf("%d", SourceVector[2].supply);
        System.out.println();
        System.out.print("D:");
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", DestinationVector[i].demand);

    }

    public int[][] getCost() {
        return cost;
    }
}
