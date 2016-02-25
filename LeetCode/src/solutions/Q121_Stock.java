package solutions;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * 
 * @author JT
 *
 */
public class Q121_Stock {

	//One variable to keep track of the minimum buy-in price up till ith day
	//Another variable to keep track of the maximum profit up till ith day
    public int maxProfit(int[] prices) {
    	int maxProfit = 0;
    	int buyInPrice = prices[0];
    	for (int i = 1; i < prices.length; i++) {
    		buyInPrice = Math.min(buyInPrice, prices[i-1]);
    		maxProfit = Math.max(maxProfit, prices[i] - buyInPrice);
    	}
    	return maxProfit;
    }
	

}
