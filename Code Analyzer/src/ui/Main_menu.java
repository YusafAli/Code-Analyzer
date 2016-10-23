package ui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import code.FileSelector;
import code.M_PercentComment;
import code.M_VariableStyle;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
		setBounds(50, 50, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setContentPane_1();
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
	public void setContentPane_1()
	{
		fileAddressField = new JTextField();
		fileAddressField.setBounds(10, 239, 825, 20);
		fileAddressField.setColumns(10);
		fileAddressField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) 
			{
				addrOfFile = new String(fileAddressField.getText());
				JOptionPane.showMessageDialog(null, "Successfuly address chukliya");
			}
		});
		
		btnBrowseFile = new JButton("Browse File");
		btnBrowseFile.setBounds(845, 238, 89, 23);
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
		btnAnalyze.setBounds(746, 438, 89, 23);
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
					contentPane.removeAll();
					setContentPane_2();
					contentPane.revalidate();
					contentPane.repaint();
					/*
					@SuppressWarnings("unused")
					AnalyzeWindow window21 = new AnalyzeWindow(addrOfFile);*/

				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Code Analyzer");
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 194, 45);
		
		JButton btnCancel = new JButton("Exit");
		btnCancel.setBounds(845, 438, 89, 23);
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
		txtrPleaseSelectA.setText("This program analyzes only CPlusPlus source code.\r\n\r\nSelect a source code file with the extension of cpp. You can also type the address of your file, press enter after that.");
		txtrPleaseSelectA.setLineWrap(true);
		txtrPleaseSelectA.setBounds(10, 67, 510, 107);

		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(btnCancel);
		contentPane.add(txtrPleaseSelectA);
		contentPane.add(fileAddressField);
		contentPane.add(btnBrowseFile);
		contentPane.add(btnAnalyze);
	}
	public void setContentPane_2()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 44, 755, 383);
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JButton btnPercentComment = new JButton("Percent Comment");
		btnPercentComment.setBounds(10, 45, 125, 25);
		btnPercentComment.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e1)
			{
				M_PercentComment mod1 = new M_PercentComment();
				mod1.setfileAddress(addrOfFile);
				try {mod1.doProcess();} catch (IOException exception1) {exception1.printStackTrace();}
				//textArea.setText(mod1.getOriginalCode());
				textArea.setText(mod1.displayAllLoc());
			}
		});

		JButton btnVariable = new JButton("Variable Style");
		btnVariable.setBounds(10, 100, 125, 25);
		btnVariable.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e2)
			{
				M_VariableStyle mod2 = new M_VariableStyle();
				mod2.setfileAddress(addrOfFile);
				try {mod2.doProcess();} catch (IOException exception1) {exception1.printStackTrace();}
				textArea.setText(mod2.getResult());
			}
		});
		
		JLabel lblClickOnThe = new JLabel("Click on the buttons to see the results");
		lblClickOnThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClickOnThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblClickOnThe.setBounds(10, 11, 424, 23);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(845, 438, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(746, 438, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addrOfFile = new String("");
				contentPane.removeAll();
				setContentPane_1();
				contentPane.revalidate();
				contentPane.repaint();
			}
		});
		
		contentPane.setLayout(null);
		contentPane.add(btnVariable);
		contentPane.add(btnPercentComment);
		contentPane.add(lblClickOnThe);
		contentPane.add(scrollPane);
		contentPane.add(btnExit);
		contentPane.add(btnBack);
	}
}
