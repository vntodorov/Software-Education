package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class AlarmTest {

    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void setUp(){
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecauseLowPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(14.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecauseHighPressure(){
        when(sensor.popNextPressurePsiValue()).thenReturn(25.0);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOff(){
        when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}