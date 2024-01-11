package clients.cashier;

import catalogue.Basket;
import catalogue.BetterBasket;
import catalogue.Product;
import middle.MiddleFactory;
import debug.DEBUG;

public class BetterCashierModel extends CashierModel{
    public BetterCashierModel(MiddleFactory mf) {
        super(mf);
    }

    @Override
    protected Basket makeBasket() {
        // Implement your BetterBasket creation logic here
        return new BetterBasket(); // Assuming BetterBasket is a class that extends Basket
    }

//    @Override
//    public void removeLastItem() {
//        String theAction = "";
//        System.out.println("In BetterCashierModel");
//        System.out.println("TheBasket: " + theBasket);
//        theBasket = null;
//        setChanged(); notifyObservers(theAction);
//        System.out.println("Removed last item from basket");
//
//    }

}
