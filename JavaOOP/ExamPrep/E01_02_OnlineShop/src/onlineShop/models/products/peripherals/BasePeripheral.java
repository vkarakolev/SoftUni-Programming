package onlineShop.models.products.peripherals;

import onlineShop.models.products.BaseProduct;

import static onlineShop.common.constants.OutputMessages.PERIPHERAL_TO_STRING;
import static onlineShop.common.constants.OutputMessages.PRODUCT_TO_STRING;

public class BasePeripheral extends BaseProduct implements Peripheral {
    private String connectionType;

    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String toString() {
        return String.format(PRODUCT_TO_STRING + PERIPHERAL_TO_STRING,
                this.getOverallPerformance(), this.getPrice(), this.getClass().getSimpleName(),
                this.getManufacturer(), this.getModel(), this.getId(), this.getConnectionType());
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }


}
