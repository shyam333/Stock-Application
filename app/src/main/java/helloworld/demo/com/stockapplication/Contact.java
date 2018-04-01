package helloworld.demo.com.stockapplication;



    public class Contact {
    public String ID;
    public String ItemNo;
    public String Item;
    public String Variant;
    public String Inventory;
    public String Price1;
    public String Price2;


    public Contact(String ItemNo) {
     this.ItemNo = ItemNo;
    }

    public Contact() {

    }

    public Contact(String ID, String ItemNo, String Item, String Variant, String Inventory, String Price1, String  Price2 ) {
        this.ID = ID;
        this.ItemNo = ItemNo;
        this.Item = Item;
        this.Variant = Variant;
        this.Inventory = Inventory;
        this.Price1 = Price1;
        this.Price2 = Price2;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getItemNo() {
        return ItemNo;
    }

    public void setItemNo(String itemNo) {
        ItemNo = itemNo;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getVariant() {
        return Variant;
    }

    public void setVariant(String variant) {
        Variant = variant;
    }

    public String getInventory() {
        return Inventory;
    }

    public void setInventory(String inventory) {
        Inventory = inventory;
    }

    public String getPrice1() {
        return Price1;
    }

    public void setPrice1(String price1) {
        Price1 = price1;
    }

    public String getPrice2() {
        return Price2;
    }

    public void setPrice2(String price2) {
        Price2 = price2;
    }

    }