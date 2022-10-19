public class File extends Folder {

    private String nameOfFile = "";

    File(String nameOfFolder, String nameOfFile, int color) {
        super(nameOfFolder, color);
        this.nameOfFile = nameOfFile;
    }

    File(Folder folder, String nameOfFile) {
        super(folder.getFolderName(), folder.getColor());
        this.nameOfFile = nameOfFile;
    }

    String getFileDirectory() {
        return "home/" + nameOfFile + "/" + getFolderName();
    }

    String getNameOfFile() {
        return nameOfFile;
    }
}
