package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AlarmTest {

    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void setUp() {
        sensor = mock(Sensor.class);
    }

    @Test
    public void testAlarmIsOnWhenTyrePressureUnderTheMinimum() {
        when(sensor.popNextPressurePsiValue()).thenReturn(16.9);
        alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWhenTyrePressureOverTheMaximum() {
        when(sensor.popNextPressurePsiValue()).thenReturn(21.1);
        alarm = new Alarm(sensor);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOffWhenTyrePressureInRange() {
        when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        alarm = new Alarm(sensor);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}