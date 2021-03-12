import java.util.*;

public class City  implements Visitable{
    private String name;
  private List<Location> lista=new ArrayList<>();

    public Location getLista(int n) {
        return lista.get(n);
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

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", lista=" + lista +
                '}';
    }
}
