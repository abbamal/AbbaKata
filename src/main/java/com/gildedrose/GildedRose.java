package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
             InventoryItem inventoryItem = new InventoryItem(item);
            updateDaily(item,inventoryItem);
        }
    }

    public void updateDaily(Item item, InventoryItem inventoryItem) {
        inventoryItem.updateQualityItem(item);
        inventoryItem.updateExpirationDays(item);
        if (item.sellIn < 0) {
            inventoryItem.expirationProcess(item);
        }
    }

}