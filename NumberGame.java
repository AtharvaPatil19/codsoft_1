import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
public class NumberGame extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JTextField display;
	private JTextField input;
	private JTextField tries;
	public int data;
	private int winNum=(1+(int)(Math.random()*100));
	public int tryNum=5;
	public NumberGame() 
	{
		setTitle("Number Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		display = new JTextField();
		display.setEditable(false);
		display.setFont(new Font("Arial Black", Font.BOLD, 55));
		display.setHorizontalAlignment(SwingConstants.CENTER);
		display.setForeground(Color.WHITE);
		display.setBackground(Color.DARK_GRAY);
		display.setBounds(90, 10, 403, 130);
		contentPane.add(display);
		display.setColumns(10);
		display.setText("WELCOME");
		
		input = new JTextField();
		input.setToolTipText("Enter your number here");
		input.setHorizontalAlignment(SwingConstants.CENTER);
		input.setFont(new Font("Tahoma", Font.BOLD, 60));
		input.setBounds(218, 196, 141, 65);
		contentPane.add(input);
		input.setColumns(10);
		
		JButton enter = new JButton("ENTER");
		enter.setFont(new Font("Tahoma", Font.BOLD, 15));
		enter.setBounds(240, 284, 93, 29);
		contentPane.add(enter);
		enter.addActionListener(this);
		
		tries = new JTextField();
		tries.setEditable(false);
		tries.setHorizontalAlignment(SwingConstants.CENTER);
		tries.setFont(new Font("Tahoma", Font.BOLD, 10));
		tries.setBounds(255, 347, 61, 19);
		contentPane.add(tries);
		tries.setColumns(10);
		String s=String.valueOf(tryNum);
		tries.setText(s);
		
		JLabel Ltries = new JLabel("Remaining tries");
		Ltries.setHorizontalAlignment(SwingConstants.CENTER);
		Ltries.setBounds(240, 376, 93, 13);
		contentPane.add(Ltries);
		
	}
	public void actionPerformed(ActionEvent e)
    	{
               	
		String s=input.getText();
        	try
		{
			this.data=Integer.parseInt(s);
		}
		catch(NumberFormatException exp)
		{
			display.setText("INVAID");
		}
		System.out.println(winNum);
		if(data>=0 && data<=100)
		{
			if(tryNum==1)
			{
				display.setText("YOU LOST");
				input.setEditable(false);
				tries.setText("0");
			}
			else if(data==winNum)
			{
				display.setText("YOU WON");
				input.setEditable(false);
				--tryNum;
				String s1=String.valueOf(tryNum);
				tries.setText(s1);
			}
			else if((winNum-data)>=20)
			{
				display.setText("TOO LOW");
				--tryNum;
				String s1=String.valueOf(tryNum);
				tries.setText(s1);
				
			}
			else if((data-winNum)>=20)
			{
				display.setText("TOO HIGH");
				--tryNum;
				String s2=String.valueOf(tryNum);
				tries.setText(s2);
				
			}
			else if((data-winNum)<20 || (winNum-data)<20 )
			{
				display.setText("CLOSE");
				--tryNum;
				String s3=String.valueOf(tryNum);
				tries.setText(s3);
			}
			
		}
		else
			{
				display.setText("INVAID");
			}
		
			
	}

	public static void main(String [] args)
	{
		NumberGame start=new NumberGame();
		start.setVisible(true);
		

	}
}
