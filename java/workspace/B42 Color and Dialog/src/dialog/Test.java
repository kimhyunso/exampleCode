package dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog implements ActionListener {

	private JTextField input = new JTextField(15);
	private JButton okBtn = new JButton("OK");

	public MyDialog(JFrame frame, String title) {

		super(frame, title, true);
		this.setTitle(title);
		this.setSize(300, 200);
		this.setLayout(new FlowLayout());

		okBtn.addActionListener(this);

		this.add(input);
		this.add(okBtn);
	}

	public String getInput() {
		if (input.getText().equals("")) {
			return null;
		} else {
			return input.getText();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okBtn) {
			this.setVisible(false);
		}
	}

}

class MyFrame extends JFrame implements ActionListener {

	private MyDialog dialog;
	private JButton btn;

	public MyFrame() {
		setTitle("Dialog");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog = new MyDialog(this, "TestDialog");
		btn = new JButton("Show Dialog");
		btn.addActionListener(this);
		add(btn);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn) {
			System.out.println("btn is Checked!");
			dialog.setVisible(true);

			String msg = dialog.getInput();
			if (msg != null) {
				btn.setText(msg);
			}
		}

	}

}

public class Test {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}
}
