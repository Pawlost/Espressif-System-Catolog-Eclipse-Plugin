package org.plugin.espressif.catalog;

public class Item {
	private final String name;
	private final ItemType type;
	private final String description;

	public Item(String name, ItemType type, String description){
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
