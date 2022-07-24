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
        updateQualityItem(item,inventoryItem);
        updateExpirationDays(item,inventoryItem);
        if (item.sellIn < 0) {
            expirationProcess(item,inventoryItem);
        }
    }

    public void expirationProcess(Item item, InventoryItem inventoryItem) {
            
            if (item.name.equals("Aged Brie")) {
            encreaseQuality(item,inventoryItem);                
                }
  
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))  {
                      item.quality = 0;
                   }
            
            else if(item.name.equals("Sulfuras, Hand of Ragnaros")) {
                       return ;
                    }
            else {
            decreaseQuality(item,inventoryItem);
                }    
        
    }





    public void updateExpirationDays(Item item, InventoryItem inventoryItem) {
        if(item.name.equals("Sulfuras, Hand of Ragnaros")){
            return ;
        }
        
            item.sellIn = item.sellIn - 1;

    }

    public void updateQualityItem(Item item, InventoryItem inventoryItem) {
        if (item.name.equals("Aged Brie") ) {
            encreaseQuality(item, inventoryItem);            
        }
        else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            encreaseQuality(item, inventoryItem); 
                if (item.sellIn < 11) {
                encreaseQuality(item, inventoryItem);
                }
                if (item.sellIn < 6) {
                encreaseQuality(item, inventoryItem);
                }
            
       
        }
        else if(item.name.equals("Sulfuras, Hand of Ragnaros")){
          return;
        }
        else {
            decreaseQuality(item, inventoryItem);
        }
    }

    public void encreaseQuality(Item item, InventoryItem inventoryItem) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
    public void decreaseQuality(Item item, InventoryItem inventoryItem) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }    
}