package ch01;

public class DataType { //클래스 이름은 반드시 파일명과 같아야한다.
    public static void main(String[] args){
        //정수형 크기
        byte b; //1byte
        short s; //2byte
        int i; //4byte
        long l;//8byte
        l=123456789012345L; //대문자 L 표기 권장
        //실수형 트리
        float f; //4byte
        f= 12.3F; //double 타입의 값을 float 변수 메모리에 대입불가
        double d; //8byte
        //단일 문자형
        char c; //2byte
        //논리형(0과 1이 아니라 true false)
        boolean bo; //1byte
        //큰 자료형으로 형변환 가능
        //자동형변환 : 작은자료형 -> 큰자료형
        //강제형변환 : 캐스트 연산자 사용
        b=1;
        i=b; //자동형변환
        f=i; //다 큰쪽으로 가서 자동형변환
        System.out.println(b);
        System.out.println(i);
        b=(byte)f; //캐스트로 강제 형변환
        System.out.println(b);
    }
}
