import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Pizza Order Manager
 *
 * File holds pizza orders and program computes and displays total price for each order
 *
 * Created by Christie on 5/31/2017.
 */
public class PizzaOrders {

    /**
     * Takes the text file and fills out the map with each item corresponding to it's price.
     *
     * @param filename
     *      input file
     * @param priceMap
     *      map to update
     */
    private static void getPriceMap(String filename, Map<String, Integer> priceMap){
        BufferedReader input;
        try  {
            input = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = input.readLine();

            while (line != null){
                String[] itemAndPrice = line.split(",");
                int price = Integer.parseInt(itemAndPrice[1]);
                priceMap.put(itemAndPrice[0], price);
                line = input.readLine();
            }
            input.close();
        } catch (IOException e){
            System.err.println("Error opening file");
        }

    }

    /**
     * Returns price of one order in the text file
     *
     * @param input
     *      text file containing orders
     * @param sizePriceMap
     *      map containing the prices for the sizes of pizza
     * @param toppingPriceMap
     *      map containing the prices for the topping of pizza
     * @return
     *      the total price of the order
     */
    private static String getOneOrder(BufferedReader input, Map<String, Integer> sizePriceMap, Map<String, Integer> toppingPriceMap){
        int totalPrice = 0, price = 0;
        try {
            String line = input.readLine();
            while (!line.equals("/")){
                if (sizePriceMap.containsKey(line)){
                    price = sizePriceMap.get(line);
                    totalPrice += price;
                } else {
                    price = toppingPriceMap.get(line);
                    totalPrice += price;
                }
                line = input.readLine();
            }

        } catch (IOException e){
            System.err.println("Error reading file");
        }

        /*
         * Convert price to a double
         */
        DecimalFormat df = new DecimalFormat("0.00");
        double totalPriceDb = (double)totalPrice;
        totalPriceDb /= 100;
        String priceStr = df.format(totalPriceDb);
        return priceStr;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader orders = new BufferedReader(new FileReader("data/orders.txt"));
        Map <String, Integer> sizeMenu = new HashMap<>();
        Map <String, Integer> toppingMenu = new HashMap<>();
        int orderNumber = 1;

        /*
         * Updates maps with prices according to the size and toppings
         */
        getPriceMap("data/sizes.txt", sizeMenu);
        getPriceMap("data/toppings.txt", toppingMenu);

        /*
         * Output header for report
         */
        System.out.println();
        System.out.println("Order");
        System.out.println("Number Price");
        System.out.println("------ ------");

        /*
         * Process orders
         */
        String line = orders.readLine();
        while (line.equals("/") && orders.ready()){
            String price = getOneOrder(orders, sizeMenu, toppingMenu);
            System.out.print(orderNumber + "      ");
            System.out.println(price);
            System.out.println();
            orderNumber++;
        }

        orders.close();

    }
}
