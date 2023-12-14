import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simu.framework.IEngine;

public class MainTest {

    private static class TestEngine implements IEngine {

        private double simulationTime;
        private long delay;

        @Override
        public void setSimulationTime(double time) {
            this.simulationTime = time;
        }

        @Override
        public void setDelay(long time) {
            this.delay = time;
        }

        @Override
        public long getDelay() {
            return delay;
        }

        @Override
        public void setSettings(int[] ints) {
            // Implement if needed...
        }

        @Override
        public int[] getSettings() {
            // Implement if needed...
            return new int[0];
        }

        @Override
        public int getSimulationTime() {
            return (int) simulationTime; // Assuming getSimulationTime returns an int
        }
    }

    private IEngine engine;

    @BeforeEach
    public void setUp() {
        engine = new TestEngine();
    }

    @Test
    public void testSetSimulationTime() {
        engine.setSimulationTime(1000);
        assertEquals(1000, engine.getSimulationTime(),0.01);
    }

    @Test
    public void testSetViive() {
        engine.setDelay(100);
        assertEquals(100, engine.getDelay(),0.01);
    }
}
