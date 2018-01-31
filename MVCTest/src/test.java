import javax.swing.JFrame;

public class test {
	public static void main(String[] args) {
		TextViewPane view = new TextViewPane();
		TextModel model = new SimpleTextModel();
		TextViewController controller = new SimpleTextController(view, model);
		
		JFrame frame = new JFrame("Testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(view);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
