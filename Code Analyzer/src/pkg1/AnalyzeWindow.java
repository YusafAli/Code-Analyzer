package pkg1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JPanel contentPane;
	public AnalyzeWindow(String addr) 
	{
		setVisible(true);
		setTitle("Analyze Window");
		setResizable(false);
		addrOfFile = new String(addr);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		working();
	}
	
	public void working()
	{
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 45, 267, 216);
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
				textArea.setText(textArea.getText()+"\n"+mod2.getResult());
				mod2.displayAllVariable();
			}
		});
		
		JLabel lblClickOnThe = new JLabel("Click on the buttons to see the results");
		lblClickOnThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClickOnThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblClickOnThe.setBounds(10, 11, 424, 23);
		
		contentPane.setLayout(null);
		contentPane.add(btnVariable);
		contentPane.add(btnPercentComment);
		contentPane.add(lblClickOnThe);
		contentPane.add(scrollPane);
		
		
	}
}