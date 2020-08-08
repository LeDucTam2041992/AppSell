package model;

public class SpecHeadPhone {
    String codeSpec, Compatible, timeUse, distance, soundTechnology;

    public SpecHeadPhone() {
    }

    public SpecHeadPhone(String codeSpec, String compatible, String timeUse, String distance, String soundTechnology) {
        this.codeSpec = codeSpec;
        this.Compatible = compatible;
        this.timeUse = timeUse;
        this.distance = distance;
        this.soundTechnology = soundTechnology;
    }

    public String getCodeSpec() {
        return codeSpec;
    }

    public void setCodeSpec(String codeSpec) {
        this.codeSpec = codeSpec;
    }

    public String getCompatible() {
        return Compatible;
    }

    public void setCompatible(String compatible) {
        Compatible = compatible;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSoundTechnology() {
        return soundTechnology;
    }

    public void setSoundTechnology(String soundTechnology) {
        this.soundTechnology = soundTechnology;
    }

    public String fileData() {
        String data;
        data = codeSpec + "|" + Compatible + "|" + timeUse + "|" + distance + "|" + soundTechnology;
    return data;
    }
}
