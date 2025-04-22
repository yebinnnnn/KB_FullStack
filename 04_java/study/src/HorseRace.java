import javax.swing.*;
import java.awt.event.*;

/**
 * 이벤트 프로그램 처리순서
 * 1.이벤트의 종류와 이벤트 소스 결정하기
 * MouseEvent frame
 * 2.이벤트 핸들러를 작성
 * 3. 이벤트 소스와 핸들러를 등록하는 작업 진행
 */

//어댑터 패턴으로 특정 메소드만 오버라이드.
    //사용자가 원하는 패턴으로 변화시켜놓은 형태
    //아래처럼 인터페이스 유형으로 하면 모든 메소드가 오버라이드 된 상태로 유지해야함.
class Handler extends MouseAdapter {
    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        System.out.println("MouseMoved: x="+e.getX()+", y="+e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        System.out.println("MouseClicked: x="+e.getX()+", y="+e.getY());
    }
}
//class Handler2 implements MouseListener{
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println("MouseClicked: x="+e.getX()+", y="+e.getY());
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//
//    }
//}
//class Handler1 implements MouseMotionListener{
//    @Override
//    public void mouseDragged(MouseEvent e) {
//    }
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        System.out.println("MouseMoved: x="+e.getX()+", y="+e.getY());
//    }
//}
public class HorseRace {
    private JFrame frame;
    public HorseRace() {
        frame = new JFrame();
        frame.setTitle("Horse Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Handler h= new Handler();
        frame.addMouseListener(h);
        frame.addMouseMotionListener(h);
//        Handler1 h1=new Handler1();
//        Handler2 h2=new Handler2();
//        frame.addMouseListener(h2);
//        frame.addMouseMotionListener(h1);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HorseRace();
    }
}
