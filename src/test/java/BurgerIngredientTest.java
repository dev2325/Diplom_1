import org.junit.Assert;
import org.junit.Test;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BurgerIngredientTest {

    @Test
    public void removeIngredientPositiveTest() {
        Database database = new Database();
        Burger burger = new Burger();
        List<Ingredient> availableIngredients = database.availableIngredients(); // сохраним список доступных в базе ингредиентов
        burger.addIngredient(availableIngredients.get(0)); // добавим тестовому бургеру первый ингредиент из базы

        // если ингредиент добавился, удалим его из бургера и проверим что ингредиентов не стало
        if (!burger.ingredients.isEmpty()) {
            burger.removeIngredient(0);
            Assert.assertTrue(burger.ingredients.isEmpty());

        } else {
            Assert.fail("Expected Exception: список ингредиентов не должен быть пустым");
        }
    }

    @Test
    public void moveIngredientPositiveTest() {
        Database database = new Database();

        // создадим два тестовых бургера
        Burger burgerFirst = new Burger();
        Burger burgerSecond = new Burger();

        List<Ingredient> availableIngredients = database.availableIngredients(); // сохраним список доступных в базе ингредиентов

        // добавим тестовым бургерам одинаковые наборы игредиентов из сохраненного списка
        burgerFirst.addIngredient(availableIngredients.get(0));
        burgerFirst.addIngredient(availableIngredients.get(1));

        burgerSecond.addIngredient(availableIngredients.get(0));
        burgerSecond.addIngredient(availableIngredients.get(1));

        // сохраним начальный список ингредиентов у каждого бургера
        List<Ingredient> firstList = burgerFirst.ingredients;
        List<Ingredient> secondList = burgerSecond.ingredients;

        burgerFirst.moveIngredient(1, 0); // у первого бургера переместим ингредиент
        List<Ingredient> secondListReversed = reverseList(secondList); // у второго перевернем список ингредиентов

        // проверим что списки снова одинаковые
        Assert.assertEquals("Фактический список игредиентов не соответствует ожидаемому", firstList, secondListReversed);
    }

    public static <T> List<T> reverseList(List<T> list) {
        List<T> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }
}
