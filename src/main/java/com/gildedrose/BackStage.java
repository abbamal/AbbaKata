/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gildedrose;


public class BackStage extends InventoryItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";
    public BackStage(Item item) {
        super(item);
    }

    @Override
    protected void updateQualityItem() {
            this.encreaseQuality();
            if (item.sellIn < 11) {
                this.encreaseQuality();
            }
            if (item.sellIn < 6) {
                this.encreaseQuality();
            }
    }

    @Override
    protected void expirationProcess() {
        item.quality = 0;
    }
    
    
    
    
}
