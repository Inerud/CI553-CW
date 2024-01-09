package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;

  // Override the add method to implement the required changes
  @Override
  public boolean add(Product pr) {
    // Check if the product already exists in the basket
    Product existingProduct = getProductByNumber(pr.getProductNum());

    if (existingProduct != null) {
      // If the product exists, update the quantity
      existingProduct.setQuantity(existingProduct.getQuantity() + pr.getQuantity());
    } else {
      // If the product does not exist, add it to the basket
      super.add(pr);
    }

    // Sort the basket by product numbers
    sortBasketByProductNumber();

    // Return true as the product has been successfully added
    return true;
  }

  // Helper method to get a product from the basket based on its product number
  private Product getProductByNumber(String productNumber) {
    for (Product pr : this) {
      if (pr.getProductNum().equals(productNumber)) {
        return pr;
      }
    }
    return null;
  }

  // Helper method to sort the basket by product numbers
  private void sortBasketByProductNumber() {
    this.sort(Comparator.comparing(Product::getProductNum));
  }
}