package com.company;

import javax.swing.*;
import java.awt.*;

public class Cell {
    JButton button;
    JFrame frame;
    ButtonListener buttonListener;

    boolean isTileWhite;
    boolean isFigureWhite;

    boolean isEmpty;
    boolean isKing;
    boolean isQueen;
    boolean isBishop;
    boolean isKnight;
    boolean isRook;
    boolean isPawn;

    int posCountI;
    int posCountJ;
    int posX;
    int posY;
    int size;

    public Cell(int size, int posCountI, int posCountJ, int posX, int posY, ButtonListener buttonListener,
                JFrame frame, boolean isTileWhite, boolean isFigureWhite, boolean isEmpty,
                boolean isKing, boolean isQueen, boolean isBishop, boolean isKnight, boolean isRook, boolean isPawn){
        this.frame=frame;
        this.buttonListener=buttonListener;

        this.isTileWhite=isTileWhite;
        this.isFigureWhite=isFigureWhite;

        this.isEmpty=isEmpty;
        this.isKing=isKing;
        this.isQueen=isQueen;
        this.isBishop=isBishop;
        this.isKnight=isKnight;
        this.isRook=isRook;
        this.isPawn=isPawn;

        this.posCountI=posCountI;
        this.posCountJ=posCountJ;
        this.posX=posX;
        this.posY=posY;
        this.size=size;

        initialise();
    }

    private void initialise() {
        String text="";
        Color tileColor;
        Color figureColor;

        if (isPawn){
            text="p";
        }else if(isRook){
            text="r";
        }else if(isKnight){
            text="k";
        }else if(isBishop){
            text="b";
        }else if (isQueen){
            text="Q";
        }else if (isKing){
            text="K";
        }

        if (isTileWhite){
            tileColor=new Color(255, 200, 100);
        }else {
            tileColor=new Color(100, 60, 30);
        }

        if (isFigureWhite){
            figureColor=Color.WHITE;
        }else {
            figureColor=Color.BLACK;
        }

        button=new JButton();
        button.setBackground(tileColor);
        button.setForeground(figureColor);
        button.setText(text);
        button.setBounds(posX,posY,size,size);
        button.addMouseListener(buttonListener);
        button.setBorder(null);

        frame.add(button);
    }


}
