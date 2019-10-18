package lab1;

import java.util.List;

//Товар
class Product{
    String name;
    private List<Stock> stocks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    void addStock (Stock stock){
        if (!stocks.contains(stock)) {
            stocks.add(stock);
        }
    }
    
}