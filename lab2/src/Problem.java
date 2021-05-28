import java.util.Random;

public class Problem {
    int[][] cost;
    Source[] sourceVector;
    Destination[] destinationVector;


    public void setProblem(int[][] cost ,int n,int m) {
        sourceVector = new Source[n];
        destinationVector = new Destination[m];
        this.cost = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                this.cost[i][j] = cost[i][j];
    }

    public Source getSourceVect(int value) {
        return sourceVector[value];
    }

    public Destination getDestinationVect(int value) {
        return destinationVector[value];
    }

    public void randomProblem(int n , int m){
        sourceVector = new Source[n];
        destinationVector = new Destination[m];
        cost=new int[n][m];
        Random random =new Random();
        for(int i=0;i<n;i++){
            sourceVector[i]=new Source("S"+i,random.nextInt(50)+10,random.nextInt(2));
        }
        for(int i=0;i<m;i++){
            destinationVector[i]=new Destination("D"+i,random.nextInt(20)+10);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cost[i][j]=random.nextInt(10)+1;
            }
        }
    }
    public Problem() {
    }

    public void matrixSetter(Source[] sourceVect, Destination[] destinationVect) {
       sourceVector=sourceVect;
       destinationVector=destinationVect;
    }

    public void printMatrix() {

        System.out.printf("%s ", sourceVector[0].name);
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", cost[0][i]);
        System.out.printf("%d", sourceVector[0].supply);
        System.out.println();
        System.out.printf("%s ", sourceVector[1].name);
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", cost[1][i]);
        System.out.printf("%d", sourceVector[1].supply);
        System.out.println();
        System.out.printf("%s ", sourceVector[2].name);
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", cost[2][i]);
        System.out.printf("%d", sourceVector[2].supply);
        System.out.println();
        System.out.print("D:");
        for (int i = 0; i < 3; i++)
            System.out.printf("%d ", destinationVector[i].demand);

    }

    public Source[] getSourceVector() {
        return sourceVector;
    }

    public Destination[] getDestinationVector() {
        return destinationVector;
    }

    public int[][] getCost() {
        return cost;
    }
}
