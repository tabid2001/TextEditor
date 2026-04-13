import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditorWindow {
    BorderLayout layout;

	private JFrame window;
    private JTextArea textArea;
    private JPanel panel;
    private JMenuBar menuBar;

    public TextEditorWindow() {
        final String WINDOW_TITLE = "Text Editor";

        window = new JFrame(WINDOW_TITLE);
        window.setTitle(WINDOW_TITLE);
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);


        window.setLayout(layout = new BorderLayout());

        // Setting the Menu Bar
        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        // Open the .txt file
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Save the .txt file
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Exits the application
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Setting up the text area
        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Setting up the buttons
        ButtonPanel buttonPanel = new ButtonPanel();

        // Tool Tips
        exitMenuItem.setToolTipText("Exit the application");

        // Adding components to the window frame
        menuBar.add(fileMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        window.setJMenuBar(menuBar);

        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        window.add(scrollPane, BorderLayout.CENTER);
        window.add(buttonPanel, BorderLayout.SOUTH);




    }
    public void  showWindow()
    {
        window.setVisible(true);
    }
}
