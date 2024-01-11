package clients.cashier;

import middle.MiddleFactory;
import middle.OrderProcessing;
import middle.StockReadWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BetterCashierView extends CashierView {
    private BetterCashierController controller;  // Ensure you have the controller instance
    private BetterCashierModel betterCashierModel;  // Ensure you have the model instance

    private static final int H = 300;       // Height of window pixels
    private static final int W = 400;       // Width  of window pixels

    private static final String CHECK  = "Check";
    private static final String BUY    = "Buy";
    private static final String BOUGHT = "Bought";

    private final JLabel      theAction  = new JLabel();
    private final JTextField  theInput   = new JTextField();
    private final JTextArea   theOutput  = new JTextArea();
    private final JScrollPane theSP      = new JScrollPane();
    private final JButton     theBtCheck = new JButton( CHECK );
    private final JButton     theBtBuy   = new JButton( BUY );
    private final JButton     theBtBought= new JButton( BOUGHT );

    private StockReadWriter theStock     = null;
    private OrderProcessing theOrder     = null;
    private CashierController cont       = null;

    public BetterCashierView(BetterCashierController controller, BetterCashierModel betterCashierModel) {
        super(controller);  // Assuming CashierView has a constructor that takes a controller
        this.controller = controller;
        this.betterCashierModel = betterCashierModel;
        initializeUI();
    }

    private void initializeUI() {
        JFrame frame = new JFrame("Better Cashier");
        JPanel panel = new JPanel();

        JButton removeLastButton = new JButton("Remove Last Item");
        removeLastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                betterCashierModel.removeLastItem();  // Call the method on the existing instance
            }
        });

        panel.add(removeLastButton);
        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
