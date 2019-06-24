package com.retail.retailWebsite.domain.bill;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {

   
    @NotNull(message = "price can not be null")
    private BigDecimal price = null;

    @NotNull(message = "name can not be null")
    private String name = null;

    @NotNull(message = "type can not be null")
    private ItemType type = null;

    public Item() {

    }

    public Item(BigDecimal price, String name, ItemType type) {
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public final BigDecimal getPrice() {
        return price;
    }

    public final void setPrice(BigDecimal price) {
        this.price = price;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final ItemType getType() {
        return type;
    }

    public final void setType(ItemType type) {
        this.type = type;
    }

	@Override
	public String toString() {
		return "Item [price=" + price + ", name=" + name + ", type=" + type + "]";
	}

   
}
