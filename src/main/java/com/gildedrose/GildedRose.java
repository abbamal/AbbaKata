package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateDaily(item);
        }
    }

    public void updateDaily(Item item) {
        updateQualityItem(item);
        updateExpirationDays(item);
        if (item.sellIn < 0) {
            expirationProcess(item);
        }
    }

    public void expirationProcess(Item item) {
            
            if (item.name.equals("Aged Brie")) {
            encreaseQuality(item);                
                }
  
            else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))  {
                      item.quality = 0;
                   }
            
            else if(item.name.equals("Sulfuras, Hand of Ragnaros")) {
                       return ;
                    }
            else {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;    
                        }
                }    
        
    }

    public void encreaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public void updateExpirationDays(Item item) {
        if(item.name.equals("Sulfuras, Hand of Ragnaros")){
            return ;
        }
        
            item.sellIn = item.sellIn - 1;

    }

    public void updateQualityItem(Item item) {
        if (item.name.equals("Aged Brie") ) {
            encreaseQuality(item);            
        }
        else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            encreaseQuality(item); 
                if (item.sellIn < 11) {
                encreaseQuality(item);
                }
                if (item.sellIn < 6) {
                encreaseQuality(item);
                }
            
       
        }
        else if(item.name.equals("Sulfuras, Hand of Ragnaros")){
          return;
        }
        else {
            if (item.quality > 0) {  
                    item.quality = item.quality - 1;
            }
        }
    }

}