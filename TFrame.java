/**
   The interface of frames in the Tiny graphics package (hence the T in TFrame.
*/
interface TFrame {
    /**
       Add a shape to this frame.
     */
    void add(Shape shape);

    /**
       Remove a shape from this frame.
     */
    boolean remove(Shape shape);

    /**
       Remove all shapes from this frame.
    */
    void clear();

    /**
       Cause this frame to be displayed.
     */
    void show();

}
