public class Main {
    public static void main(String[] args) {
        City iasi=new City();
        iasi.setName("Iasi");
        Hotel Unirea=new Hotel("Unirea");
        Museum muzeuIstorie=new Museum("muzeuIstorie");
        Museum arteAplicate=new Museum("arteAplicate");
        Church mitropolie=new Church("mitropolie");
        Church bisericaCatolica=new Church("bisericaCatolica");
        iasi.addLista(0,Unirea);
        iasi.addLista(1,muzeuIstorie);
        iasi.addLista(2,arteAplicate);
        iasi.addLista(3,mitropolie);
        iasi.addLista(4,bisericaCatolica);
        Restaurant oscar=new Restaurant("oscar");
        iasi.addLista(5,oscar);
        Unirea.addCost(muzeuIstorie,10);
        Unirea.addCost(arteAplicate,50);
        muzeuIstorie.addCost(arteAplicate,20);
        arteAplicate.addCost(muzeuIstorie,20);
        muzeuIstorie.addCost(mitropolie,20);
        muzeuIstorie.addCost(bisericaCatolica,10);
        arteAplicate.addCost(mitropolie,20);
        mitropolie.addCost(bisericaCatolica,30);
        mitropolie.addCost(oscar,10);
        bisericaCatolica.addCost(oscar,20);
        System.out.println(iasi);
    }
}
