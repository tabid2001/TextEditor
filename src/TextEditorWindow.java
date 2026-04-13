import TextEditorButtons.ExitButton;
import javax.swing.*;

public class TextEditorWindow
{
	private JFrame window;
    private JTextArea textArea;
    private JPanel panel;
    public TextEditorWindow() {
        final String WINDOW_TITLE = "Text Editor";

        window = new JFrame(WINDOW_TITLE);
        window.setTitle(WINDOW_TITLE);
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

    }
    public void  showWindow()
    {
        window.setVisible(true);
    }
}
