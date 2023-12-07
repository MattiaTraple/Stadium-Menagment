package simu.framework;

public interface IEngine {

    public void setSimulationTime(double time);
    public void setDelay(long time);
    public long getDelay();

    void setSettings(int[] ints);

    int[] getSettings();

    int getSimulationTime();
}
