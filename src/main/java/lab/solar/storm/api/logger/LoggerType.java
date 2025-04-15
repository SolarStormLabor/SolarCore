package lab.solar.storm.api.logger;

public enum LoggerType {
    ERROR("\033[31m[ERROR]\033[0m", "\033[31m", 4),
    WARNING("\033[33m[WARNING]\033[0m", "\033[33m", 3),
    SOFT_WARNING("\033[33m[WARNING]\033[0m", "\033[0m", 2),
    DEBUG("\033[36m[LABOR]\033[0m", "\033[90m", 1),
    INFO("\033[0m[SOLAR]\033[0m", "\033[90m", 0);

    private final String prefix;
    private final String color;
    private final int level;

    LoggerType(String prefix, String color, int level) {
        this.prefix = prefix;
        this.color = color;
        this.level = level;
    }

    public String getTypePrefix() {return prefix;}

    public String getTypeColor() {return color;}

    public int getTypeLevel() {return level;}

}