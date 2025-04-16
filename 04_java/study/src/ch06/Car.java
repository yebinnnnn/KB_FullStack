package ch06;

public class Car {
    private int speed;
    private boolean stop;

    public Car(int speed, boolean stop){
        //생성자의 역할
    }

    public Car() {

    }

    //private 변수들을 getter setter 로 접근
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        if(speed<0){
            this.speed=0;
            return;
        }
        else{
            this.speed=speed;
        }
    }
    public boolean isStop() {
        return stop;
    }
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void main(String[] args){
        Car mycar=new Car();
        mycar.setSpeed(10);
        mycar.setStop(true);
        System.out.println(mycar.getSpeed());
    }
}
