package com.servlet.jms.sender.vo;

import java.io.Serializable;

/**
 * 
 * @author VC1 This class must implements Serialization... Because this object
 *         has to travel over the network..........sss
 *
 */
public class FrogProfileVO implements Serializable {
	private String name;
	private String color;
	private int price;
	private String email;

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FrogProfileVO [name=" + name + ", color=" + color + ", price=" + price + ", email=" + email + "]";
	}

}
