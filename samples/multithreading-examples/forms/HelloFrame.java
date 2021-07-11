import javax.swing.*;
import java.awt.*;

public class HelloFrame extends JFrame {

    // Frame Constructor: creates a new frame object visible to human eyes
    public HelloFrame() {
        // construct window form
        super("Hello App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        /* adding components */
        // window label
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Charles Ng");
        nameLabel.setBounds(40, 20, 100, 30);
        add(nameLabel);

        // text field
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(160, 20, 100, 30);
        add(nameTextField);
        
        JPanel greenPanel = new JPanel();
        greenPanel.setBounds(40, 150, 220, 70);
        greenPanel.setLayout(new BorderLayout());
        greenPanel.setBackground(Color.GREEN);
        add(greenPanel);

        // create button
        JButton acceptButton = new JButton("Accept");
        acceptButton.setBounds(100, 70, 100, 30);
        add(acceptButton);

        JLabel helloLabel = new JLabel("Hello");
        helloLabel.setBounds(50, 20, 100, 30);
        helloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        helloLabel.setVerticalAlignment(SwingConstants.CENTER);

        Font font = new Font("JetBrainsMono NF", Font.BOLD, 12);
        helloLabel.setFont(font);
        helloLabel.setFont(helloLabel.getFont().deriveFont(16f));
        
        greenPanel.add(helloLabel);
        
        //acceptButton.addActionListener(new ActionListener() {
            //public void actionPerformed(ActionEvent e) {
                //String helloText = "Hello";
                //String name = nameTextField.getText();
                //if (name != null && name.trim().length() > 0) {
                    //helloText += String.format(", %s", name);
                //}
                //helloLabel.setText(helloText);
            //}
        //});
        acceptButton.addActionListener(event -> {
            String helloText = "Hello";
            String name = nameTextField.getText();
            if (name != null && name.trim().length() > 0) {
                helloText += String.format(", %s", name);
            }
            helloLabel.setText(helloText);
        });
    }

    // main thread: create and invoke the frame object in the main thread
    public static void main(String[] args) throws Exception {
        new HelloFrame();
        //Runnable initFrame = new Runnable() {
            //@Override
            //public void run() {
                //new HelloFrame();
            //}
        //};
        //SwingUtilities.invokeAndWait(initFrame);
        //SwingUtilities.invokeLater(initFrame);
    }
}
