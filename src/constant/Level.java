package constant;

public enum Level {
    GS_TS("Giáo sư - Tiến sỹ"),
    PGS_TS("Phó giáo sư - Tiến sỹ"),
    GVC("Giáo viên chính"),
    TS("Thạc sỹ");

    public String value;

    Level(String value) {
        this.value = value;
    }
}
