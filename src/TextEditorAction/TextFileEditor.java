package TextEditorAction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TextFileEditor {
    public void TextFileSave(){
        String filePath = FileHandler.FileSave();


    }
    public void TextFileOpen(){
        String filePath = FileHandler.FileOpener();

    }
}
