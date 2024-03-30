import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search extends JFrame implements ActionListener {
    private JTextField keywordField;
    private JTextArea resultArea;
    private String[] websites = {
            "www.example.com",
            "www.stackoverflow.com",
            "www.github.com",
            "www.google.com",
            "www.wikipedia.org",
            "www.yahoo.com",
            "www.amazon.com",
            "www.microsoft.com",
            "www.apple.com",
            "www.cnn.com",
            "www.bbc.com",
            "www.nytimes.com",
            "www.linkedin.com",
            "www.instagram.com",
            "www.twitter.com",
            "www.facebook.com",
            "www.reddit.com",
            "www.spotify.com",
            "www.netflix.com",
            "www.ebay.com",
            "www.paypal.com",
            "www.udemy.com",
            "www.coursera.org",
            "www.khanacademy.org",
            "www.codecademy.com",
            "www.geeksforgeeks.org",
            "www.javatpoint.com",
            "www.tutorialspoint.com",
            "www.w3schools.com",
            "www.oracle.com",
            "www.apache.org",
            "www.gnu.org",
            "www.cnet.com",
            "www.weather.com",
            "www.aljazeera.com",
            "www.nationalgeographic.com",
            "www.reuters.com",
            "www.bloomberg.com",
            "www.ft.com"
    };

    public Search() {
        setTitle("Simple Search Engine");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        JLabel keywordLabel = new JLabel("Enter a keyword: ");
        keywordField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        inputPanel.add(keywordLabel);
        inputPanel.add(keywordField);
        inputPanel.add(searchButton);
        add(inputPanel, BorderLayout.NORTH);
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            String keyword = keywordField.getText().toLowerCase(); 
            StringBuilder searchResults = new StringBuilder();

            boolean found = false;
            for (String website : websites) {
                if (website.toLowerCase().contains(keyword)) { 
                    searchResults.append(website).append("\n");
                    found = true;
                }
            }

            if (found) {
                resultArea.setText("Search results:\n" + searchResults.toString());
            } else {
                resultArea.setText("No matching websites found for the keyword: " + keyword);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Search());
    }
}