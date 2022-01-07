package game.gameOfLife;

public abstract class AbsBoard implements IBoard{

    @Override
    public String toString(){
        String str = "";

        for(int i = 0; i < getRow(); i++){
            for(int j = 0; j < getCol(); j++){
                CellModel c = getCell(i, j);

                if(c.getState()){
                    str += "* ";
                }
                else {
                    str += "  ";
                }
            }
            str += "\n";
        }

        return str;
    }

}
