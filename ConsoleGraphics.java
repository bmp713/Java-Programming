/**
   The class represents a simple text based graphics device using ascii 
   characters. The drawing places (0, 0) upper left corner of the
 */
class ConsoleGraphics implements TGraphics {
    private char[][] display;
    private int width, height;
    /**
       Construct a graphics object for a console with the specified 
       dimensions.
     */
    ConsoleGraphics(int width, int height) {
	this.width = width;
	this.height = height;
	display = new char[width][height];
	clear(); // set all elements to ' ' (space)
    }
    /**
       Draw a line from (x1, y1) to (x2, y2).
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
      // use helper methods to do the drawing
      if( Math.abs(x1-x2) < Math.abs(y1-y2))
	drawLineLongY(x1, y1, x2, y2);
      else
	drawLineLongX(x1, y1, x2, y2);
    }
    /**
       Draw a horizontal line of the specified length, with (x1, y1) 
       as the left end.
     */
    public void drawHorizontalLine(int x1, int y1, int length) {
	for(int x = x1; x < x1+length; x++) {
	  try {
	    display[x][y1] = '-';
	  }
	  catch(IndexOutOfBoundsException e) { 
	    // ignore - this is drawing off the screen
	  }
	}
    }
    /**
       Draw a vertical line of the specified length, with (x1, y1) 
       as the upper end.
     */
    public void drawVerticalLine(int x1, int y1, int length) {
	for(int y = y1; y < y1+length; y++) {
	  try {
	    display[x1][y] = '|';
	  }
	  catch(IndexOutOfBoundsException e) { 
	    // ignore - this is drawing off the screen
	  }
	}
    }
    /**
       Copy what has been drawn onto the display to the console.
     */
    public void render() {
        // draw the top border
        for(int x = 0; x < width+2; x++) 
	    System.out.print("*");
	System.out.println();

        for(int y = 0; y < height; y++) {
	    System.out.print("*");
	    for(int x = 0; x < width; x++) {
	        System.out.print(display[x][y]);
	    }
	    System.out.println("*");
	}

        // draw the bottom border
        for(int x = 0; x < width+2; x++) 
	    System.out.print("*");
	System.out.println();

	clear(); // Simulate a display device that doesn't store anything.
    }

    /**
       Clear the display, setting every character to ' ' (space).
     */
    public void clear() {
        for(int y = 0; y < height; y++) {
	    for(int x = 0; x < width; x++) {
	        display[x][y] = ' ';
	    }
	}
    }

    /**
       Draw a line assuming that |x1 - x2| >= |y1 - y2|.
     */
    private void drawLineLongX(int x1, int y1, int x2, int y2) {
	// make sure x1 < x2, if not, swap the points
        if (x2 < x1 ) {
	  int temp = x2;
	  x2 = x1;
	  x1 = temp;
	  temp = y2;
	  y2 = y1;
	  y1 = temp;
        }
	
	// get the eqn for the line y = mx + b
	double m = ((double)(y2 - y1)) / (x2 -x1); // the slope
	double b = y1 - m * x1;

	for(int x = x1; x <= x2; x++) {
	  int y = (int)Math.round(m * x + b);
	  try{
	    display[x][y] = '*';
	  }
	  catch(IndexOutOfBoundsException e) { 
	    // ignore - this is drawing off the screen
	  }
	}
    }

    /**
       Draw a line assuming that |x1 - x2| <= |y1 - y2|.
     */
    void drawLineLongY(int x1, int y1, int x2, int y2) {
	// make sure y1 <= y2, if not, swap the points
        if (y2 < y1 ) {
	  int temp = x2;
	  x2 = x1;
	  x1 = temp;
	  temp = y2;
	  y2 = y1;
	  y1 = temp;
        }
	
	// get the eqn for the line x = my + b
	double m = ((double)(x2 - x1)) / (y2 - y1); // the slope
	double b = x1 - m * y1;

	for(int y = y1; y <= y2; y++) {
	  int x = (int)Math.round(m * y + b);
	  try{
	    display[x][y] = '*';
	  }
	  catch(IndexOutOfBoundsException e) { 
	    // ignore - this is drawing off the screen
	  }
	}
    }
}
