import java.util.*;

public class City  implements Visitable{
    private String name;
  private List<Location> lista=new ArrayList<>();

    public Location getLista(int n) {
        return lista.get(n);
    }
    public List<Location> getLocations() {
        return lista;
    }


    public void addLista(int index,Location a) {
        this.lista.add(index,a);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void visitable(){
        List<Location> aux=new ArrayList<>();
        for(Location iterator : lista){
            //not payable and visitable
            if(!(iterator instanceof Payable) && (iterator instanceof Visitable))
            {
                // add the location we found
                aux.add(iterator);
            }
        }

        Collections.sort(aux, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                if(o1.getOpeningTime()== null)
                    return 0;
                if(o2.getOpeningTime()==null)
                    return 0;
                return o1.getOpeningTime().compareTo(o2.getOpeningTime());
            }
        });
        for(Location iterator : aux)
        {
            System.out.println(iterator.getName());
        }
    }

    public int[][] createGraphMatrix(){
        int[][] matrix=new int[lista.size()][lista.size()];
        for(Location location : lista){
           var aux=location.getMap();
            for(Location location1 : lista)
            {
                matrix[lista.indexOf(location)][lista.indexOf(location1)]=aux.getOrDefault(location1,10000);
            }
        }
        int V=lista.size();
        for (int k = 0; k < V; k++)
        {
            for (int i = 0; i < V; i++)
            {

                for (int j = 0; j < V; j++)
                {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
        return matrix;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", lista=" + lista +
                '}';
    }
}
