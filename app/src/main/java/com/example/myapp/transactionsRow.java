package com.example.myapp;

public class transactionsRow
{
    private String text1, text2;

    public transactionsRow(String mText1, String mText2)
    {
        this.text1 = mText1;
        this.text2 = mText2;
    }

    public void setText1(String text1)
    {
        this.text1 = text1;
    }

    public void setText2(String text2)
    {
        this.text2 = text2;
    }

    public String getText1()
    {
        return text1;
    }

    public String getText2()
    {
        return text2;
    }
}
