// Hello.java (Java SE 5)
import javax.swing.*;

public class SwingHello extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SwingHello() {
        super("hello");
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.add(new JLabel("Hello, world!"));
        super.pack();
        super.setVisible(true);
    }

    public static void main(final String[] args) {
        new SwingHello();
    }
}
