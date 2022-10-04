import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder(" ");
        String addDir[] = {
                "C:/Games/Game/src",
                "C:/Games/Game/res",
                "C:/Games/Game/savegames",
                "C:/Games/Game/temp",
                "C:/Games/Game/src/main",
                "C:/Games/Game/src/test",
                "C:/Games/Game/res/drawables",
                "C:/Games/Game/res/vectors",
                "C:/Games/Game/res/icons",
        };
        String addFile[] = {
                "C:/Games/Game/src/main/Main.java",
                "C:/Games/Game/src/main/Utils.java",
                "C:/Games/Game/temp/temp.txt"
        };
        addDirAndLogs(addDir,log);
        addFilesAndLogs(addFile,log);

        try (FileWriter fileWriter = new FileWriter("C:/Games/Game/temp/temp.txt")) {
            fileWriter.write(log.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addDirAndLogs(String[] addDir, StringBuilder log) {
        for (String dirList : addDir) {
            File file = new File(dirList);

                if (file.mkdir()) {
                    log.append("Директория " + dirList + " успешно создана ");
                    log.append("\n");
                } else {
                    log.append("Директория " + dirList + " существует или произошла ошибка");
                }

            }

        }


    public static void addFilesAndLogs(String[] addFile, StringBuilder log) {
        for (String fileList : addFile) {
            File file = new File(fileList);
            try {
                if (file.createNewFile()) {
                    log.append("Файл " + fileList + " успешно создан");
                    log.append("\n");
                }else{
                    log.append("Не удалось создать файл " + fileList + " такой файл существует");
                    log.append("\n");
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}