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
       Item standard = new Item("foo", 19, 6) ;
       GildedRose gr = new GildedRose(new Item[]{standard});
       gr.updateQuality();
       assertEquals(standard.sellIn, 18);
       assertEquals(standard.quality, 5);
    
    }

}
