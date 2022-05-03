package utility.field;

public abstract class FieldObject {
    protected float xPosition, yPosition; 

    public void changePos(float xChange, float yChange) {
        xPosition += xChange; 
        yPosition += yChange; 
    }

    
}
