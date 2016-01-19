import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainFrame extends JFrame{

	// create buttons
    private JPanel contentPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4; 
    private JButton button5;
    
    private JLabel label;

    public MainFrame()  {
    	// setting default behavior
        super("Book Sort");
        setSize(new Dimension(600, 500));
        setLocationRelativeTo(null);
        initContentPane();
        initContents();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initContentPane() {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new GridLayout(2, 1));
    }

    private void initContents() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        button1 = new JButton("Ordered By Length");
        button2 = new JButton("Ordered By Rating");
        button3 = new JButton("Ordered By Author");
        button4 = new JButton("Ordered By Title"); 
        button5 = new JButton("Recommendation");
        
        // action listeners for buttons
        
        button1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JTableUsage jt = new JTableUsage();
        		try {
					jt.start(1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
        	}
        });
        
        button2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JTableUsage jt = new JTableUsage();
        		try {
					jt.start(2);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
        	}
        });
        
        button3.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JTableUsage jt = new JTableUsage();
        		try {
					jt.start(3);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        button4.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		JTableUsage jt = new JTableUsage();
        		try {
					jt.start(4);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
        	}
        });
        
        button5.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try {
					Recommender rec = new Recommender();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
        	}
        });
        //buttonPanel.add(button);

        JPanel labelPanel = new JPanel(new FlowLayout());
        label = new JLabel("Book Sort");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        labelPanel.add(label);
        
        //add buttons to screen
        
        buttonPanel.add(button1, BorderLayout.SOUTH);
        buttonPanel.add(button2, BorderLayout.SOUTH);
        buttonPanel.add(button3, BorderLayout.SOUTH);
        buttonPanel.add(button4, BorderLayout.SOUTH);
        buttonPanel.add(button5, BorderLayout.SOUTH);
        
        contentPane.add(labelPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

	}

