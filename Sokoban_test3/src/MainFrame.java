import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Sokoban");//프레임 생성
		frame.setSize(500, 500);//프레임 크기
		frame.setLocationRelativeTo(null);//가운데 배치
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		FlowLayout fLay = new FlowLayout();//레이아웃 설정
		frame.getContentPane().setLayout(null);

		JButton btn1 = new JButton("START");//스타트 버튼
		JButton btn2 = new JButton("QUIT");

		btn1.setBounds(180, 280, 130, 40);
		btn2.setBounds(180, 350, 130, 40);
		
		frame.getContentPane().add(btn1);
		frame.getContentPane().add(btn2);
		
		JLabel lbl = new JLabel();
		lbl.setBounds(105, 200, 274, 40);
		lbl.setText("BEST SCORE");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lbl);
		
		frame.setVisible(true);//프레임 보이도록 설정
		
		//System.out.println(frame.getContentPane().getSize());
	}

}
