package com.ssafy.myhome.model.vo;

public class StoreTypeValue {
	double convenience_store;
	double education;
	double cafe;
	double restaurant;
	double health;
	double market;
	
	public StoreTypeValue(double convenience_store, double education, double cafe, double restaurant, double health,
			double market) {
		this.convenience_store = convenience_store;
		this.education = education;
		this.cafe = cafe;
		this.restaurant = restaurant;
		this.health = health;
		this.market = market;
	}
	
	public double getConvenience_store() {
		return convenience_store;
	}
	
	public void setConvenience_store(double convenience_store) {
		this.convenience_store = convenience_store;
	}
	
	public double getEducation() {
		return education;
	}
	
	public void setEducation(double education) {
		this.education = education;
	}
	
	public double getCafe() {
		return cafe;
	}
	
	public void setCafe(double cafe) {
		this.cafe = cafe;
	}
	
	public double getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(double restaurant) {
		this.restaurant = restaurant;
	}
	
	public double getHealth() {
		return health;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public double getMarket() {
		return market;
	}
	
	public void setMarket(double market) {
		this.market = market;
	}

}
