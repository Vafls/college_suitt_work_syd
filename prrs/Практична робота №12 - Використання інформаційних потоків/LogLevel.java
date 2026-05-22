public enum LogLevel {
    CRITICAL("[CRITICAL]", "Критичний"),
    ERROR("[ERROR]",       "Помилковий"),
    WARNING("[WARNING]",   "Потребує уваги"),
    INFO("[INFO]",         "Інформаційний"),
    DEBUG("[DEBUG]",       "Відладочний");

    private final String klyuchovoSlovo;
    private final String opys;

    LogLevel(String klyuchovoSlovo, String opys) {
        this.klyuchovoSlovo = klyuchovoSlovo;
        this.opys = opys;
    }

    public String otrymatyKlyuchovoSlovo() {
        return klyuchovoSlovo;
    }

    public String otrymatyOpys() {
        return opys;
    }

    @Override
    public String toString() {
        return opys + " " + klyuchovoSlovo;
    }
}
