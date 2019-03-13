import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyApp extends Frame {
    private int WIDTH;
    private int LENGTH;

    MyApp(int width, int length) {
        WIDTH = width;
        LENGTH = length;
        setSize(width, length);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Random rand = new Random();
        int randomX, randomY, randomSize;
        int minSize=12, maxSize=48;
        char randomChar;
        Color randomColor;

        randomChar = (char)(rand.nextInt(26) + 'a');
        randomX = rand.nextInt(WIDTH);
        randomY = rand.nextInt(LENGTH);
        randomSize = rand.nextInt((maxSize - minSize) + 1) + minSize;
        randomColor = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());

        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        int[] fontVariants = {Font.PLAIN, Font.BOLD, Font.ITALIC, Font.BOLD | Font.ITALIC};
        g.setFont(new Font(fontNames[rand.nextInt(fontNames.length)], fontVariants[rand.nextInt(fontVariants.length)], randomSize));
        g.setColor(randomColor);
        g.drawString(String.valueOf(randomChar), randomX, randomY);
        try {
            Thread.sleep(100);
        }
        catch(Exception e) {
//            System.out.println(e);
        }
        repaint();
    }

//    @Override
//    public void update(Graphics g) {
//        paint(g);
//    }


    public static void main(String[] args) {
        new MyApp(1366, 768);
    }

}


