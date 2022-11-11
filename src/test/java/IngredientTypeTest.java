import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeSauceTest() {
        IngredientType ingredientSauce = IngredientType.SAUCE;
        Assert.assertEquals("Ожидаемый тип не соответствует фактическому",
                IngredientType.valueOf("SAUCE"), ingredientSauce);
    }

    @Test
    public void ingredientTypeFillingTest() {
        IngredientType ingredientFilling = IngredientType.FILLING;
        Assert.assertEquals("Ожидаемый тип не соответствует фактическому",
                IngredientType.valueOf("FILLING"), ingredientFilling);
    }
}
