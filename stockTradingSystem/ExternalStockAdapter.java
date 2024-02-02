package stockTradingSystem;

public class ExternalStockAdapter implements StockAdapter {

	@Override
	public Stock convertExternalStock(ExternalStock externalStock) {
		return new Stock(externalStock.getId(), externalStock.getName(), externalStock.getPrice(),0, externalStock.getDate());
	}

}
