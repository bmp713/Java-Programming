/**
   This interface represents a simple graphics device. 
 */
interface TGraphics {
    /**
       Draw a line from (x1, y1) to (x2, y2).
     */
    void drawLine(int x1, int y1, int x2, int y2);

    /**
       Draw a horizontal line of the specified length, with (x1, y1) 
       as the left end.
     */
    void drawHorizontalLine(int x1, int y1, int length);

    /**
       Draw a vertical line of the specified length, with (x1, y1) 
       as the upper end.
     */
    void drawVerticalLine(int x1, int y1, int length);

    /**
       Force the display to actually appear.
     */
    void render();

    /**
       Clear the display.
     */
    void clear();
}




