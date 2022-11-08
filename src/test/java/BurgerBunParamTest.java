import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerBunParamTest {

    private final int bunsIndex;

    Burger burger;
    List<Bun> availableBuns;

    public BurgerBunParamTest(int bunsIndex) {
        this.bunsIndex = bunsIndex;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{{0}, {1}, {2}};
    }

    @Before
    public void init() {
        Database database = new Database();
        burger = new Burger();
        availableBuns = database.availableBuns();
    }

    @Test
    public void setBunsPositiveTest() {
        burger.setBuns(availableBuns.get(bunsIndex)); // установим бургеру булку c нужным индексом

        String expectedBun = availableBuns.get(bunsIndex).toString(); // берем из списка булку c этим же индексом и сохраняем ее
        String actualBun = burger.bun.toString(); // берем булку нашего бургера и сохраняем ее

        // проверим что бургеру установилась нужная булка
        Assert.assertEquals("Ожидаемая булка не соответствует фактической", expectedBun, actualBun);
    }
}