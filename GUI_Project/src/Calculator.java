import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener{
	JPanel display_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JTextField display = new JTextField(" ",11);
	JButton[] buttons = new JButton[10];
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton product = new JButton("x");
	JButton divide = new JButton("/");
	JButton c = new JButton("c");
	JButton equal = new JButton("=");
	Font f = new Font("Dialog", Font.BOLD, 30);
	
	public MyFrame() {
		setTitle("계산기");
		setSize(300,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(new BorderLayout());
		
		display_panel.setLayout(new FlowLayout());
		button_panel.setLayout(new GridLayout(4,4));
		
		display.setFont(new Font("Dialog", Font.PLAIN, 30));
		display.setHorizontalAlignment(JTextField.RIGHT);
		display_panel.add(display);
		
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton(i+"");
			buttons[i].addActionListener(this);
			buttons[i].setFont(new Font("Dialog",Font.PLAIN,30));
			buttons[i].setBackground(Color.LIGHT_GRAY);
		}
		
		plus.addActionListener(this);
		minus.addActionListener(this);
		product.addActionListener(this);
		divide.addActionListener(this);
		c.addActionListener(this);
		equal.addActionListener(this);
		
		plus.setFont(f);
		minus.setFont(f);
		product.setFont(f);
		divide.setFont(f);
		c.setFont(f);
		equal.setFont(f);
		// c x / =
		// 7 8 9 +
		// 4 5 6 -
		// 1 2 3 0
		button_panel.add(c);
		button_panel.add(product);
		button_panel.add(divide);
		button_panel.add(equal);
		button_panel.add(buttons[7]);
		button_panel.add(buttons[8]);
		button_panel.add(buttons[9]);
		button_panel.add(plus);
		button_panel.add(buttons[4]);
		button_panel.add(buttons[5]);
		button_panel.add(buttons[6]);
		button_panel.add(minus);
		button_panel.add(buttons[1]);
		button_panel.add(buttons[2]);
		button_panel.add(buttons[3]);
		button_panel.add(buttons[0]);
		
		add(display_panel, BorderLayout.NORTH);
		add(button_panel, BorderLayout.CENTER);
		
		display.setEditable(false);
		
		c.setForeground(Color.white);
		plus.setForeground(Color.green);
		minus.setForeground(Color.green);
		product.setForeground(Color.green);
		divide.setForeground(Color.green);
		equal.setForeground(Color.GREEN);
		
		plus.setBackground(Color.GRAY);
		minus.setBackground(Color.GRAY);
		product.setBackground(Color.GRAY);
		divide.setBackground(Color.GRAY);
		equal.setBackground(Color.GRAY);
		buttons[0].setBackground(Color.GRAY);
		c.setBackground(Color.red);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		String num = b.getText();
		
		if(num.equals("c")) {
			display.setText(" ");
		}else if(num.equals("=")){
			String result = Double.toString(calculation(display.getText()));
			display.setText(result);
		}else {
			display.setText(display.getText()+num);
		}
	}
	
	public double calculation(String input) {
		double result=0;
		double num1 , num2 =0;
		if(input.contains("+")) {
			StringTokenizer st = new StringTokenizer(input, "+");
			num1 = Double.parseDouble(st.nextToken());
			num2 = Double.parseDouble(st.nextToken());
			result = num1 + num2;
		}
		if(input.contains("-")) {
			StringTokenizer st = new StringTokenizer(input, "-");
			num1 = Double.parseDouble(st.nextToken());
			num2 = Double.parseDouble(st.nextToken());
			result = num1 - num2;
		}
		if(input.contains("x")) {
			StringTokenizer st = new StringTokenizer(input, "x");
			num1 = Double.parseDouble(st.nextToken());
			num2 = Double.parseDouble(st.nextToken());
			result = num1 * num2;
		}
		if(input.contains("/")) {
			StringTokenizer st = new StringTokenizer(input, "/");
			num1 = Double.parseDouble(st.nextToken());
			num2 = Double.parseDouble(st.nextToken());
			result = num1 / num2;
		}
		return result;
	}
}

public class Calculator {
	public static void main(String[] args) {
		new MyFrame();
	}
}
