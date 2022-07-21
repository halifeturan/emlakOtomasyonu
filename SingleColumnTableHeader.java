package design;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class SingleColumnTableHeader extends JTableHeader{

    private JLabel renderer;

    public SingleColumnTableHeader() {
        setBackground(Color.WHITE);
        renderer = new JLabel("ILANLAR");
    	renderer.setHorizontalAlignment(SwingConstants.CENTER);
        renderer.setBorder(new EmptyBorder(4, 0, 4, 0));
    }

    @Override
    public Dimension getPreferredSize() {
        return renderer.getPreferredSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        FontMetrics fm = g2d.getFontMetrics();

        Insets insets = getInsets();
        int width = getWidth() - (insets.left + insets.right);
        int height = getHeight() - (insets.top + insets.bottom);

        renderer.setBounds(insets.left, insets.top, width, height);
        renderer.paint(g2d);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(insets.left, insets.top + height - 1, insets.left + width, insets.top + height - 1);

        g2d.dispose();
    }

}
