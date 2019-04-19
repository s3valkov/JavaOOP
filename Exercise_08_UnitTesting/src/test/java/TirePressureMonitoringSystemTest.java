import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import p06_TirePressureMonitoringSystem.Alarm;
import p06_TirePressureMonitoringSystem.Sensor;

import java.lang.reflect.Field;

public class TirePressureMonitoringSystemTest {

    @Test
    public void alarmShouldTurnOnWhenThePressureIsLower() throws NoSuchFieldException,IllegalAccessException {

        Alarm alarm = new Alarm();
        Sensor mockedSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(10.0);
        Field field = alarm.getClass().getDeclaredField("sensor");
        field.setAccessible(true);
        field.set(alarm,mockedSensor);
        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldTurnOnWhenThePressureIsHigh() throws NoSuchFieldException,IllegalAccessException {

        Alarm alarm = new Alarm();
        Sensor mockedSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(100.0);
        Field field = alarm.getClass().getDeclaredField("sensor");
        field.setAccessible(true);
        field.set(alarm,mockedSensor);
        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldTurnOnWhenThePressureIsNormal() throws NoSuchFieldException,IllegalAccessException {

        Alarm alarm = new Alarm();
        Sensor mockedSensor = Mockito.mock(Sensor.class);

        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(20.0);
        Field field = alarm.getClass().getDeclaredField("sensor");
        field.setAccessible(true);
        field.set(alarm,mockedSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }




}
