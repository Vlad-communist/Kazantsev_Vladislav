package zoo;

import zoo.animals.*;
import zoo.food.types.Beef;
import zoo.food.types.FishMeet;
import zoo.food.types.Grass;
import zoo.food.types.Meet;

public class Main {
    public static void main(String[] args) {
        Horse horse = new Horse("Лошадка Максим");
        horse.eat(new Grass("руккола"));
        horse.eat(new Meet("какое-то мясо"));
        horse.move();

        System.out.println();

        Tiger tiger = new Tiger("Тигр Влад");
        tiger.eat(new Grass("руккола"));
        tiger.eat(new Meet("какое-то мясо"));
        tiger.eat(new Beef("мраморная говядина"));
        tiger.move();

        System.out.println();

        Dolphin dolphin = new Dolphin("Дельфин Елизавета");
        dolphin.eat(new Grass("руккола"));
        dolphin.eat(new Meet("какое-то мясо"));
        dolphin.eat(new FishMeet("лосось свежий 1500р/кг"));
        dolphin.move();

        System.out.println();

        Eagle eagle = new Eagle("Орёл Данил");
        eagle.eat(new Grass("руккола"));
        eagle.eat(new Meet("какое-то мясо"));
        eagle.eat(new FishMeet("лосось свежий 1500р/кг"));
        eagle.eat(new Beef("мраморная говядина"));
        eagle.move();

        System.out.println();

        Camel camel = new Camel("Верблюд Алексей Бирюлин");
        camel.eat(new Grass("руккола"));
        camel.eat(new Meet("какое-то мясо"));
        camel.eat(new FishMeet("лосось свежий 1500р/кг"));
        camel.move();
    }
}
