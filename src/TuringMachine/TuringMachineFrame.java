package TuringMachine;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Main visual holder component
 * @author Owen F. Kellett
 * @version 1.0
 */
public class TuringMachineFrame extends JFrame {

  private static final long serialVersionUID = -3383177807569442195L;
/**
   * Helper variable for the contentPane of this
   */
  private JPanel contentPane;
  /**
   * Main menu bar along the top of the frame
   */
  private JMenuBar jMenuBar1 = new JMenuBar();
  /**
   * File menu for the main menu bar
   */
  private JMenu jMenuFile = new JMenu();
  /**
   * New Option for the File menu
   */
  private JMenuItem jMenuFileNew = new JMenuItem();
  /**
   * Clear Option for the File menu
   */
  private JMenuItem jMenuFileClear = new JMenuItem();
  /**
   * Exit option for the File menu
   */
  private JMenuItem jMenuFileExit = new JMenuItem();
  /**
   * Open option for the File menu
   */
  private JMenuItem jMenuFileOpen = new JMenuItem();
  /**
   * Save option for the File menu
   */
  private JMenuItem jMenuFileSave = new JMenuItem();
  /**
   * Save Graph option for the File menu
   */
  private JMenuItem jMenuFileSaveGraph = new JMenuItem();

  private JMenuItem jMenuFileSaveXML = new JMenuItem();

  private JMenuItem jMenuFileSaveTape = new JMenuItem();

  private JMenuItem jMenuFileSaveMultiple = new JMenuItem();
  /**
   * Save Execution option for the File menu
   */
  private JMenuItem jMenuFileSaveExecution = new JMenuItem();
  /**
   * Help menu for the main menu bar
   */
  private JMenu jMenuHelp = new JMenu();
  /**
   * About option for the Help menu
   */
  private JMenuItem jMenuHelpAbout = new JMenuItem();

  /**
   * Status bar for the bottom of the Frame (currently not used)
   */
  private JLabel statusBar = new JLabel();
  /**
   * Layout object for placing items into the Frame
   */
  private BorderLayout borderLayout1 = new BorderLayout();

  /**
   * The guts of the program - the main TM simulator
   */
  TuringMachineSimulator machine;
  
  TuringMachineApp parent;

  /**
   * Construct the frame
   */
  public TuringMachineFrame(TuringMachineApp tma, File file) {
	parent = tma;
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	machine = new TuringMachineSimulator();
	if(file != null) {
		openFile(file);
	} else {
		machine.machine.machineType = MachineTypePicker.getNewMachineType();
	}
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public TuringMachineFrame(TuringMachineApp tma) {
	  this(tma,null);
  }

  /**
   * Component intialization
   */
  public void jbInit() throws Exception  {

    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(800, 600));
    this.setTitle("Turing Machine Simulator");
    statusBar.setText(" ");

    //Initialize and declare menu structure
    jMenuFile.setText("File");
    jMenuFileExit.setText("Exit");
    jMenuFileExit.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        jMenuFileExit_actionPerformed(e);
      }
    });
    jMenuFileNew.setText("New");
    jMenuFileNew.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		parent.createNewInstance(null);
    	}
    });
    jMenuFileClear.setText("Clear");
    jMenuFileClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileClear_actionPerformed(e);
      }
    });
    jMenuFileOpen.setText("Open");
    jMenuFileOpen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileOpen_actionPerformed(e);
      }
    });
    jMenuFileSave.setText("Save");
    jMenuFileSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileSave_actionPerformed(e);
      }
    });
    jMenuFileSaveGraph.setText("Save Graph");
    jMenuFileSaveGraph.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileSaveGraph_actionPerformed(e);
      }
    });
    jMenuFileSaveXML.setText("Save XML");
    jMenuFileSaveXML.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileSaveXML_actionPerformed(e);
      }
    });
    jMenuFileSaveTape.setText("Save Tape");
    jMenuFileSaveTape.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileSaveTape_actionPerformed(e);
      }
    });
    jMenuFileSaveMultiple.setText("Save Multiple");
    jMenuFileSaveMultiple.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileSaveMultiple_actionPerformed(e);
      }
    });
    jMenuFileSaveExecution.setText("Save Execution");
    jMenuFileSaveExecution.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileSaveExecution_actionPerformed(e);
      }
    });
    jMenuHelp.setText("Help");
    jMenuHelpAbout.setText("About");
    jMenuHelpAbout.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        jMenuHelpAbout_actionPerformed(e);
      }
    });

    //add menu components to menu
    jMenuFile.add(jMenuFileNew);
    jMenuFile.add(jMenuFileClear);
    jMenuFile.add(jMenuFileOpen);
    jMenuFile.add(jMenuFileSave);
    jMenuFile.add(jMenuFileSaveGraph);
    jMenuFile.add(jMenuFileSaveXML);
    jMenuFile.add(jMenuFileSaveTape);
    jMenuFile.add(jMenuFileSaveMultiple);
    jMenuFile.add(jMenuFileSaveExecution);
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
    this.setJMenuBar(jMenuBar1);

    contentPane.add(statusBar, BorderLayout.SOUTH);
    contentPane.add(machine, BorderLayout.CENTER);

  }
  /**
   * File | Exit action - exits the program
   * @param e ActionEvent dummy variable
   */
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
	parent.close();
    dispose();
  }

  public void jMenuFileClear_actionPerformed(ActionEvent e) {
      machine.graphpanel.states = new Vector<State>();
      machine.graphpanel.transitions = new SortedListModel();
      machine.graphpanel.machine.currentEdge = null;
      machine.graphpanel.machine.currentState = null;
      JList<Edge> transitions = new JList<Edge>(machine.graphpanel.transitions);
      transitions.setCellRenderer(new TransitionCellRenderer());
      machine.graphpanel.transitionpanel.getViewport().setView(transitions);
      machine.machine.machineType = MachineTypePicker.getNewMachineType();

  }


  /**
   * File | Open action - brings up a TMFileChooser dialog
   * @param e ActionEvent dummy variable
   */
  public void jMenuFileOpen_actionPerformed(ActionEvent e) {
    TMFileChooser filechooser = new TMFileChooser();
    filechooser.setGraphPanel(machine.graphpanel);
    int confirm = filechooser.showOpenDialog(this);
    if(confirm == TMFileChooser.APPROVE_OPTION)
    {
    	openFile(filechooser.getSelectedFile());
    }
    
  }
  
  public void openFile(File file) {
	  TMFileChooser filechooser = new TMFileChooser();
	  filechooser.setGraphPanel(machine.graphpanel);
	  if(file.getName().endsWith("tm"))
	    filechooser.openFile(file);
	  else if(file.getName().endsWith("tmo"))
	    filechooser.openTMOFile(file);
	  else if(file.getName().endsWith("txt"))
	    filechooser.openTapeFile(file);
	  else
	    filechooser.openXMLFile(file);
  }
  /**
   * File | Save action - brings up a TMFileChooser dialog
   * @param e ActionEvent dummy variable
   */
  public void jMenuFileSave_actionPerformed(ActionEvent e) {
    TMFileChooser filechooser = new TMFileChooser();
    filechooser.setGraphPanel(machine.graphpanel);
    int confirm = filechooser.showSaveDialog(this);
    if(confirm == TMFileChooser.APPROVE_OPTION)
    {
      TMFileChooser.curdir = filechooser.getCurrentDirectory().toString();
      File newSelect;
      File select = filechooser.getSelectedFile();
      if(select.getName().endsWith(".tm"))
        newSelect = select;
      else
        newSelect = new File(select.getParent() + File.separator + select.getName() + ".tm");
      if(newSelect.exists())
      {
        int answer = JOptionPane.showConfirmDialog(this, newSelect.getName()+" already exists, overwrite?",
            "Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        switch(answer)
        {
          case JOptionPane.YES_OPTION :
            filechooser.saveFile(newSelect);
            break;
          case JOptionPane.NO_OPTION :
            return;
        }
      }
      else
        filechooser.saveFile(newSelect);
    }
  }

  /**
   * File | Save Graph action - brings up a TMFileChooser dialog
   * @param e ActionEvent dummy variable
   */
  public void jMenuFileSaveGraph_actionPerformed(ActionEvent e) {
    TMFileChooser filechooser = new TMFileChooser(2);
    filechooser.setGraphPanel(machine.graphpanel);
    int confirm = filechooser.showSaveDialog(this);
    if(confirm == TMFileChooser.APPROVE_OPTION)
    {
      TMFileChooser.curdir = filechooser.getCurrentDirectory().toString();
      File newSelect;
      File select = filechooser.getSelectedFile();
      if(select.getName().endsWith(".tmo"))
        newSelect = select;
      else
        newSelect = new File(select.getParent() + File.separator + select.getName() + ".tmo");
      if(newSelect.exists())
      {
        int answer = JOptionPane.showConfirmDialog(this, newSelect.getName()+" already exists, overwrite?",
            "Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        switch(answer)
        {
          case JOptionPane.YES_OPTION :
            filechooser.saveTMOFile(newSelect);
            break;
          case JOptionPane.NO_OPTION :
            return;
        }
      }
      else
        filechooser.saveTMOFile(newSelect);
    }
  }

  public void jMenuFileSaveXML_actionPerformed(ActionEvent e) {
    TMFileChooser filechooser = new TMFileChooser(3);
    filechooser.setGraphPanel(machine.graphpanel);
    int confirm = filechooser.showSaveDialog(this);
    if(confirm == TMFileChooser.APPROVE_OPTION)
    {
      TMFileChooser.curdir = filechooser.getCurrentDirectory().toString();
      File newSelect;
      File select = filechooser.getSelectedFile();
      if(select.getName().endsWith(".xml"))
        newSelect = select;
      else
        newSelect = new File(select.getParent() + File.separator + select.getName() + ".xml");
      if(newSelect.exists())
      {
        int answer = JOptionPane.showConfirmDialog(this, newSelect.getName()+" already exists, overwrite?",
            "Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        switch(answer)
        {
          case JOptionPane.YES_OPTION :
            filechooser.saveXMLFile(newSelect);
            break;
          case JOptionPane.NO_OPTION :
            return;
        }
      }
      else
        filechooser.saveXMLFile(newSelect);
    }
  }

  public void jMenuFileSaveTape_actionPerformed(ActionEvent e) {
    TMFileChooser filechooser = new TMFileChooser(4);
    filechooser.setGraphPanel(machine.graphpanel);
    int confirm = filechooser.showSaveDialog(this);
    if(confirm == TMFileChooser.APPROVE_OPTION)
    {
      TMFileChooser.curdir = filechooser.getCurrentDirectory().toString();
      File newSelect;
      File select = filechooser.getSelectedFile();
      if(select.getName().endsWith(".txt"))
        newSelect = select;
      else
        newSelect = new File(select.getParent() + File.separator + select.getName() + ".txt");
      if(newSelect.exists())
      {
        int answer = JOptionPane.showConfirmDialog(this, newSelect.getName()+" already exists, overwrite?",
            "Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        switch(answer)
        {
          case JOptionPane.YES_OPTION :
            filechooser.saveTapeFile(newSelect);
            break;
          case JOptionPane.NO_OPTION :
            return;
        }
      }
      else
        filechooser.saveTapeFile(newSelect);
    }
  }

  public void jMenuFileSaveMultiple_actionPerformed(ActionEvent e) {
    TMFileChooser filechooser = new TMFileChooser(4);
    filechooser.setGraphPanel(machine.graphpanel);
    int confirm = filechooser.showSaveDialog(this);
    if(confirm == TMFileChooser.APPROVE_OPTION)
    {
      TMFileChooser.curdir = filechooser.getCurrentDirectory().toString();
      File newSelect;
      File select = filechooser.getSelectedFile();
      if(select.getName().endsWith(".txt"))
        newSelect = select;
      else
        newSelect = new File(select.getParent() + File.separator + select.getName() + ".txt");
      if(newSelect.exists())
      {
        int answer = JOptionPane.showConfirmDialog(this, newSelect.getName()+" already exists, overwrite?",
            "Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        switch(answer)
        {
          case JOptionPane.YES_OPTION :
            filechooser.saveInputFile(newSelect);
            break;
          case JOptionPane.NO_OPTION :
            return;
        }
      }
      else
        filechooser.saveInputFile(newSelect);
    }
  }

  /**
   * File | Save Execution action - brings up a TMFileChooser dialog
   * @param e ActionEvent dummy variable
   */
  public void jMenuFileSaveExecution_actionPerformed(ActionEvent e) {
    TMFileChooser filechooser = new TMFileChooser(1);
    filechooser.setGraphPanel(machine.graphpanel);
    int confirm = filechooser.showSaveDialog(this);
    if(confirm == TMFileChooser.APPROVE_OPTION)
    {
      TMFileChooser.curdir = filechooser.getCurrentDirectory().toString();
      File newSelect;
      File select = filechooser.getSelectedFile();
      if(select.getName().endsWith(".html"))
        newSelect = select;
      else
        newSelect = new File(select.getParent() + File.separator + select.getName() + ".html");
      if(newSelect.exists())
      {
        int answer = JOptionPane.showConfirmDialog(this, newSelect.getName()+" already exists, overwrite?",
            "Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        switch(answer)
        {
          case JOptionPane.YES_OPTION :
            SaveProgressDialog progressIndicator = new SaveProgressDialog(Integer.valueOf(filechooser.maximum.getText()).intValue(), this);
            progressIndicator.validate();
            progressIndicator.setVisible(true);
            machine.machine.setSpeed("Compute");
            ExecutionSaver saveNow = new ExecutionSaver(newSelect, Integer.valueOf(filechooser.maximum.getText()).intValue(), progressIndicator, machine.graphpanel);
            saveNow.start();
            break;
          case JOptionPane.NO_OPTION :
            return;
        }
      }
      else
      {
        SaveProgressDialog progressIndicator = new SaveProgressDialog(Integer.valueOf(filechooser.maximum.getText()).intValue(), this);
        progressIndicator.validate();
        progressIndicator.setVisible(true);
        machine.machine.setSpeed("Compute");
        ExecutionSaver saveNow = new ExecutionSaver(newSelect, Integer.valueOf(filechooser.maximum.getText()).intValue(), progressIndicator, machine.graphpanel);
        saveNow.start();
      }
    }
  }

  /**
    * Help | About action - displays About dialog
    * @param e ActionEvent dummy variable
    */
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    TuringMachineFrame_AboutBox dlg = new TuringMachineFrame_AboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.pack();
    dlg.setVisible(true);
  }

  /**
    * Overridden so we can exit when window is closed (if this is last window)
    */
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      jMenuFileExit_actionPerformed(null);
    }
  }
}
