package beans;

import java.io.Serializable;

public class DeliveryMethodDataBeans implements Serializable{

	private int id;
	private String delivery;
	private int price;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String name) {
		this.delivery = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
