import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import praktikum.*;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {

    private final int totalIngredients;

    @Mock
    Bun mockBun;

    @Mock
    Ingredient mockIngredient;

    public BurgerReceiptTest(int totalIngredients) {
        this.totalIngredients = totalIngredients;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{{0}, {1}, {2}, {3}};
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    // проверка метода getReceipt() бургера в изоляции от булок и ингредиентов
    @Test
    public void getReceiptIsolatedPositiveTest() {
        Burger burger = new Burger();
        burger.setBuns(mockBun); // добавим бургеру мок-булки

        // добавим бургеру мок-ингредиенты
        for (int i = 0; i < totalIngredients; i++) {
            burger.addIngredient(mockIngredient);
        }

        Mockito.when(mockBun.getName()).thenReturn("Bun Name");
        Mockito.when(mockIngredient.getName()).thenReturn("Ingredient Name");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.SAUCE);

        System.out.println(burger.getReceipt()); // вызовем проверяемый метод

        // убедимся что методы булок и ингредиентов были вызваны нужное количество раз
        Mockito.verify(mockBun, Mockito.times(2)).getName();
        Mockito.verify(mockIngredient, Mockito.times(totalIngredients)).getName();
        Mockito.verify(mockIngredient, Mockito.times(totalIngredients)).getType();
    }
}
