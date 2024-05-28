package com.gautam.sujal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1: Who is the Prime Minister of India ?");
			radioButton[0].setText("Rahul Gandhi");
			radioButton[1].setText("Narendra Modi");
			radioButton[2].setText("Yogi AdityaNath");
			radioButton[3].setText("Akhilesh Yadav");
		}
		if (current == 1) {
			label.setText("Que2: Who is the President of India ?");
			radioButton[0].setText("Shyam Nath Kovind");
			radioButton[1].setText("Ram Nath Kovind");
			radioButton[2].setText("Hari Nath Kovind");
			radioButton[3].setText("Pari Nath Kovind");
		}
		if (current == 2) {
			label.setText("Que3: Who is current CEO of GOOGLE ? ");
			radioButton[0].setText("Sundar Pichai");
			radioButton[1].setText("Sunder Lal");
			radioButton[2].setText("Larry Page");
			radioButton[3].setText("Steve Jobs");
		}
		if (current == 3) {
			label.setText("Que4: When India got its Independence ?");
			radioButton[0].setText("15 AUG 1943");
			radioButton[1].setText("15 AUG 1946");
			radioButton[2].setText("15 AUG 1947");
			radioButton[3].setText("15 AUG 1940");
		}
		if (current == 4) {
			label.setText("Que5: Who is first Prime Minister of India ?");
			radioButton[0].setText("Jawahal Lal Nehru");
			radioButton[1].setText("Indra Gandhi");
			radioButton[2].setText("Rahul Gandhi");
			radioButton[3].setText("Moti Lal Nehru");
		}
		if (current == 5) {
			label.setText("Que6: There are how many Continents in the World ?");
			radioButton[0].setText("Seven");
			radioButton[1].setText("Eight");
			radioButton[2].setText("Nine");
			radioButton[3].setText("Six");
		}
		if (current == 6) {
			label.setText("Que7: How many percent of World is coverd with Ocean ?");
			radioButton[0].setText("72%");
			radioButton[1].setText("71%");
			radioButton[2].setText("78%");
			radioButton[3].setText("73%");
		}
		if (current == 7) {
			label.setText("Que8: In Olympic Symbol what 5 rings represent ?");
			radioButton[0].setText("Spirit of Games");
			radioButton[1].setText("Peace");
			radioButton[2].setText("Numbers of Continents");
			radioButton[3].setText("None of the Above");
		}
		if (current == 8) {
			label.setText("Que9: Who is the current President of USA ?");
			radioButton[0].setText("Joe Biden");
			radioButton[1].setText("Donald Trump");
			radioButton[2].setText("Brack Obama");
			radioButton[3].setText("Narendra Modi");
		}
		if (current == 9) {
			label.setText("Que10: Who is the current Chairman of Indian Space Research Organisation(ISRO) ?");
			radioButton[0].setText("Dr. K. Sivan");
			radioButton[1].setText("Dr. X. Sivan");
			radioButton[2].setText("Dr. S. Sivan");
			radioButton[3].setText("Dr. A. Sivan");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}