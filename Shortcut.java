public class Shortcut extends File {
    private String shortcutName;

    Shortcut(String nameOfFolder, String nameOfFile, int color, String shortcutName) {
        super(nameOfFolder, nameOfFile, color);
        this.shortcutName = shortcutName;
    }

    Shortcut(File file, String shortcutName) {
        super(file.getFolderName(), file.getNameOfFile(), file.getColor());
        this.shortcutName = shortcutName;
    }

    String openShortcutFile() {
        return shortcutName +": " + getFileDirectory();
    }
}
