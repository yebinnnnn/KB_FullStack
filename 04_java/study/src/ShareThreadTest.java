class T1 extends Thread {
    Share s;
    T1(Share s){
        this.s = s;
    }
    public void run(){
        for(int i=0;i<10;i++){
            s.plus();
        }
    }
}
class T2 extends Thread{
    Share s;
    T2(Share s){
        this.s = s;
    }
    public void run(){
        for(int i=0;i<10;i++){
            s.minus();
        }
    }
}

class Share{
    int money;
    //synchronize 쓰는건 비추
    public void plus(){
        for(int i=0; i<100; i++){
            System.out.println("before plus:"+money);
            money++;
            System.out.println("after plus:"+money);
        }
    }
    public void minus(){
        for(int i=0; i<100; i++){
            System.out.println("before minus:"+money);
            money--;
            System.out.println("after minus:"+money);
        }
    }
}
public class ShareThreadTest {
    public static void main(String[] args) {
        Share s= new Share();
        T1 t1 = new T1(s);
        //t1.s=s;
        T2 t2 = new T2(s);
        //t2.s=s;

        t1.start();
        t2.start();
    }
}
