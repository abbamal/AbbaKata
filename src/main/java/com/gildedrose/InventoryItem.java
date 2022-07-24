/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gildedrose;

/**
 *
 * @author abba
 */
public class InventoryItem {


    private Item item ;
    public InventoryItem(Item item) {
        this.item = item ;
    }


    
    public static void createType(Item item) {
        InventoryItem inventoryItem = new InventoryItem(item);
        inventoryItem.updateDaily(item);
    }
    protected void updateQualityItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            this.encreaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            this.encreaseQuality(item);
            if (item.sellIn < 11) {
                this.encreaseQuality(item);
            }
            if (item.sellIn < 6) {
                this.encreaseQuality(item);
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            this.decreaseQuality(item);
        }
    }

    protected void updateExpirationDays(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    protected void expirationProcess(Item item) {
        if (item.name.equals("Aged Brie")) {
            this.encreaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            this.decreaseQuality(item);
        }
    }

    protected void updateDaily(Item item) {
        this.updateQualityItem(item);
        this.updateExpirationDays(item);
        if (item.sellIn < 0) {
            this.expirationProcess(item);
        }
    }
    
    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void encreaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }    
    
}
