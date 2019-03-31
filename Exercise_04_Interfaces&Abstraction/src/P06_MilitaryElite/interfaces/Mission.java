package P06_MilitaryElite.interfaces;

import P06_MilitaryElite.enums.MissionState;

public interface Mission {
    String getCodeName();
    MissionState getState();
    void completeMission();


}
