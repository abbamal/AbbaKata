/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gildedrose;


public class Conjured extends InventoryItem {
    public static final String NAME = "Conjured";
    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void decreaseQuality() {
        item.quality = Math.max(0, item.quality-2);
    }
    
    
    
}
