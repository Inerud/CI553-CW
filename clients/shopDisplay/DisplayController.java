package clients.shopDisplay;

import catalogue.Product;
import middle.MiddleFactory;
import middle.StockException;
/**
 * The BackDoor Controller
 * @author M A Smith (c) June 2014
 */

public class DisplayController
{
  private DisplayModel model;
  private DisplayView  view;
  private MiddleFactory middleFactory;
  /**
   * Constructor
   * @param model The model 
   * @param view  The view from which the interaction came
   */
  public DisplayController( DisplayModel model, DisplayView view, MiddleFactory middleFactory)
  {
    this.view  = view;
    this.model = model;
    this.middleFactory = middleFactory;
    this.view.setController(this);
  }

  public Product getProductDetails(String productName) throws StockException {
    try {
      return middleFactory.makeStockReader().getDetails(productName);
    } catch (StockException e) {
      // Handle the exception or propagate it
      throw new StockException("Error fetching product details: " + e.getMessage());
    }
  }
}
