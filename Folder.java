public class Folder {
    private String nameOfFolder = "";
    private int color = 0;

    Folder(String nameOfFolder, int color) {
        this.nameOfFolder = nameOfFolder;
        this.color = color;
    }

    int getColor() {
        return color;
    }

    void printColor(){
        System.out.println("Color of the folder is: " + getColor());
    }

    String getFolderName() {
        return nameOfFolder;
    }
}

