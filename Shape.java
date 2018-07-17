/**
   This interface must be implemented by all 
   drawing shapes that will be added to a frame.
 */
interface Shape { 
  /**
     This method will be called when the shape needs to be drawn.
   */
  void draw(TGraphics graphics);
}
