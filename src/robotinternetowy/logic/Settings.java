/*
 * Klasa odpowiedzialna za zebranie wszystkich danych z formularza + ich walidacje
 */
package robotinternetowy.logic;

import robotinternetowy.RobotinternetowyView;
import robotinternetowy.logic.helpers.Validator;
import robotinternetowy.utils.exceptions.*;

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
            throws Exception
    {
        robot = r;
        readAndValidUrl();
        readAndValidDepth();
        readAndValidDomain();
        readAndValidSaveAs();
    }

    private void readAndValidUrl ()
            throws Exception
    {
        try
        {
            url = Validator.url(robot.getTextField1().getText());
        }
        catch (ValidationException e)
        {
            throw new UrlValidationException();
        }
    }

    private void readAndValidDomain ()
            throws Exception
    {
        closeToDomain = robot.getCheckbox1().getState();
    }

    private void readAndValidDepth ()
            throws Exception
    {
        try
        {
            depth = Validator.depth(robot.getTextField3().getText());
        }
        catch (ValidationException e)
        {
            throw new DepthValidationException();
        }
    }

    private void readAndValidSaveAs ()
            throws Exception
    {
        try
        {
            saveAs = Validator.saveAs(robot.getTextField2().getText());
        }
        catch (ValidationException e)
        {
            throw new PathValidationException();
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
