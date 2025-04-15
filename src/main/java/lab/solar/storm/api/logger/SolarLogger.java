package lab.solar.storm.api.logger;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class SolarLogger {
    private static CommandSender logger;
    private static List<LoggerMessage> log;
    private static LocalDateTime startTimeStamp;

    static {
        logger = Bukkit.getConsoleSender();
        startTimeStamp = LocalDateTime.now();

        deleteLogFiles();
    }

    private static void deleteLogFiles() {
        File latestLog = new File("solar/logs/latest.log");
        File startTimeLog = new File("solar/logs/" + startTimeStamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".log");

        try {
            if (latestLog.exists()) {
                latestLog.delete();
            }
            if (startTimeLog.exists()) {
                startTimeLog.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void log(LoggerType type, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        String logMessage = type.getTypePrefix() + " " + type.getTypeColor() + message + "\033[0m";

        logger.sendMessage(logMessage);

        log.add(new LoggerMessage(type, message, LocalDateTime.now()));

        writeToLogFiles("[" + timestamp + "] : " + removeEscapeSequences(logMessage));
    }

    private static void writeToLogFiles(String message) {
        try {
            FileWriter latestLogWriter = new FileWriter("solar/logs/latest.log", false);
            PrintWriter latestLogPrinter = new PrintWriter(latestLogWriter);
            latestLogPrinter.println(message);
            latestLogPrinter.close();

            FileWriter startLogWriter = new FileWriter("solar/logs/" + startTimeStamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".log", false);
            PrintWriter startLogPrinter = new PrintWriter(startLogWriter);
            startLogPrinter.println(message);
            startLogPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String removeEscapeSequences(String message) {
        return message.replaceAll("\033\\[[;\\d]*m", "");
    }

    public static void info(String message) { log(LoggerType.INFO, message); }
    public static void debug(String message) { log(LoggerType.DEBUG, message); }
    public static void softWarn(String message) { log(LoggerType.SOFT_WARNING, message); }
    public static void warn(String message) { log(LoggerType.WARNING, message); }
    public static void error(String message) { log(LoggerType.ERROR, message); }

    public static void sendMessage(String message) {logger.sendMessage(message);}
}
