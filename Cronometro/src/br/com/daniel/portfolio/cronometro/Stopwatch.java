package br.com.daniel.portfolio.cronometro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Stopwatch implements ActionListener{

	JFrame frame = new JFrame();
	JButton startButton = new JButton("Começar");
//	JButton stopButton = new JButton("Parar");
	JButton resetButton = new JButton("Recomeçar");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String secondsString = String.format("%02d", seconds);
	String minutesString = String.format("%02d", minutes);
	String hoursString = String.format("%02d", hours);
	
	Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elapsedTime+=1000;
			hours = (elapsedTime / 3600000);
			minutes = (elapsedTime / 60000) % 60;
			seconds = (elapsedTime / 1000) % 60;
			secondsString = String.format("%02d", seconds);
			minutesString = String.format("%02d", minutes);
			hoursString = String.format("%02d", hours);
			timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
			
		}
	});
	
	public Stopwatch() {
		
		timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
		timeLabel.setBounds(100, 100, 200, 100);
		timeLabel.setFont(new Font("Arial", Font.PLAIN, 50));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(100, 200, 100, 50);
		startButton.setFont(new Font("Arial", Font.BOLD, 10));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200, 200, 100, 50);
		resetButton.setFont(new Font("Arial", Font.BOLD, 10));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		while (true) {
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			if (started == false) {
				started = true;
				startButton.setText("Parar");
				start();
			}else {
				started = false;
				startButton.setText("Começar");
				stop();
			}
		}
		
		if (e.getSource() == resetButton) {
			started = false;
			startButton.setText("Começar");
			reset();
		}
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}

	void reset() {
		timer.stop();
		elapsedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		secondsString = String.format("%02d", seconds); //isso poderia estar melhor escrito e encapsulado mas está tarde e estou com preguiça kkkk
		minutesString = String.format("%02d", minutes);
		hoursString = String.format("%02d", hours);
		timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
	}
}
