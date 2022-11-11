import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    // создадим булку с тестовыми данными
    Bun bun = new Bun("Bun Test Name", 100);

    @Test
    public void bunGetNameTest() {
        // проверим что бургеру установилось нужное имя
        Assert.assertEquals("Ожидаемое имя не соответствует фактическому", "Bun Test Name", bun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        // проверим что бургеру установилась нужная цена
        Assert.assertEquals("Ожидаемая цена не соответствует фактической", 100, bun.getPrice(), 0);
    }
}
