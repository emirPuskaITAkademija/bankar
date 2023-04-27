package ba.bank.bank.transfer;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * NumericAndLengthFilter object = new ...
 */
public class NumericAndLengthFilter extends DocumentFilter {
    /**
     * Number of characters allowed.
     */
    private int length = 0;
    /**
     * Restricts the number of charcacters can be entered by given length.
     *
     * @param length Number of characters allowed.
     */
    public NumericAndLengthFilter(int length) {
        this.length = length;
    }
    @Override
    public void insertString(FilterBypass fb, int offset, String string,
                             AttributeSet attr) throws BadLocationException {
        if (isNumeric(string)) {
            if (this.length > 0 && fb.getDocument().getLength() + string.length() > this.length) {
                return;
            }
            super.insertString(fb, offset, string, attr);
        }
    }
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        if (isNumeric(text)) {
            if (this.length > 0 && fb.getDocument().getLength() + text.length() > this.length) {
                return;
            }
            super.insertString(fb, offset, text, attrs);
        }
    }

    /**
     * HOMEWORK : dopustiti unos decimalnih brojeva
     * <p>
     *     Evropski standard unosa decimalnih brojeva poštovati.
     *     Dozvoliti zarez i tačku .
     * </p>
     * @param text
     * @return
     */
    private boolean isNumeric(String text) {
        if (text == null || text.trim().equals("")) {
            return false;
        }
        for (int iCount = 0; iCount < text.length(); iCount++) {
            if (!Character.isDigit(text.charAt(iCount))) {
                return false;
            }
        }
        return true;
    }
}
