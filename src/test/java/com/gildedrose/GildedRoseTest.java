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

}
