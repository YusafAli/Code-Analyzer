package pkg1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Main_menu extends JFrame {

	private JPanel contentPane;
	private JTextField fileAddressField;
	private JButton btnAnalyze;
	private JButton btnBrowseFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Main_menu frame = new Main_menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private String addrOfFile = new String("");
	public Main_menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Code Analyzer");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\SARA\\Tazim\\Images\\Animals\\cat.jpg"));
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		fileAddressField = new JTextField();
		fileAddressField.setBounds(10, 239, 459, 20);
		fileAddressField.setColumns(10);
		fileAddressField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) 
			{
				addrOfFile = new String(fileAddressField.getText());
				JOptionPane.showMessageDialog(null, "Successfuly address chukliya");
			}
		});
		
		btnBrowseFile = new JButton("Browse File");
		btnBrowseFile.setBounds(479, 238, 89, 23);
		btnBrowseFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e1)
			{
				FileSelector obj1 = new FileSelector(contentPane);
				obj1.openAFile();
				addrOfFile = new String(obj1.getAddressOfFile());
				fileAddressField.setText(addrOfFile);
			}
		});
		
		btnAnalyze = new JButton("Analyze");
		btnAnalyze.setBounds(382, 316, 89, 23);
		btnAnalyze.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e2)
			{
				if(addrOfFile.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please select a file");
				}
				else 
				{
					@SuppressWarnings("unused")
					AnalyzeWindow window21 = new AnalyzeWindow(addrOfFile);
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Code Analyzer");
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 194, 45);
		
		JButton btnCancel = new JButton("Exit");
		btnCancel.setBounds(479, 316, 89, 23);
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e4)
			{
				System.exit(0);
			}
		});
		
		JTextArea txtrPleaseSelectA = new JTextArea();
		txtrPleaseSelectA.setBackground(SystemColor.menu);
		txtrPleaseSelectA.setEditable(false);
		txtrPleaseSelectA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrPleaseSelectA.setWrapStyleWord(true);
		txtrPleaseSelectA.setText("This program analyzes only CPlusPlus source code.\r\n\r\nSelect a source code file with extension of cpp. You can also type the address of your file, press enter after that.");
		txtrPleaseSelectA.setLineWrap(true);
		txtrPleaseSelectA.setBounds(10, 67, 510, 107);
		
		contentPane.add(lblNewLabel);
		contentPane.add(btnCancel);
		contentPane.add(txtrPleaseSelectA);
		contentPane.setLayout(null);
		contentPane.add(fileAddressField);
		contentPane.add(btnBrowseFile);
		contentPane.add(btnAnalyze);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
}
