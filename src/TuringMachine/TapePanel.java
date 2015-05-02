package TuringMachine;

import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.*;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */


class TapeTableModel extends DefaultTableModel {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  public TapeTableModel() {
    super();
  }

  public void setColumnName( Object value, int col ) {

    // columnIdentifiers.setElementAt(value, col);
  }
}

class TapeTable extends JTable
{
	private static final long serialVersionUID = 1L;
	TM machine = null;
	
	TapeTable()
	{
		super();
	}
	
	TapeTable(TableModel dm, TM machine1)
	{
		super(dm);
		machine = machine1;
	}
	
	public void setValueAt(Object value, int row, int column)
	{
		if(value instanceof String)
		{
			String a = (String) value;
			if(a.charAt(a.length()-1) == '^')
			{
				for( int j = 0; j < getColumnCount(); j++ ) {
			          getColumnModel().getColumn( j ).setHeaderValue(
			        		  new Character( '0' ) );
			    }
				super.getColumnModel().getColumn(column).setHeaderValue(new Character( '-' ) );
				machine.tapePos = column;
				getTableHeader().repaint();
				super.setValueAt(super.getValueAt(row, column), row, column);
			}
			else if(a.length() > 0 &&
					"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 /*-!@#$%&()=,.".indexOf(a.charAt(a.length()-1)) != -1)
			{
				super.setValueAt(a.charAt(a.length()-1), row, column);
			}
			else
				super.setValueAt('0', row, column);
		}
		else
		{
			super.setValueAt(value, row, column);
		}
	}
	
	public void createDefaultColumnsFromModel()
   {
	     assert columnModel != null : "The columnModel must not be null.";
	
	     // remove existing columns
	     int columnIndex = columnModel.getColumnCount() - 1;
	   
	     // add new columns to match the TableModel
	     int columnCount = dataModel.getColumnCount();
	     for (int c = columnIndex+1; c < columnCount; c++)
	     {
	       TableColumn column = new TableColumn(c);
	       column.setResizable(false);
	       column.setMinWidth( TM.CELLSIZE );
	       column.setMaxWidth( TM.CELLSIZE );
	       column.setPreferredWidth( TM.CELLSIZE );
	       column.setCellRenderer(new TapeCellRenderer() );
	       column.setCellEditor(new TapeEditor());
	       column.setHeaderRenderer( new TapeHeaderRenderer() );
	       column.setIdentifier(dataModel.getColumnName(c));
	       column.setHeaderValue(dataModel.getColumnName(c));
	       columnModel.addColumn(column);
	       column.addPropertyChangeListener(new TableColumnPropertyChangeHandler());
	     }
   }
	
	class TableColumnPropertyChangeHandler implements PropertyChangeListener
	   {
	     /**
	      * Receives notification that a property of the observed TableColumns has
	      * changed.
	      * 
	      * @param ev the property change event
	      */
	     public void propertyChange(PropertyChangeEvent ev)
	    {
	       if (ev.getPropertyName().equals("preferredWidth"))
	         {
	           JTableHeader header = getTableHeader();
	           if (header != null)
	             // Do nothing if the table is in the resizing mode.
	             if (header.getResizingColumn() == null)
	               {
	                 TableColumn col = (TableColumn) ev.getSource();
	                 header.setResizingColumn(col);
	                 doLayout();
	                 header.setResizingColumn(null);
	               }
	         }
	     }
	   }
	
}



class TapePanel extends JScrollPane {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  public TapePanel() {
    super();
  }

  public TapePanel( JTable tape ) {
    super( tape );
  }

  public Dimension getMinimumSize() {
    return new Dimension( 500, 75 );
  }

  public Dimension getPreferredSize() {
    return new Dimension( 500, 75 );
  }
}

class TapeHeaderRenderer extends JLabel implements TableCellRenderer {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;

  public TapeHeaderRenderer() {
    setOpaque( true );
  }

  public Component getTableCellRendererComponent( JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column ) {
    if( value.toString().equals( "-" ) )
      setIcon( new ImageIcon( TuringMachine.TuringMachineFrame.class
          .getResource( "/resources/tapeindex.gif" ) ) );
    else setIcon( null );
    
    setHorizontalAlignment(SwingConstants.CENTER);
    
    if( isSelected ) {
      setBackground( table.getSelectionBackground() );
      setForeground( table.getSelectionForeground() );
    }
    else {
      setBackground( table.getBackground() );
      setForeground( table.getForeground() );
    }

    return this;
  }
}

class TapeCellRenderer extends DefaultTableCellRenderer {
	  /**
		 * 
		 */
	  private static final long serialVersionUID = 1L;

	  public TapeCellRenderer() {
	    setOpaque( true );
	  }

	  public Component getTableCellRendererComponent( JTable table, Object value,
	      boolean isSelected, boolean hasFocus, int row, int column ) {
	    super.getTableCellRendererComponent(table, value, false, hasFocus, row, column);
	    this.setToolTipText("Enter ^ to set the pointer location");
	    setHorizontalAlignment(SwingConstants.CENTER);
	    return this;
	  }
	}


class TapeEditor extends JTextField implements TableCellEditor
{
    private CellEditorListener cellEditorListener  = null;
    private String old;

    // Start editing
    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj, boolean isSelected, int row, int column)
    {
    	old = obj.toString();
        super.setText("");
        setBackground( table.getBackground() );
        setForeground( table.getForeground() );
          
        return this;
    }

    // Retrieve e dited value
    @Override
    public Object getCellEditorValue()
    {
    	if(super.getText().equals(""))
    	{
    		return old;
    	}
        return super.getText();
    }

    @Override
    public boolean isCellEditable(EventObject e)
    {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject e)
    {
        return true;
    }

    @Override
    public boolean stopCellEditing()
    {
        cellEditorListener.editingStopped(new ChangeEvent(this));
        return true;
    }

    @Override
    public void cancelCellEditing()
    {
        cellEditorListener.editingCanceled(new ChangeEvent(this));
    }

    @Override
    public void addCellEditorListener(CellEditorListener celleditorlistener)
    {
        cellEditorListener = celleditorlistener;
    }

    @Override
    public void removeCellEditorListener(CellEditorListener celleditorlistener)
    {
        if (cellEditorListener == cellEditorListener) cellEditorListener = null;
    }
}
