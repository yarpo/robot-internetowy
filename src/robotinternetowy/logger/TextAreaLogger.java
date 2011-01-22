/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

    public TextAreaLogger (java.awt.TextArea ta)
    {
        textArea = ta;
    }

    public void clear ()
            throws Exception
    {
        setText(EMPTY);
    }

    public void log (String s)
            throws Exception
    {
        setText(textArea.getText() + s + ENDL);
    }

    protected void setText(String s)
    {
        textArea.setText(s);
    }
}
