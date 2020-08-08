package model;

public class SpecSmartPhone {
    private String codeSpec, screen, ram, chip, operaSystem, pin, camera;

    public SpecSmartPhone() {
    }

    public SpecSmartPhone(String codeSpec, String screen, String ram, String chip, String operaSystem, String pin, String camera) {
        this.codeSpec = codeSpec;
        this.screen = screen;
        this.ram = ram;
        this.chip = chip;
        this.operaSystem = operaSystem;
        this.pin = pin;
        this.camera = camera;
    }

    public String getCodeSpec() {
        return codeSpec;
    }

    public void setCodeSpec(String codeSpec) {
        this.codeSpec = codeSpec;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getOperaSystem() {
        return operaSystem;
    }

    public void setOperaSystem(String operaSystem) {
        this.operaSystem = operaSystem;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String fileData() {
        String data;
        data = codeSpec + "|" + screen + "|" + ram + "|" + chip + "|" + operaSystem + "|" + pin + "|" + camera;
        return data;
    }

    public void showInfo(){
        System.out.println("Screen : " + screen);
        System.out.println("Camera : " + camera);
        System.out.println("Ram : " + ram);
        System.out.println("Chip : " + chip);
        System.out.println("Opera System : " + operaSystem);
        System.out.println("Pin : " + pin);
    }
}
