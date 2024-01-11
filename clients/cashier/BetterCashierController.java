package clients.cashier;


import middle.MiddleFactory;

public class BetterCashierController extends CashierController{

    /**
     * Constructor
     *
     * @param model The model
     * @param view  The view from which the interaction came
     */
    public BetterCashierController(CashierModel model, CashierView view) {
        super(model, view);
    }

    public void handleRemoveLastButtonClick(MiddleFactory mf) {
        BetterCashierModel betterCashierModel = new BetterCashierModel(mf);
        betterCashierModel.removeLastItem(); // Call a method in the model to handle removal
    }

}
