package color;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame implements ActionListener {

	private JLabel label = new JLabel("Color Chooser");
	private JButton button = new JButton("OK");

	public MyFrame() {
		setTitle("Color Chooser");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label.setFont(new Font("Ravie", Font.ITALIC, 30));

		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(button);

		button.addActionListener(this);

		add(panel);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			JColorChooser chooser = new JColorChooser();
			Color color = chooser.showDialog(null, "Color", Color.BLUE);

			if (color != null) {
				label.setForeground(color);
			}

		}
	}

}

public class Test {
	public static void main(String[] args) {
		new MyFrame();
	}
}
