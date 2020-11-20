package org.plugin.espressif.catalog;

public enum ItemType {
    DevKit("DevKit"), Socs("Socs"), Module("Module");

    private String name;
    ItemType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
