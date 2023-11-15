package catalogue;

import java.io.Serializable;
import java.util.Collections;

/**
 * Write a description of class BetterBasket here.
 * BetterBasket is an extension of Basket which has two enhancements:
 * it merges multiple instances of the same product into a single record
 * it sorts the record by ProductNum
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Override
  public boolean add(Product p1)  {
    //search existing products for matching record
    for (Product p2: this)  {
      if (p1.getProductNum().equals(p2.getProductNum()))  {
        // found - update quantity and return
        p2.setQuantity(p2.getQuantity()+p1.getQuantity());
        return(true);
      }
    }
    //not found - add new product, using superclass method
    super.add(p1);
    return(true);
  }
}
