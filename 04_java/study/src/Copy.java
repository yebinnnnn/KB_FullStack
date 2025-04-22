import com.kb.starbucks.dao.CustomerDAO;

class A implements Cloneable {
    int i;
    int [] arr;
    A(int i){
        this.i = i;
        arr=new int[]{1,2,3};
    }
    //딥 카피
    A copy(){
        try {
            //return (A)this.clone(); //객체복제 shallow copy

            A copyA = (A)this.clone(); //deep copy
            int[] copyArr = (int[])this.arr.clone();
            copyA.arr = copyArr;
            return copyA;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
  //쉘로우 카피
//    A copy(){ //딥카피와 쉘로우 카피가 있음
//        try{
//            return (A)this.clone();
//        }catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}

/**
 * 파일에 여러 클래스를 작성할때
 * main 메서드를 갖는 클래스만 public 이어야한다
 * public class 이름이 파일명이어야한다.
 */
public class Copy {
    public static void main(String[] args) {
        A a1= new A(10);//인스턴스 변수 i 값이 10으로 초기화
        A a2=a1.copy();
        System.out.println(a1==a2); //false -> 다른 힙 메모리
        System.out.println(a1.i==a2.i); //true ->같은 내용이긴함
        System.out.println(a1.arr==a2.arr);
        System.out.println(a1.arr[0]==a2.arr[0]);
        a2.i=20;
        System.out.println(a2.arr[0]); //shallow copy, deep copy 에 따라 다름
        System.out.println(a1.i);
    }
}
