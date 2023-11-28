package clients.shopDisplay;

import debug.DEBUG;
import middle.MiddleFactory;
import middle.OrderException;
import middle.OrderProcessing;

//added imports
import catalogue.Product;
import middle.StockException;
import middle.StockReader;

import java.util.List;
import java.util.Map;
import java.util.Observable;

//TODO:
// File is complete but not optimal
//  Will force update of display every 2 seconds
//  Could be clever & only ask for an update of the display
//   if it really has changed


/**
 * Implements the Model of the display client
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */


public class DisplayModel extends Observable
{
  private OrderProcessing theOrder = null;
  private StockReader stockReader;

  /**
   * Set up initial connection to the order processing system
   * @param mf Factory to return an object to access the order processing system
   */
  public DisplayModel( MiddleFactory mf  )
  {
    try                                           //
    {
      this.theOrder = mf.makeOrderProcessing();        // Process order
        this.stockReader = mf.makeStockReader();        // Stock reader
    } catch ( Exception e )
    {
      // Serious error in system (Should not occur)
      DEBUG.error("ModelOfDisplay: " + e.getMessage() );
    }
    new Thread(this::backgroundRun).start();
  }

 /**
   * Run as a thread in background to continually update the display
   */
  public void backgroundRun()
  {
    while ( true )                               // Forever
    {
     try
      {
        Thread.sleep(2000);
        DEBUG.trace( "ModelOfDisplay call view" );
        setChanged(); notifyObservers();
      }
      catch ( InterruptedException e )
      {
        DEBUG.error( "%s\n%s\n",
                    "ModelOfDisplay.run()",
                    e.getMessage() );
      }
    }
  }

  public Product getProductDetails(String productNum) throws StockException {
      return stockReader.getDetails(productNum);
  }

 // Will be called by the viewOfDisplay
 //   when it is told that the view has changed
 public synchronized Map<String, List<Integer> > getOrderState()
       throws OrderException
 {
   return theOrder.getOrderState();
 }
}
