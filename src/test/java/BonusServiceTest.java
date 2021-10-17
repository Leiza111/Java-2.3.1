import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() { //не зарегистрирован, сумма превышает лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_000_60; //сумма
        boolean registered = false;
        long expected = 500; //ожидаемый

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() { ////не зарегистрирован, сумма меньше лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60; //сумма
        boolean registered = false;
        long expected = 10; //ожидаемый

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() { //зарегистрирован, сумма превышает лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_000_60; //сумма
        boolean registered = true;
        long expected = 500; //ожидаемый

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected,actual);
    }

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() { //зарегистрирован, сумма превышает лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60; //сумма
        boolean registered = true;
        long expected = 30; //ожидаемый

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected,actual);
    }
}