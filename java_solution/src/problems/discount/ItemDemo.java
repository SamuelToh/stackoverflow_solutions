package problems.discount;

/**
 * Proposed solution.
 * - Fixed caller's algorithm for getting the least price item
 * - Recommended user to return the cheapest item by object rather than just a double value. (more elegant approach)
 * - Fixed caller's wrong loop logic in getLeastPriceItem()
 *
 * ** Note: This issue sounds like a university school project, caller is a java newbie therefore no fancy java8 syntax
 *
 * Code refractoring is not within the scope of this issue.
 */
public class ItemDemo {
    public static void main(String[] args) {

        Item[] item= new Item[5];
        item[0] = new Item(1, "a", 100.0, 20.0);
        item[1] = new Item(2, "b", 80.0, 30.0);
        item[2] = new Item(3, "c", 300.0, 40.0);
        item[3] = new Item(4, "d", 400.0, 390.0);
        item[4] = new Item(5, "e", 500.0, 60.0);

        Item cheapest = getLeastPriceItem(item);
        System.out.println("Least item price: "+ cheapest.getItemPrice() + " with discount of: " + cheapest.getItemDiscount());
    }

    public static Item getLeastPriceItem(Item[] item)
    {
        double currMin = Double.MAX_VALUE;
        Item cheapestItem = null;
        for(int i=0;i<item.length;i++)
        {
            double afterDiscount = item[i].getItemPrice() - item[i].getItemDiscount();
            if(afterDiscount < currMin)
            {
                currMin = afterDiscount;
                cheapestItem = item[i];
            }
        }
        return cheapestItem;
    }
}
class Item
{
    private int itemId;
    private String itemName;
    private double itemPrice;
    private double itemDiscount;
    public Item(int itemId, String itemName, double itemPrice,double itemDiscount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDiscount = itemDiscount;
    }
    public int getItemId() {
        return itemId;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    public void getItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public double getItemDiscount() {
        return itemDiscount;
    }
    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }
    public String getName()
    {
        return itemName;
    }

}