package microsql;

import microsql.model.ParseModel;
import microsql.model.ValidationModel;
import microsql.view.MainFrame;

/**
 *
 * @author Irwansyah
 */
public class MicroSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ParseModel parseModel = new ParseModel();
        ValidationModel validationModel = new ValidationModel();
        
        MainFrame mainFrame = new MainFrame(parseModel,validationModel);
        mainFrame.setVisible(true);
    }
    
}
