import java.util.ArrayList;

public class Brain {

    private final int N = 9;
    private ArrayList<String> board;
    private char charBoard[][];
    private  boolean solved;

    Brain( ArrayList board ){

        this.board = board;
        charBoard = new char[9][9];
        convertToCharArray();
        //isValid(8,8,'9');
        solved = false;
        solve(-1,-1);
        showBoard();




    }

    private void convertToCharArray(){

        int row = 0;
        for(String s: board){

            for(int col=0;col<N;col++){
                charBoard[row][col] = s.charAt(col);
            }
            row++;
        }

    }


    private void solve(int x, int y){

        if( isSolved() ){
            solved = true;
            return ;
        }
        if( solved ) return ;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if( charBoard[i][j] == '0' && x != i && y!=j ){
                    for( char ch = '1'; ch<='9'; ch++ ){
                        if( isValid(i,j,ch) ){
                            charBoard[i][j] = ch;
                            solve(i,j);
                        }
                    }
                }
            }
        }



    }


    private boolean isSolved(){

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if( charBoard[i][j] == '0' ) return false;
            }
        }
        return true;

    }


    private  boolean isValid( int x, int y, char ch ){

        // checking rows for same value

        for(int i=0;i<N; i++){
            if(i == x) continue;
            if( charBoard[i][y] == ch ) return false;
        }

        // checking cols for same value

        for(int j=0;j<N;j++){
            if( j == y ) continue;
            if( charBoard[x][j] == ch ) return false;
        }

        int xx = x/3;
        int yy = y/3;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

                int ii = i/3;
                int jj = j/3;

                if( xx == ii && yy == jj ){
                    if( charBoard[i][j] == ch ) return false;
                    //System.out.println(i+" "+j);
                }



            }
            //System.out.print("");

        }


        return true;



    }







    private  void showBoard(){

        System.out.println("The board is(Brain):");

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(charBoard[i][j]);
            }
            System.out.println("");
        }

        return;
    }





}
