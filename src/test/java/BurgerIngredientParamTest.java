import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerIngredientParamTest {

    private final int ingredientIndex;

    public BurgerIngredientParamTest(int ingredientIndex) {
        this.ingredientIndex = ingredientIndex;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{{0}, {1}, {2}, {3}, {4}, {5}};
    }

    @Test
    public void addIngredientPositiveTest() {
        Database database = new Database();
        Burger burger = new Burger();

        List<Ingredient> availableIngredients = database.availableIngredients(); // сохраним список доступных в базе ингредиентов
        burger.addIngredient(availableIngredients.get(ingredientIndex)); // добавим тестовому бургеру ингредиент c нужным индексом

        // создадим проверочный список ингредиентов, возьмем из базы ингредиент с тем же индексом и добавим в созданный список
        List<Ingredient> expectedIngredientsList = new ArrayList<>();
        expectedIngredientsList.add(availableIngredients.get(ingredientIndex));

        String expectedIngredients = expectedIngredientsList.toString(); // сохраним проверочный список ингредиентов как строку
        String actualIngredients = burger.ingredients.toString(); // сохраним ингредиенты созданного бургера как строку

        // сравним строки и проверим что бургеру установился нужный ингредиент
        Assert.assertEquals("Фактический ингредиент не соответствует ожидаемому", expectedIngredients, actualIngredients);
    }
}
