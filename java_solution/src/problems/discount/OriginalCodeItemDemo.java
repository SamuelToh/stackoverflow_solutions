package problems.discount;

import java.util.Scanner;

/**
 * Original code proposed by caller. Note: This is not a functional piece of code, it has plenty of errors.
 */
public class OriginalCodeItemDemo {
    public static void main(String[] args) {
        Scanner sc1= new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        Scanner sc3=new Scanner(System.in);

        Item[] item= new Item[5];
        for(int i=0;i<item.length;i++)
        {
            System.out.println("Enter Item Id");
            int itemId=sc1.nextInt();
            System.out.println("Enter Item name");
            String itemName=sc2.nextLine();
            System.out.println("Enter Item price");
            double itemPrice=sc3.nextDouble();
            System.out.println("Enter item Discount");
            double itemDiscount=sc3.nextDouble();
            item[i]= new Item(itemId,itemName,itemPrice,itemDiscount);
        }

        double minValue= getLeastPriceItem(item);
        System.out.println("Least item price "+minValue);
    }

    public static double getLeastPriceItem(Item[] item)
    {
        double min;
        min=item[0].getItemPrice();
        for(int i=1;i<item.length;i++)
        {
            if(item[i].getItemPrice()<min)
            {
                min=item[i].getItemPrice();
            }
        }
        return min;
    }
}

class OriginalCodeItem
{
    private int itemId;
    private String itemName;
    private double itemPrice;
    private double itemDiscount;
    public OriginalCodeItem(int itemId, String itemName, double itemPrice,double itemDiscount) {
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