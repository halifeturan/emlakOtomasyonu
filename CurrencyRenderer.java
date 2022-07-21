package design;

import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Font;
import java.awt.Component;

public class CurrencyRenderer extends DefaultTableCellRenderer {

    private Font boldFont;

    public CurrencyRenderer() {
        setHorizontalAlignment(JLabel.RIGHT);
        boldFont = getFont().deriveFont(Font.BOLD);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof Double) {
            value = NumberFormat.getCurrencyInstance().format(value);
        }

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setFont(boldFont);

        return this;
    }

}