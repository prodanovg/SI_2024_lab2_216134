
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private List<SILab2.Item> createList(SILab2.Item... elems) {
        return new ArrayList<SILab2.Item>(Arrays.asList(elems));
    }

    @Test
    void TestEveryBranch() {
        RuntimeException ex;
        List<SILab2.Item> item;
        List<SILab2.Item> finalitem;
        boolean result;

        //if (allItems == null){//2
        //Test Case: allitems==null
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 5));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));
        //Test Case 2: allitems!=null
        item = createList(new SILab2.Item("itemName", "123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);


        //if (item.getName() == null || item.getName().length() == 0){//8
        //Test Case 1: item.name == null
        item = createList(new SILab2.Item(null, "123456", 100, 0));
        SILab2.checkCart(item, 100);
        assertEquals("unknown", item.get(0).getName());

        //Test Case 2: empty name item.length() == 0
        item = createList(new SILab2.Item("", "123456", 100, 0));
        SILab2.checkCart(item, 100);
        assertEquals("unknown", item.get(0).getName());

        //Test Case 3: Item object with a non-empty name
        item = createList(new SILab2.Item("itemName", "123456", 100, 0));
        SILab2.checkCart(item, 100);
        assertEquals("itemName", item.get(0).getName());


        //if (item.getBarcode() != null){//11
        //Test Case 1: item object with a valid barcode
        item = createList(new SILab2.Item("itemName", "123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        // Test Case 2: item object with a null barcode
        item = createList(new SILab2.Item("itemName", null, 100, 0));
        finalitem = item;
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(finalitem, 100));
        assertTrue(ex.getMessage().contains("No barcode!"));


        //if (allowed.indexOf(c) == -1){//16
        //Test Case 1: item object with valid barcode
        item = createList(new SILab2.Item("itemName", "123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 2: item object with invalid character in the barcode
        item = createList(new SILab2.Item("itemName", "123456a", 100, 0));
        List<SILab2.Item> finalItem1 = item;
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(finalItem1, 100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));


        //if (item.getDiscount() > 0){//20
        //Test Case 1: item object with discount > 0
        item = createList(new SILab2.Item("itemName", "123456", 100, 0.1f));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 2: item object with discount == 0
        item = createList(new SILab2.Item("itemName", "123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);


        //if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//30:
        //Test Case 1: item object that meets all conditions
        item = createList(new SILab2.Item("itemName", "0123456", 350, 0.1f));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 2: item.getPrice() < 300 other are not important bcs its &&
        item = createList(new SILab2.Item("itemName", "0123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 3: item.getPrice() > 300 && item.getDiscount() <= 0 last not important it will fall on item.getDiscount()
        item = createList(new SILab2.Item("itemName", "0123456", 350, -50));
        result = SILab2.checkCart(item, 100);
        assertFalse(result);

        //Test Case 4: iteitem.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt() != 0 it will fall on the last
        item = createList(new SILab2.Item("itemName", "123456", 350, 0.1f));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);


        //if (sum <= payment){//34:
        //Test Case 1: sum is <= payment
        item = createList(new SILab2.Item("itemName", "123456", 100, 0));
        result = SILab2.checkCart(item, 200);
        assertTrue(result);

        //Test Case 1: sum is > payment
        item = createList(new SILab2.Item("itemName", "123456", 400, 0));
        result = SILab2.checkCart(item, 200);
        assertFalse(result);

    }

    @Test
    void TestMultipleCondition() {
        List<SILab2.Item> item;
        boolean result;


        //if (item.getName() == null || item.getName().length() == 0){//8:
        //Test Case 1: item object is null ,length can be x
        item = createList(new SILab2.Item("null", "123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 2: item object is not null , length is == 0
        item = createList(new SILab2.Item("", "123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 3: item object is not null , length is not 0
        item = createList(new SILab2.Item("itemName", "123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);


        //if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//30:
        //Test Case 1: item object that meets all conditions
        item = createList(new SILab2.Item("itemName", "0123456", 350, 0.1f));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 2: item.getPrice() < 300 other are not important bcs its &&
        item = createList(new SILab2.Item("itemName", "0123456", 100, 0));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);

        //Test Case 3: item.getPrice() > 300 && item.getDiscount() <= 0 last not important it will fall on item.getDiscount()
        item = createList(new SILab2.Item("itemName", "0123456", 350, -50));
        result = SILab2.checkCart(item, 100);
        assertFalse(result);

        //Test Case 4: iteitem.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt() != 0 it will fall on the last
        item = createList(new SILab2.Item("itemName", "123456", 350, 0.1f));
        result = SILab2.checkCart(item, 100);
        assertTrue(result);


       }
}

