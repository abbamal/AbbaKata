package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    
    @Test 
    void standard_item_quality_decrease_sellin_decrease_every_day(){
       Item standard = new Item("standard", 19, 6) ;
       GildedRose gr = new GildedRose(new Item[]{standard});
       gr.updateQuality();
       assertEquals(standard.sellIn, 18);
       assertEquals(standard.quality, 5);
    
    }
    @Test 
    void multiple_items_degrade_every_day(){
       Item firstStandard = new Item("firstStandard", 19, 6) ;
       Item secondStandard = new Item("secondStandard", 15, 4) ;
       GildedRose gr = new GildedRose(new Item[]{firstStandard,secondStandard});
       gr.updateQuality();
       
       assertEquals(firstStandard.sellIn, 18);
       assertEquals(firstStandard.quality, 5);
       
       assertEquals(secondStandard.sellIn, 14);
       assertEquals(secondStandard.quality, 3);
    
    }

    @Test 
    void item_quality_derades_twice_if_sellin_date_expires(){
       Item standard = new Item("standard", -1, 6) ;
       GildedRose gr = new GildedRose(new Item[]{standard});
       gr.updateQuality();
       assertEquals(standard.sellIn, -2);
       assertEquals(standard.quality, 4);
    
    }  
    
    @Test 
    void item_quality_is_never_negative(){
       Item standard = new Item("standard", 5, 0) ;
       GildedRose gr = new GildedRose(new Item[]{standard});
       gr.updateQuality();
       assertEquals(standard.sellIn, 4);
       assertEquals(standard.quality,0);
    
    } 

    @Test 
    void aged_increase_in_quality_over_time(){
       Item agedItem = new Item("Aged Brie", 18,8) ;
       GildedRose gr = new GildedRose(new Item[]{agedItem});
       gr.updateQuality();
       assertEquals(agedItem.sellIn, 17);
       assertEquals(agedItem.quality,9);
    
    }      

    @Test 
    void aged_increase_in_quality_twice_if_sellin_expired(){
       Item agedItem = new Item("Aged Brie", -1,8) ;
       GildedRose gr = new GildedRose(new Item[]{agedItem});
       gr.updateQuality();
       assertEquals(agedItem.sellIn, -2);
       assertEquals(agedItem.quality,10);
    
    }   
    @Test 
    void quality_never_greater_then_50(){
       Item agedItem = new Item("Aged Brie", -1,50) ;
       GildedRose gr = new GildedRose(new Item[]{agedItem});
       gr.updateQuality();
       assertEquals(agedItem.sellIn, -2);
       assertEquals(agedItem.quality,50);
    
    } 

    @Test 
    void backstage_increase_in_quality_as_sellin_date_approch(){
       Item backstageItem = new Item("Backstage passes to a TAFKAL80ETC concert", 13,30) ;
       GildedRose gr = new GildedRose(new Item[]{backstageItem});
       gr.updateQuality();
       assertEquals(backstageItem.sellIn, 12);
       assertEquals(backstageItem.quality,31);
    
    }  

    @Test 
    void backstage_increase_in_quality_twice_when_there_are_10_days_or_less(){
       Item backstageItem = new Item("Backstage passes to a TAFKAL80ETC concert", 10,30) ;
       GildedRose gr = new GildedRose(new Item[]{backstageItem});
       gr.updateQuality();
       assertEquals(backstageItem.sellIn, 9);
       assertEquals(backstageItem.quality,32);
    
    }  
    
    @Test 
    void backstage_increase_in_quality_by_3_when_there_are_5_days_or_less(){
       Item backstageItem = new Item("Backstage passes to a TAFKAL80ETC concert", 5,30) ;
       GildedRose gr = new GildedRose(new Item[]{backstageItem});
       gr.updateQuality();
       assertEquals(backstageItem.sellIn, 4);
       assertEquals(backstageItem.quality,33);
    
    } 
    
    @Test 
    void backstage_quality_is_0_after_concert(){
       Item backstageItem = new Item("Backstage passes to a TAFKAL80ETC concert", 0,30) ;
       GildedRose gr = new GildedRose(new Item[]{backstageItem});
       gr.updateQuality();
       assertEquals(backstageItem.sellIn, -1);
       assertEquals(backstageItem.quality,0);
    
    }   
    
    @Test 
    void sulfuras_never_have_to_be_sold_or_decrease_in_quality(){
       Item sulfurasItem = new Item("Sulfuras, Hand of Ragnaros", -1,80) ;
       GildedRose gr = new GildedRose(new Item[]{sulfurasItem});
       gr.updateQuality();
       assertEquals(sulfurasItem.sellIn, -1);
       assertEquals(sulfurasItem.quality,80);
    
    }      
    
}
