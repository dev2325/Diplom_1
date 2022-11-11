import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Mock
    List<Ingredient> mockIngredientsList;

    @Mock
    Ingredient mockIngredient;

    @Before
    public void init() {
        burger = new Burger(); // инициализируем тестовый бургер
        burger.ingredients = mockIngredientsList; // установим бургеру список мок-ингредиентов
    }

    @Test
    public void removeIngredientTest() {
        burger.removeIngredient(0); // вызовем проверяемый метод
        // убедимся что метод remove() у списка был вызван с тем же аргументом нужное количество раз
        Mockito.verify(mockIngredientsList, Mockito.times(1)).remove(0);
    }

    @Test
    public void moveIngredientTest() {
        Mockito.when(mockIngredientsList.remove(1)).thenReturn(mockIngredient);
        burger.moveIngredient(1, 0); // вызовем проверяемый метод
        Mockito.verify(mockIngredientsList, Mockito.times(1)).add(0, mockIngredientsList.remove(1));
    }
}
