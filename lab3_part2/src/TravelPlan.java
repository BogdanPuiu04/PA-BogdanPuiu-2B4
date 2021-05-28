import java.util.List;

public class TravelPlan {
    private City city;

    public TravelPlan(City city) {
        this.city = city;
    }

    public void dailyTravelPlan(int V, int[][] graph, int days, int minutesNumber, Location start) {
        int[] vizitat = new int[V];
        for (int i = 0; i < V; i++)
            vizitat[i] = 0;
        vizitat[city.getLocations().indexOf(start)] = 1;
        Location location = start;
        int remaining = V - 1;
        int index = -1;
        int minutes = minutesNumber;
        for (int i = 0; i < days; i++) {
            location = start;
            System.out.println("day: " + (i + 1));
            System.out.println(location);
            if (remaining == 0) {
                break;
            }
            minutes = minutesNumber;
            int ok = 1;
            while (minutes > 0) {
                ok = 1;
                Location aux = null;
                for (int j = 0; j < V; j++) {
                    if (graph[city.getLocations().indexOf(location)][j] != 10000 && vizitat[j] == 0) {
                        aux = city.getLocations().get(j);
                        index = j;
                        vizitat[j] = 1;
                        break;
                    }
                }
                if (aux == null) {
                    ok = 0;
                    System.out.println(start);
                    break;
                }
                System.out.println(aux);
                minutes = minutes - graph[city.getLocations().indexOf(location)][index];
                location = aux;
                remaining--;
            }
            if (ok == 1) {
                System.out.println(start);
            }
        }
    }
}



