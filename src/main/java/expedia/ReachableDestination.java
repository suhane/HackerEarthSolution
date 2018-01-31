package expedia;

public class ReachableDestination {

    public boolean isValidPath(int srcX,int srcY, int destX, int destY){

        if(srcX>destX || srcY>destY)
            return false;
        if(srcX==destX && srcY==destY)
            return true;

        return isValidPath(srcX+srcY,srcY,destX,destY) || isValidPath(srcX,srcX+srcY,destX,destY);

    }
}
