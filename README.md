Втора лабораториска вежба по Софтверско инженерство

Ѓорге Проданов, 216134

2.Control Flow Graph
![SI.drawio .png](SI.drawio%20.png)

3.Цикломатска комплексност на овој код е 10

P=9
P+1=10

2,6,8,11,14,16,20,30,34

4.Тест случаи според  Every Branch

1.if (allItems == null){//2:
Test Case 1: allitems==null
-allItems = null, payment = 100  
Test Case 2: allitems!=null
-allItems = [new Item(null, "123456", 100, 0)], payment = 100

2.if (item.getName() == null || item.getName().length() == 0){//8
Test Case 1: item.name == null  
-allItems = [new Item(null, "123456", 100, 0)], payment = 100    
Test Case 2: empty name item.length() == 0
-allItems = [new Item("", "123456", 100, 0)], payment = 100     
Test Case 3: Item object with a non-empty name
-allItems = [new Item("itemName", "123456", 100, 0)], payment = 100     

3.if (item.getBarcode() != null){//11:
Test Case 1: item object with a valid barcode
-allItems = [new Item("itemName", "123456", 100, 0)], payment = 100
Test Case 2: item object with a null barcode
-allItems = [new Item("itemName", null, 100, 0)], payment = 100

4.if (allowed.indexOf(c) == -1){//16:
Test Case 1: item object with valid barcode
-allItems = [new Item("itemName", "123456", 100, 0)], payment = 100
Test Case 2: item object with invalid character in the barcode
-allItems = [new Item("itemName", "12345a", 100, 0)], payment = 100

5.if (item.getDiscount() > 0){//20:
Test Case 1: item object with discount > 0
-allItems = [new Item("itemName", "123456", 100, 0.1f)], payment = 100
Test Case 2: item object with discount == 0
-allItems = [new Item("itemName", "123456", 100, 0)], payment = 100

6.if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//30:
Test Case 1: item object that meets all conditions
-allItems = [new Item("itemName", "0123456", 350, 0.1f)], payment = 100
Test Case 2: item.getPrice() < 300 other are not important bcs its &&
-allItems = [new Item("itemName", "0123456", 100, 0.1f)], payment = 100
Test Case 3: item.getPrice() > 300 && item.getDiscount() <= 0 last not important it will fall on item.getDiscount()
-allItems = [new Item("itemName", "0123456", 350, 0)], payment = 100
Test Case 4: iteitem.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt() != 0 it will fall on the last
-allItems = [new Item("itemName", "1123456", 350, 0.1f)], payment = 100

7.if (sum <= payment){//34:
Test Case 1: sum is <= payment
-allItems = [new Item("itemName", "123456", 100, 0)], payment = 200
Test Case 2: sum is > payment
-allItems = [new Item("itemName", "123456", 400, 0)], payment = 200


5.Тест случаи според Multiple Condition

1.if (item.getName() == null || item.getName().length() == 0){//8:
Test Case 1: item object is null ,length can be x
-allItems = [new Item(null, "123456", 100, 0)], payment = 100
Test Case 2: item object is not null , length is == 0
-allItems = [new Item("", "123456", 100, 0)], payment = 100
Test Case 3: item object is not null , length is not 0
-allItems = [new Item("itemName", "123456", 100, 0)], payment = 100

2.if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//30:
Test Case 1: item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt() == 0
-allItems = [new Item("itemName", "0123456", 350, 0.1f)], payment = 100
Test Case 2: item.getPrice() < 300 other are not important bcs its &&
-allItems = [new Item("itemName", "0123456", 100, 0.1f)], payment = 100
Test Case 3: item.getPrice() > 300 && item.getDiscount() <= 0 last not important it will fall on item.getDiscount()
-allItems = [new Item("itemName", "0123456", 350, 0)], payment = 100
Test Case 4: iteitem.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt() != 0 it will fall on the last
-allItems = [new Item("itemName", "1123456", 350, 0.1f)], payment = 100


6.Објаснување на напишаните unit tests
-Според Every Statment методот одиме до сите if во кодот и за секој пишуваме посебно test cases за да ги провериме сите случаи и да видиме дали кодот работи соодветно:
1.Да започнеме со if (allItems == null){//2: овде треба да провериме дали ќе фрли exception ако allitems==null и во спротивно дали ќе биде true ако allitems!=null.
2.if (item.getName() == null || item.getName().length() == 0){//8 тука може да провериме дали getName e null , потоа проверуваме ако е "" дали ќе падне на getName().length == 0 
и на крај проверуваме со добри податоци.
3.if (item.getBarcode() != null){//11: овде проверуваме дали имаме баркод или немаме воопшто со тоа што го споредуваме со null.
4.if (allowed.indexOf(c) == -1){//16: во овој дел од кодот проверуваме дали имаме валиден баркод , во првиот test case ставаме валиден а во вториот ставаме невалиден баркод
5.if (item.getDiscount() > 0){//20: овде проверуваме дали попустот е поголем од 0, во првиот test case ставаме поголем од 0 а во другиот ставаме 0
6.if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//30: овој if statment има повеќе && и барем еден ако падне целото паѓа така можеме со 
еден test case да видиме дали сите ќе поминат и потоа посебен test case за секое барање да видиме на кое ќе падне.
7.if (sum <= payment){//34: овде треба да провериме дали sum <= paymant и во првиот test case сумата е помала па враќа true а во вториот е поголема и враќа false.

-Според Multiple Condition одиме само во if-овите каде што имаме повеќе conditions и вакви имаме само два во нашиот код:
1.if (item.getName() == null || item.getName().length() == 0){//8: овде имаме 3 начини на кој што може кодот да помине и тоа T,F F,T T,T 
(бидејќи || значи барем еден или и двата да се точни) и ги проверуваме сите три посебно.
2.if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//30: тука бидејќи имаме &&(мора сите да бидат точни за да добиеме точно) што значи можеме
да напишеме еден test case каде што сите ќе бидат точни и потоа 3 test cases каде што ќе паѓа на еден од statments.









