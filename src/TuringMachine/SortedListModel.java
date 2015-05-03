package TuringMachine;

import java.awt.*;
import javax.swing.*;

/**
 * ScrollPane to hold the Transition list
 * 
 * @author Owen F. Kellett
 * @version 1.0
 */
public class SortedListModel extends DefaultListModel {
  /**
	 * 
	 */
  private static final long serialVersionUID = 7273332800366200363L;

  public SortedListModel() {
    super();
  }

  /**
   * Adds an edge into the list in the appropriate sorted location according to
   * its starting state
   * 
   * @param obj
   */
  public void addSortedElement( Object obj ) {
    int j = 0;
    for( j = 0; j < size(); j++ ) {
      if( ( (Edge)getElementAt( j ) ).fromState.stateName
          .compareTo( ( (Edge)obj ).fromState.stateName ) < 0 )
        ;
      else if( ( (Edge)getElementAt( j ) ).fromState.stateName
          .compareTo( ( (Edge)obj ).fromState.stateName ) == 0 ) {
        if( ( (Edge)getElementAt( j ) ).oldChar < ( (Edge)obj ).oldChar )
          ;
        else {
          add( j, obj );
          break;
        }
      }
      else {
        add( j, obj );
        break;
      }
    }
    if( j > 0 && j == size() ) super.addElement( obj );
    if( size() == 0 ) super.addElement( obj );
  }

  public void update() {
      fireContentsChanged(this,0,size()-1);
  }
}
