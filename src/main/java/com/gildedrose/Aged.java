/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gildedrose;


public class Aged extends InventoryItem {

    public static final String NAME = "Aged Brie";    
    public Aged(Item item) {
        super(item);
    }

    @Override
    protected void updateQualityItem() {
        this.encreaseQuality();
    }

    @Override
    protected void expirationProcess() {
        this.encreaseQuality();
    }

    
    
    
}
