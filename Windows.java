public class Windows {
    public static void main(String[] args) {
        Folder folder = new Folder("Folder1", 123);
        folder.printColor();
        System.out.println(folder.getFolderName());

        File file = new File(folder, "File1");
        System.out.println(file.getFileDirectory());
        System.out.println(file.getNameOfFile());


        Shortcut shortcut = new Shortcut(file, "Shortcut1");
        System.out.println(shortcut.openShortcutFile());
    }
}
