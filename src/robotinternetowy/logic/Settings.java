/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package robotinternetowy.logic;

import robotinternetowy.RobotinternetowyView;
import robotinternetowy.logic.helpers.Validator;

/**
 *
 * @author yarpo
 */
public class Settings
{
    private String url;
    private boolean closeToDomain;
    private int depth;
    private String saveAs;
    private boolean overwrite;
    private RobotinternetowyView robot;

    public Settings (RobotinternetowyView r)
    {
        robot = r;
        readAndValidUrl();
        readAndValidDepth();
        readAndValidDomain();
        readAndValidSaveAs();
    }

    private void readAndValidUrl ()
    {
        try
        {
            url = Validator.url(robot.getTextField1().getText());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void readAndValidDomain ()
    {
        closeToDomain = robot.getCheckbox1().getState();
    }

    private void readAndValidDepth ()
    {
        try
        {
            depth = Validator.depth(robot.getTextField2().getText());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void readAndValidSaveAs ()
    {
        try
        {
            saveAs = Validator.saveAs(robot.getTextField2().getText());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean isCloseToDomain ()
    {
        return closeToDomain;
    }

    public int getDepth ()
    {
        return depth;
    }

    public boolean isOverwrite ()
    {
        return overwrite;
    }

    public String getSaveAs ()
    {
        return saveAs;
    }

    public String getUrl ()
    {
        return url;
    }
}
