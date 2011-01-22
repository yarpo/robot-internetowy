/*
 * RobotinternetowyApp.java
 */
package robotinternetowy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class RobotinternetowyApp extends SingleFrameApplication
{
    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup ()
    {
        show(new RobotinternetowyView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow (java.awt.Window root)
    {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of RobotinternetowyApp
     */
    public static RobotinternetowyApp getApplication ()
    {
        return Application.getInstance(RobotinternetowyApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main (String[] args)
            throws Exception
    {
        launch(RobotinternetowyApp.class, args);
        System.out.println("Działa");
        URL site = new URL("http://eti.dragoart.info/index.php");

        URLConnection yc = site.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
        {
            System.out.println(inputLine);
        }
        in.close();
    }
}
