import java.text.SimpleDateFormat;
import java.util.Date;

class One{
    public void run(){
        System.out.println("run(): 현재 사용중인 스레드:"+Thread.currentThread().getName());
        for(int i=0; i<99; i++){
            System.out.println(i+"run(): 현재 사용중인 스레드:"+Thread.currentThread().getName());
            System.out.println(i);
        }
    }
}
//사용자 스레드 정의에서 할일을 결정하는게 가장 중요.
//이는 오버라이드 런 매소드에 구현하면 됨. 부모인 스레드의 런 메소드를
//자식쪽에서 할일을 정해서 하는 것.
class FirstThread extends Thread{
    @Override
    public void run(){
        System.out.println("run(): 현재 사용중인 스레드:"+Thread.currentThread().getName());
//        for(int i=0; i<99; i++){
//            System.out.println(i+"run(): 현재 사용중인 스레드:"+Thread.currentThread().getName());
//            System.out.println(i);
//        }
        for(int i=0; i<10; i++){
            long mills=1000; //
            try { //InterruptedException 발생
                Thread.sleep(mills);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

//단일상속. 두개 이상 상속할 수 없음
class SecondThread implements Runnable{
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(sdf.format(new Date()));
        }
    }
}

class ThirdThread implements Runnable{
    int num1, num2;
    int sum;
    public ThirdThread(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    @Override
    public void run(){
        for(int i=num1 ; i<num2; i++){
            sum+=i;
        }
    }
}

/**
 * java ThreadTest클래스 실행 시 메인 스레드가 자동 만들어지고
 * 메인 스레드에서 main() 메서드가 호출이 된다.
 */
public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("현재 사용중인 스레드:"+Thread.currentThread().getName());
//        One one= new One();
//        one.run();
        FirstThread ft1 = new FirstThread();
        FirstThread ft2 = new FirstThread();
        ft1.start();
        ft2.start();

        SecondThread st=new SecondThread();
        Thread th=new Thread(st); //thread로 호출해야 start 메서드 사용가능
        th.start();

        ThirdThread th1= new ThirdThread(1,101);
        ThirdThread th2= new ThirdThread(2,101);
       //new Thread(th1).start();
        Thread th3= new Thread(th1);
        th3.start();
        try {
            th3.join(); //main 스레드가 t3 스레드 종료까지 기다린다
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        new Thread(th2).start();
        System.out.println("th1.sum:"+th1.sum);
        System.out.println("th2.sum:"+th2.sum);
    }
}
