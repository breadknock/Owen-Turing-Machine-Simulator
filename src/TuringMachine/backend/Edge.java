package backend;

public class Edge {
  public State fromState;
  public State toState;

  public char oldChar = 0;
  public char newChar = 0;
  public int direction = 0;

  public boolean currentEdge = false;
  public boolean highlight = false;

  public double shiftLabel = 0;

  public Edge( State from, State to ) {
    fromState = from;
    toState = to;
  }

  public State getFromState() {
      return fromState;
  }

  public State getToState() {
      return toState;
  }

  String label() {
    String temp = new String();
    if( oldChar != 0 ) temp = new String( String.valueOf( oldChar ) );
    if( newChar != 0 ) {
      temp = temp.concat( ", " );
      temp = temp.concat( String.valueOf( newChar ) );
    }
    if( direction != TM.NULL ) {
      temp = temp.concat( ", " );
      if( direction == TM.LEFT )
        temp = temp.concat( "Left" );
      else if( direction == TM.RIGHT )
        temp = temp.concat( "Right" );
      else temp = temp.concat( "Stay" );
    }
    return temp;
  }

  String listLabel() {
    String temp = new String( "(" );
    temp = temp.concat( fromState.stateName );
    temp = temp.concat( ", " );
    temp = temp.concat( String.valueOf( oldChar ) );
    temp = temp.concat( ")  " );
    temp = temp.concat( "(" );
    temp = temp.concat( toState.stateName );
    if( newChar != 0 ) {
      temp = temp.concat( ", " );
      temp = temp.concat( String.valueOf( newChar ) );
    }
    if( direction != TM.NULL ) {
      temp = temp.concat( ", " );
      if( direction == TM.LEFT )
        temp = temp.concat( "Left" );
      else if( direction == TM.RIGHT )
        temp = temp.concat( "Right" );
      else temp = temp.concat( "Stay" );
    }
    temp = temp.concat( ")" );
    return temp;
  }
}

