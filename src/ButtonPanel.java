import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ButtonPanel extends JPanel{

    private JButton openButton;
    private JButton saveButton;
    private JButton exitButton;


    public ButtonPanel(){
        setLayout(new FlowLayout());

        openButton = new JButton("Open");
        openButton.setMnemonic(KeyEvent.VK_O);

        saveButton = new JButton("Save");
        saveButton.setMnemonic(KeyEvent.VK_S);

        exitButton = new JButton("Exit");
        exitButton.setMnemonic(KeyEvent.VK_X);

        add(openButton);
        add(saveButton);
        add(exitButton);

        openButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            };
        });

        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });





    }
}
