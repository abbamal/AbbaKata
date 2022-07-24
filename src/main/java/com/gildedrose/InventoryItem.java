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


    protected Item item ;
    public InventoryItem(Item item) {
        this.item = item ;
    }


    
    public static InventoryItem createType(Item item) {
        if(item.name.equals("Aged Brie")){
            return  new Aged(item);
        }
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            return  new BackStage(item);
        }
        else if (item.name.equals("Sulfuras, Hand of Ragnaros")){
          return  new Sulfuras(item);
        }
        else 
        return new InventoryItem(item);
         
        
    }

    protected void updateDaily() {
        this.updateQualityItem();
        this.updateExpirationDays();
        if (item.sellIn < 0) {
            this.expirationProcess();
        }
    }    
    protected void updateQualityItem() {
         
            this.decreaseQuality();
        
    }

    protected void updateExpirationDays() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    protected void expirationProcess() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            this.decreaseQuality();
        }
    }


    
    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void encreaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }    
    
}
