package com.company;

import javax.swing.*;

public class Field {
    JPanel panel;
    JFrame frame;

    int size = 60;
    int cols = 8;
    int rows = 8;

    Cell[][]cells;

    public Field(){
        initialise();
    }

    private void initialise() {
        frame=new JFrame("Chess");
        frame.setLayout(null);
        frame.setSize(rows*size+15,cols*size+40);
        frame.setLocationRelativeTo(null);
        
        cells= new Cell[cols][rows];

        boolean isTileWhite;
        boolean isFigureWhite;

        boolean isEmpty;
        boolean isKing;
        boolean isQueen;
        boolean isBishop;
        boolean isKnight;
        boolean isRook;
        boolean isPawn;

        int posX=0;
        int posY=0;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                isEmpty=false;
                isKing=false;
                isQueen=false;
                isBishop=false;
                isKnight=false;
                isRook=false;
                isPawn=false;
                if (
                                ((i==0)&&(j==0))||
                                ((i==0)&&(j==7))||
                                ((i==7)&&(j==0))||
                                ((i==7)&&(j==7))
                ){
                    isRook=true;
                }else if (
                                ((i==0)&&(j==1))||
                                ((i==0)&&(j==6))||
                                ((i==7)&&(j==1))||
                                ((i==7)&&(j==6))
                ){
                    isKnight=true;
                }else if (
                                ((i==0)&&(j==2))||
                                ((i==0)&&(j==5))||
                                ((i==7)&&(j==2))||
                                ((i==7)&&(j==5))
                ){
                    isBishop=true;
                }else if (
                                ((i==0)&&(j==3))||
                                ((i==7)&&(j==3))
                ){
                    isQueen=true;
                }else if (
                                ((i==0)&&(j==4))||
                                ((i==7)&&(j==4))
                ){
                    isKing=true;
                }else if (
                                (i==1)||
                                (i==6)
                ){
                    isPawn=true;
                }else {
                    isEmpty=true;
                }

                isFigureWhite = i >= 4;
                isTileWhite= (i + j) % 2 == 0;

                cells[i][j]=new Cell(size, i, j, posX, posY,
                        new ButtonListener(), frame, isTileWhite, isFigureWhite,
                        isEmpty, isKing, isQueen, isBishop, isKnight, isRook, isPawn);

                posX+=size;
            }
            posY+=size;
            posX=0;
        }
        frame.setVisible(true);
    }
}
