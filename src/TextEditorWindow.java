import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditorWindow {
    BorderLayout layout;

	public JFrame window;
    public JTextArea textArea;
    public JLabel openFileNameLabel = new JLabel("No file selected");
    public JLabel saveFileNameLabel = new JLabel("No file selected");

    public TextEditorWindow() {
        final String WINDOW_TITLE = "Text Editor";

        // Constructs the window
        window = new JFrame(WINDOW_TITLE);
        window.setTitle(WINDOW_TITLE);
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        // Sets the layout to a border layout
        window.setLayout(layout = new BorderLayout());

        // Creates the labels to display the selected files name

        JPanel labelPanel = new JPanel();

        JLabel openFileLabel = new JLabel("Open File:");
        labelPanel.add(openFileLabel);
        labelPanel.add(openFileNameLabel);

        labelPanel.add(Box.createHorizontalStrut(20));

        JLabel saveFileLabel = new JLabel("Close File:");
        labelPanel.add(saveFileLabel);
        labelPanel.add(saveFileNameLabel);
        labelPanel.setLayout(new FlowLayout());

        openFileNameLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));

        saveFileNameLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(5,5,5,5)
        ));
        // Creates the button panel


        // Setting the Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);

        // Open the .txt file
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {openFile();}
        });

        // Save the .txt file
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {saveFile();}
        });

        // Exits the application
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {closeFile();}
        });

        JMenuItem replaceMenuItem = new JMenuItem("Replace");
        replaceMenuItem.setMnemonic(KeyEvent.VK_R);
        replaceMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {searchAndDestroy();}
        });




        // Setting up the text area
        textArea = new JTextArea();
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Setting up the buttons
        JButton openButton = new JButton("Open");
        openButton.setMnemonic(KeyEvent.VK_O);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.setMnemonic(KeyEvent.VK_S);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });

        JButton replaceButton = new JButton("Replace");
        replaceButton.setMnemonic(KeyEvent.VK_R);
        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {searchAndDestroy();}
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setMnemonic(KeyEvent.VK_X);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(replaceButton);
        buttonPanel.add(exitButton);

        // Tool Tips
        fileMenu.setToolTipText("Open the File Menu (ALT+M)");
        exitMenuItem.setToolTipText("Exit the application (ALT+X)");
        saveMenuItem.setToolTipText("Save the file (ALT+S)");
        openMenuItem.setToolTipText("Open the file (ALT+O)");

        editMenu.setToolTipText("Replace the file (ALT+R)");
        replaceMenuItem.setToolTipText("Replace the file (ALT+R)");

        exitButton.setToolTipText("Exit the application (ALT+X)");
        saveButton.setToolTipText("Save the file (ALT+S)");
        openButton.setToolTipText("Open the file (ALT+O)");


        // Adding components to the window frame
        menuBar.add(fileMenu);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);

        menuBar.add(editMenu);
        editMenu.add(replaceMenuItem);

        window.setJMenuBar(menuBar);

        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        window.add(scrollPane, BorderLayout.CENTER);
        labelPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
        window.add(labelPanel, BorderLayout.NORTH);
        window.add(buttonPanel, BorderLayout.SOUTH);




    }
    public void openFile(){
        // Open file dialog
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int returnVal = fileChooser.showOpenDialog(window);
        // Check if a file was selected
        if(returnVal == JFileChooser.APPROVE_OPTION){
            openFileNameLabel.setText(fileChooser.getSelectedFile().getPath());
            File selectedFile = fileChooser.getSelectedFile();
            try{
                textArea.setText("");
                BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                String line;
                while((line = br.readLine()) != null){
                    textArea.append(line + "\n");
                }
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(window, "Error opening file");
            }

        }else{
            openFileNameLabel.setText("No file selected");
        }
    }

    public void saveFile(){
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (.txt)", "txt");
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);


        int returnVal = fileChooser.showSaveDialog(window);

        if(returnVal == JFileChooser.APPROVE_OPTION){
            saveFileNameLabel.setText(fileChooser.getSelectedFile().getPath());
            File selectedFile = fileChooser.getSelectedFile();

            try{
                if (!selectedFile.getName().endsWith(".txt")){
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
                    saveFileNameLabel.setText(selectedFile.getAbsolutePath());
                }

                BufferedWriter br = new BufferedWriter(new FileWriter(selectedFile));
                br.write(textArea.getText());
                br.close();
            }catch (IOException e){
                JOptionPane.showMessageDialog(window, "Error saving file");
            }
        }else {
            saveFileNameLabel.setText("No file selected");
        }
    }

    public void searchAndDestroy(){
        String searchTxt = JOptionPane.showInputDialog(window, "Enter text to search");
        if(searchTxt == null || searchTxt.isEmpty()){
            JOptionPane.showMessageDialog(window, "Please enter searchTxt to search");
        }

        String newTxt = JOptionPane.showInputDialog(window, "Enter the replacement text");
        if(newTxt == null || newTxt.isEmpty()){
            JOptionPane.showMessageDialog(window, "Please enter the replacement text to search");
        }

        String textToSearch = textArea.getText();
        if (textToSearch == null || textToSearch.isEmpty()){
            JOptionPane.showMessageDialog(window, "Text Box is empty");
        } else {
            if (textToSearch.contains(searchTxt)) {
                textToSearch = textToSearch.replaceAll(searchTxt, newTxt);
                textArea.setText(textToSearch);
            }
            else{
                JOptionPane.showMessageDialog(window, "Search text not found");
            }
        }
    }

    public void closeFile(){System.exit(0);}

    public void  showWindow() {window.setVisible(true);}
}
