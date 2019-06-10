import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solver {

    private int boardNumber ;
    private ArrayList<String> board;
    private File file ;
    private String boardName;

    Solver(){
        init(2);
    }

    private void init( int boardID ){
        this.boardNumber = boardID;
        setBoardName();
        board = new ArrayList<String>();
        file = new File("src/boards.txt");
        loadBoard();
        printBoard();
        Brain br = new Brain(board);


    }

    private void setBoardName(){
        boardName = "Grid ";
        String num = Integer.toString(boardNumber);

        if( num.length() == 1 ){
            num = "0"+num;
        }
        boardName = boardName + num;
    }


    private void loadBoard(){
        try {
            Scanner sc = new Scanner(file);
            boolean start = false;
            while( sc.hasNextLine() ){
                String ss = sc.nextLine();
                //System.out.println(ss+" "+boardName);
                if( ss.equals(boardName) ){
                    start=true;
                    continue;
                }

                if( start ){
                    board.add(ss);
                    if( board.size() == 9 ){
                        break;
                    }
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    private void printBoard(){
        System.out.println("The board is: "+boardName);
        //System.out.println(board.size());

        for(String s: board){
            System.out.println(s);
        }
    }



}
