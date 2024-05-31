package jtm.extra09;

public class MoveSimple implements MoveStrategy {

    @Override
    public void move(Crocodile crocodile, Board board) {
        // TODO Auto-generated method stub
        int moves = 0;
        int candies = 0;
        int x = 0, y = 0;
        System.out.println("board: x:" + board.getX() + " y:" + board.getY());
        for (x = 0; x < board.getX() - 1; x++) {
            if ('●' == board.getCandy(x, 0))
                candies++;
            board.setCandy(x, y, '◎');
            System.out.println("x:" + x + ", y:" +y);
            moves++;
        }
        for (y = 0; y < board.getY(); y++) {
            if ('●' == board.getCandy(x, y))
                candies++;
            board.setCandy(x, y, '◎');
            System.out.println("x:" + x + ", y:" +y);
            moves++;
        }
        moves--;
        ((CrocodileSimple) crocodile).setCandies(candies);
        ((CrocodileSimple) crocodile).setMoves(moves);
        System.out.println(board);
    }

}
