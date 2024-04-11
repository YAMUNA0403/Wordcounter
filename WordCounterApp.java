import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {

    private JTextArea textArea;
    private JLabel countLabel;

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create text area for user input
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create button to trigger word counting
        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        // Create label to display word count
        countLabel = new JLabel("Word Count: 0");

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(countLabel, BorderLayout.NORTH);
    }

    private void countWords() {
        String text = textArea.getText();
        String[] words = text.trim().split("\\s+"); // Split text into words using whitespace as delimiter
        int wordCount = words.length;
        countLabel.setText("Word Count: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounterApp app = new WordCounterApp();
                app.setVisible(true);
            }
        });
    }
}
