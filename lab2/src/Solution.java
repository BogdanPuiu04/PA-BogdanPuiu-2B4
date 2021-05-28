import java.util.ArrayList;
import java.util.List;

public class Solution {

    Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
    }

    public void solution() {
        int totalCost = 0;
        List<Price> priceList = new ArrayList<>();
        for (int i = 0; i < problem.getSourceVector().length; i++) {
            for (int j = 0; j < problem.getDestinationVector().length; j++) {
                priceList.add(new Price(problem.getSourceVector()[i], problem.getDestinationVector()[j], problem.getCost()[i][j]));
            }
        }
        priceList.sort(Price::compareTo);
        //System.out.println(priceList);
        for (Price aux : priceList) {
            if (aux.destination.demand !=0 && aux.source.supply != 0){
                if (aux.destination.demand > aux.source.supply) {
                    System.out.println(aux.source.name +"  -> " + aux.destination.name + "  " + aux.source.supply);

                    totalCost += aux.source.supply * aux.price;
                    aux.destination.setDemand(aux.destination.demand - aux.source.supply);
                    aux.source.supply = 0;
                } else {
                    System.out.println(aux.source.name +" -> " + aux.destination.name + "  " + aux.destination.demand);
                    totalCost += aux.destination.demand * aux.price;
                    aux.source.supply -=aux.destination.demand;
                    aux.destination.demand = 0;
                }
            }
        }
            System.out.println("TOTAL COST IS :  "+totalCost);
    }
}
