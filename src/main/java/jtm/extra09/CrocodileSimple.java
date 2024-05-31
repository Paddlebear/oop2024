package jtm.extra09;

public class CrocodileSimple implements Crocodile{

    int moves = 1;
    int candies = 0;

    @Override
    public void move(Board board) {
        // TODO Auto-generated method stub
        MoveStrategy strategy = new MoveSimple();
        strategy.move(this, board);
    }

    @Override
    public int getMoves() {
        // TODO Auto-generated method stub
        return moves;
    }

    @Override
    public int getCandies() {
        // TODO Auto-generated method stub
        return candies;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return this.getClass().getSimpleName();
    }

    void setCandies(int candies) {
        this.candies = candies;
    }

    void setMoves(int moves) {
        this.moves = moves;
    }

}
