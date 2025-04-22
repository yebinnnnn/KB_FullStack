class S{
    private S(){}
    static private S s=new S(); //static 변수로 S 변수를 선언하면
    //초기화단계에서 미리 생성되어져 있는 객체를 참조하게 됨
    static S getInstance(){
        return new S();
    }
}

public class SingletonTest {
    public static void main(String[] args) {
//        S s1=new S();
        S s1= S.getInstance();
        S s2= S.getInstance();
        System.out.println(s1==s2);//true 일지 false 일지
        //매번 new 하면 새로운 객체가 생기니까 싱글톤 패턴에 위배.
    }
}
