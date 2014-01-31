package com.densmore.customExceptionPlay;

import com.densmore.customExceptions.MyException;;

public class customExceptionPlay {

    MyException newExc=new MyException("This is a custom exception");

    public customExceptionPlay() throws MyException
    {
        System.out.println("Hello Back Again with custom exception");
        throw newExc;       
}

    public static void main(String args[])
    {
        try
        {
        	customExceptionPlay use = new customExceptionPlay();
        }
        catch(MyException my)
        {
            System.out.println("This is my custom exception:"+my.getMessage());
        }
    }
}