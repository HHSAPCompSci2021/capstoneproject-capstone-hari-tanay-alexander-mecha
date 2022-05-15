package utility;

import java.util.ArrayList;

import utility.field.FieldObject;

public class Map {
    private ArrayList<FieldObject> fieldObjects; 
    


    private static int[] dimensions = new int[] {
        500, 500
    }; 

    public Map() {
        fieldObjects = new ArrayList<FieldObject>(); 
    }

    /**
     * Recommended constructor, constructs map to specified dimentions, 
     * border will be initialized based on <code>length</code> and <code>width</code> specifications. 
     * @param x length of field. 
     * @param y width of field. 
     */
    public Map(int x, int y) {
        super(); 
        dimensions[0] = x; 
        dimensions[1] = y; 

        
    }
}
