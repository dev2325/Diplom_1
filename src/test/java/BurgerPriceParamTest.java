import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class BurgerPriceParamTest {

    private final int totalIngredients;
    private final float totalPriceExcepted;

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient;

    public BurgerPriceParamTest(int totalIngredients, float totalPriceExcepted) {
        this.totalIngredients = totalIngredients;
        this.totalPriceExcepted = totalPriceExcepted;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {0, 20}, // вариант без ингредиентов (только булки)
                {1, 30}, // булки (20) + 1 ингредиент (10)
                {2, 40}, // булки (20) + 2 ингредиента (20)
                {3, 50}, // булки (20) + 3 ингредиента (30)
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getPricePositiveTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun); // изолируем тест от базы данных. добавим бургеру мок-булки

        Mockito.when(mockBun.getPrice()).thenReturn(10f); // цена мок-булки будет 10 (20 за обе)
        Mockito.when(mockIngredient.getPrice()).thenReturn(10f); // цена мок-ингредиента будет 10

        // в цикле добавим бургеру мок-ингредиенты
        for (int i = 0; i < totalIngredients; i++) {
            burger.addIngredient(mockIngredient);
        }
        // проверим что получившаяся цена соответствует ожидаемой
        Assert.assertEquals("Ожидаемая цена не соответствует фактической", totalPriceExcepted, burger.getPrice(), 0);
    }
}
