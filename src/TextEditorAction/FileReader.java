package TextEditorAction;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.io.FilenameFilter;

public class FileReader {
    private String filePath;
    private String fileName;

    public String FileOpener(){
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);

        // Restricting the user to .txt file types
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter fileTypeFilter = new FileNameExtensionFilter("Only .txt files","txt");
        fileChooser.setFileFilter(fileTypeFilter);

        int returnVal = fileChooser.showOpenDialog(null);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getAbsolutePath();
        }else {
            return null;
        }
    }

    private String FileSave(){
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);

        fileChooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter fileTypeFilter = new FileNameExtensionFilter("Only .txt","txt");
        fileChooser.setFileFilter(fileTypeFilter);

        int returnVal = fileChooser.showSaveDialog(null);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
}
