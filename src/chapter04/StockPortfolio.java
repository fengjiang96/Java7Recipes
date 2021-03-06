package chapter04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

/**
 * The example for this recipe is the StockPortfolio class. Internally, StockPortfolio manages a collection of Stock
 * objects. We would like users of our class to be able to treat StockPortfolio objects as iterable objects using a
 * foreach statement.
 */
public class StockPortfolio implements Iterable<Stock> {
    Map<String, Stock> portfolio = new HashMap<>();

    public void add(Stock stock) {
        portfolio.put(stock.getSymbol(), stock);
    }

    public void add(List<Stock> stocks) {
        for (Stock s : stocks)
            portfolio.put(s.getSymbol(), s);
    }

    @Override
    public Iterator<Stock> iterator() {
        return portfolio.values().iterator();
    }

    public static void main(String[] args) {
        StockPortfolio myPortfolio = new StockPortfolio();
        myPortfolio.add(new Stock("ORCL", "Oracle", 500.0));
        myPortfolio.add(new Stock("AAPL", "Apple", 200.0));
        myPortfolio.add(new Stock("GOOG", "Google", 100.0));
        myPortfolio.add(new Stock("IBM", "IBM", 50.0));
        myPortfolio.add(new Stock("MCD", "McDonalds", 300.0));

        // foreach loop (uses Iterator returned from iterator() method)
        for (Stock stock : myPortfolio) {
            System.out.println(stock);
        }
    }
}
