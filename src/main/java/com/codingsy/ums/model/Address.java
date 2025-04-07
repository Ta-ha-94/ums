package com.codingsy.ums.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(length = 255)
	private String street;
	
	@Column(length = 100)
	private String city;
	
	@Column(length = 100)
	private String state;
	
	@Column(name = "pin_code")
	private String pinCode;
	
	@Column(length = 100)
	private String country;
	
	protected Address() {
	}
	
	private Address(Builder builder) {
		this.street = builder.street;
		this.city = builder.city;
		this.state = builder.state;
		this.pinCode = builder.pinCode;
		this.country = builder.country;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private String street;
		private String city;
		private String state;
		private String pinCode;
		private String country;
		
		public Builder street(String street) {
			this.street = street;
			return this;
		}
		
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		public Builder state(String state) {
			this.state = state;
			return this;
		}
		
		public Builder pinCode(String pinCode) {
			this.pinCode = pinCode;
			return this;
		}
		
		public Builder country(String country) {
			this.country = country;
			return this;
		}
		
		public Address build() {
			return new Address(this);
		}
	}

	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public String getCountry() {
		return country;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", pinCode=" + pinCode
				+ ", country=" + country + "]";
	}
}
