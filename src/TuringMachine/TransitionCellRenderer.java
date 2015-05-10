package TuringMachine;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * ScrollPane to hold the Transition list
 * 
 * @author Owen F. Kellett
 * @version 1.0
 */
public class TransitionCellRenderer extends JLabel implements ListCellRenderer {
  /**
	 * 
	 */
  private static final long serialVersionUID = -2657134010283269621L;

  public TransitionCellRenderer() {
    setOpaque( true );
  }

  public Component getListCellRendererComponent( JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus ) {
    setText( ( (Edge)value ).listLabel() );
    if( ( (Edge)value ).currentEdge ) {
      setBackground( list.getSelectionBackground() );
      setForeground( list.getSelectionForeground() );
    }
    else {
      setBackground( list.getBackground() );
      setForeground( list.getForeground() );
    }

    return this;
  }
}

/**
 * List Model for the TransitionsPane - Maintains list of edges sorted by
 * starting state
 * 
 * @author Owen F. Kellett
 * @version 1.0
 */
