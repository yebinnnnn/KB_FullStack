package ch01;

public class Operator {
    public static void main(String[] args){
        //????????? + - * /
        int a, b ,c ;
        a=10;
        b=3;
        c=a/b;
        System.out.println(c); //????/??????? ?????? ???´?.
        byte b1;
        int b3;
        b1=10; int b2=20;
        b3=b1+b2; //+연산 시 byte에서 int 로 자동형변환
        //Arithmetic Exception
        System.out.println(b3);

        //문자열 결합연산자 +
        System.out.println(1+2+"3");

    }
}
