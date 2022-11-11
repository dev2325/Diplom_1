import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    // создадим ингредиент с тестовыми данными
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ingredient Test Name", 200);

    @Test
    public void ingredientGetNameTest() {
        // проверим что ингредиенту установилось нужное имя
        Assert.assertEquals("Ожидаемое имя не соответствует фактическому", "Ingredient Test Name", ingredient.getName());
    }

    @Test
    public void ingredientGetPriceTest() {
        // проверим что ингредиенту установилась нужная цена
        Assert.assertEquals("Ожидаемая цена не соответствует фактической", 200, ingredient.getPrice(), 0);
    }

    @Test
    public void ingredientGetTypeTest() {
        // проверим что ингредиенту установился нужный тип
        Assert.assertEquals("Ожидаемый тип не соответствует фактическому", IngredientType.SAUCE, ingredient.getType());
    }
}
