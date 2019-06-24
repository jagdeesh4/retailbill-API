package com.retail.retailWebsite.domain.bill;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bill {

    
    @NotNull(message = "id can not be null")
    private Long id;
    @NotNull(message = "storeName can not be null")
    private String storeName;

    private List<Item> items = null;

    public Bill() {

    }

    public Bill(Long id, String storeName, List<Item> items) {
        this.id = id;
        this.storeName = storeName;
        this.items = items;
    }

    public final Long getId() {
        return id;
    }

    public final void setId(Long id) {
        this.id = id;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public final List<Item> getItems() {
        return items;
    }

    public final void setItems(List<Item> items) {
        this.items = items;
    }

	@Override
	public String toString() {
		return "Bill [id=" + id + ", storeName=" + storeName + ", items=" + items + "]";
	}

       
    
}
