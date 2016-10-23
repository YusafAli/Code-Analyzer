package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.M_PercentComment;
import code.M_VariableStyle;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class AnalyzeWindow extends JFrame 
{
	private String addrOfFile = new String("");
	private JPanel contentPane_2;
	public AnalyzeWindow(String addr) 
	{
		setResizable(false);
		setVisible(true);
		setTitle("Analyze Window");
		addrOfFile = new String(addr);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane_2 = new JPanel();
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_2);
		working();
	}
	
	public void working()
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
				
			}
		});
		
		contentPane_2.setLayout(null);
		contentPane_2.add(btnVariable);
		contentPane_2.add(btnPercentComment);
		contentPane_2.add(lblClickOnThe);
		contentPane_2.add(scrollPane);
		contentPane_2.add(btnExit);
		contentPane_2.add(btnBack);
		
		
		
	}
}