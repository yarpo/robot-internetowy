/*
 * Klasa implementujaca ILogger, pozwalajaca na wypisywanie danych o dzialaniu
 * programu na ekranie
 */
package robotinternetowy.logger;
/**
 *
 * @author yarpo
 */
public class TextAreaLogger implements ILogger
{
    private static final String EMPTY  = "";
    private static final String ENDL  = "\n";
    private java.awt.TextArea textArea;

    private static TextAreaLogger logger = null;

    public static TextAreaLogger getInstance(java.awt.TextArea ta)
    {
        if (null == logger)
        {
            logger = new TextAreaLogger(ta);
        }
        return logger;
    }

    private TextAreaLogger (java.awt.TextArea ta)
    {
        textArea = ta;
        textArea.setEditable(false);
    }

    public void clear ()
    {
        setText(EMPTY);
    }

    public void log (String s)
    {
        setText(textArea.getText() + s + ENDL);
    }

    protected void setText(String s)
    {
        textArea.setText(s);
    }
}
