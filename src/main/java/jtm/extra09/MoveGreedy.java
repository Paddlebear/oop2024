package jtm.extra09;

//UNFINISHED

public class MoveGreedy implements MoveStrategy {

    @Override
    public void move(Crocodile crocodile, Board board) {
        // TODO Auto-generated method stub
        int moves = 0;
        int candies = 0;
        int x = 0, y = 0;
        System.out.println("board: x:" + board.getX() + " y:" + board.getY());
        for (y = 0; y < board.getY() - 1; y++) {
            for (x = 0; x < board.getX() - 1; x++) {
                if ('●' == board.getCandy(x, y))
                    candies++;
                board.setCandy(x, y, '◎');
                System.out.println("x:" + x + ", y:" +y);
                moves++;
            }
        }
        if (y % 2 == 0) {
            for (x = 0; x < board.getX() - 1; x++) {
                moves++;
            }
        }
        moves--;
        ((CrocodileGreedy) crocodile).setCandies(candies);
        ((CrocodileGreedy) crocodile).setMoves(moves);
        System.out.println(board);
    }

}
