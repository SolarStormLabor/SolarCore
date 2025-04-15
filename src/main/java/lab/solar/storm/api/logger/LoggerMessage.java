package lab.solar.storm.api.logger;

import java.time.LocalDateTime;

public class LoggerMessage {
    private final LoggerType type;
    private final String text;
    private final LocalDateTime timeStamp;

    public LoggerMessage(LoggerType type, String text, LocalDateTime timeStamp) {
        this.type = type;
        this.text = text;
        this.timeStamp = timeStamp;
    }

    public LoggerType getType() {return type;}

    public String getText() {return text;}

    public LocalDateTime getTimeStamp() {return timeStamp;}
}
