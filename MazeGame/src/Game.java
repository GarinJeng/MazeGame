import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.net.URL;
import java.util.ArrayList;


public class Game extends JPanel implements ActionListener, KeyListener {
   public static Game game;
  private int e = 0;
  private int y = 0;
  private int p1B[][];
  private int p2B[][];
  private int p1[] = {0,0};
  private int p2[] = {0,0};
  private int diff = 0;
  private int time = 200;
  private boolean on = false;
  private Boolean dWin = false;
  private Boolean win = false;
  private int s = 0;
  private int c = 15;
  private int off = 0;
  private boolean win2 = false;
  private int Pai[] = {0,0};
  private JButton b = new JButton("continue");
  private int[][] Win ={ {0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,0,1,1,1,1,0},{0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,0,1,1,1,1,0},{0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,0},{1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,0,1,1,1,0},{1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,0,1,1,0,1,1,0},{1,0,1,1,1,0,0,1,1,1,0,1,1,0,1,0,1,1,0,1,1,0},{1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0},{1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,0},{1,1,0,1,0,1,1,0,1,0,1,1,1,0,1,0,1,1,1,1,0,0},{1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1,1,0,0}};
   private int[][] ai = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
   private Timer timer;
   private static JFrame frame = new JFrame("Game");
  private JPanel pan = new JPanel();
   private int[] keys = {KeyEvent.VK_W,KeyEvent.VK_A,KeyEvent.VK_S,KeyEvent.VK_D,KeyEvent.VK_LEFT,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_UP};
   private String[] KeyN = {"W","A","S","D","J","K","L","I"};
   private Dimension screenSize = new Dimension(555,575);


   public Game(int[][] P1, int[][] P2, int t, boolean o) {
      p1B = P1;
      p2B = P2;
     time = t;
     on = o;
       setPreferredSize(new Dimension(screenSize));
       addKeyListener(this);
       setFocusable(true);
       //initGame();
   }
   public void Start(){
       initGame();
   }
   public void initGame() {
       timer = new Timer(15, this);
       timer.start();
   }
   @Override
   public void actionPerformed(ActionEvent e) {
       update();
       repaint();
   }


   private void update() {
     if (win2){
      
     }
     if(!win){
       if(on){
     if (e < time){
       e++;
     }else{
      AI();
       e=0;
     }
     }
     }
       if (p1B[p1[0]][p1[1]] == 9){
         p1[0] = 0;
         p1[1] = 0;
       }
     if (p2B[p2[0]][p2[1]] == 9){
         p2[0] = 0;
         p2[1] = 0;
       }
      //sSystem.out.println(p1[0] + " " + p1[1]);
      if (p2[1] == 21){
        win = true;
        //win2 = true;
        //System.out.println("winner, Player 2");
      }
     if (p1[1] == 21){
       win = true;
       //win2 = true;
       off = 300;
       //System.out.println("winner, Player 1");
      }
     if(c > 0){
         c--;
       }else{
         c = 30;
         s++;
       }
     if (s == 22){
       s = 0;
     }
   }

   @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
     g2d.setColor(Color.decode("#565a5e"));
       g2d.fillRect(0, 0, getWidth(), getHeight());
     if(!win2){
     g2d.setColor(Color.decode("#a6deb6"));
     g2d.setColor(Color.decode("#7eafe0"));
      for(int i = 0; i <= 20;i++){
        for (int j = 0; j <= 9; j++){
          g2d.fillRect(5+(i*25), 5+(j*25), 20, 20);
          //if 
        }
      }
     for(int i = 0; i <= 20;i++){
        for (int j = 0; j <= 9; j++){
          g2d.fillRect(5+(i*25), 305+(j*25), 20, 20);
          //if 
        }
      }
     g2d.setColor(Color.WHITE);
     for (int j = 0; j <= 4; j++){
          g2d.fillRect(530, 5+(j*50), 20, 20);
          //if 
        }
     g2d.setColor(Color.BLACK);
     for (int j = 0; j <= 4; j++){
          g2d.fillRect(530, 30+(j*50), 20, 20);
          //if 
        }
     g2d.setColor(Color.WHITE);
     for (int j = 0; j <= 4; j++){
          g2d.fillRect(530, 305+(j*50), 20, 20);
          //if 
        }
     g2d.setColor(Color.BLACK);
     for (int j = 0; j <= 4; j++){
          g2d.fillRect(530, 330+(j*50), 20, 20);
          //if 
        }
      if (p1B[p1[0]][p1[1]] == 0){
        g2d.setColor(Color.decode("#29C60D"));
      }else if (p1B[p1[0]][p1[1]] == 1){
        g2d.setColor(Color.decode("#F4FD1B"));
      }else if (p1B[p1[0]][p1[1]] == 2){
        g2d.setColor(Color.decode("#F66229"));
      }else{
        g2d.setColor(Color.decode("#C42626"));
      }
    g2d.fillRect(5+(p1[1]*25), 5+(p1[0]*25), 20, 20);
      if (p2B[p2[0]][p2[1]] == 0){
        g2d.setColor(Color.decode("#29C60D"));
      }else if (p2B[p2[0]][p2[1]] == 1){
        g2d.setColor(Color.decode("#F4FD1B"));
      }else if (p2B[p2[0]][p2[1]] == 2){
        g2d.setColor(Color.decode("#F66229"));
      }else{
        g2d.setColor(Color.decode("#C42626"));
      }
     g2d.fillRect(5+(p2[1]*25), 305+(p2[0]*25), 20, 20);
     // 0 = Green, 1= Yellow, Orange = 2, Red = 3
     if (win){
       for(int i = 0; i <= 20;i++){
        for (int j = 0; j <= 9; j++){
          if (p1B[j][i] == 0){
        g2d.setColor(Color.decode("#29C60D"));
      }else if (p1B[j][i] == 1){
        g2d.setColor(Color.decode("#F4FD1B"));
      }else if (p1B[j][i] == 2){
        g2d.setColor(Color.decode("#F66229"));
      }else if (p1B[j][i] == 3){
        g2d.setColor(Color.decode("#C42626"));
      }else{
        g2d.setColor(Color.decode("#7eafe0"));
      }
          g2d.fillRect(5+(i*25), 5+(j*25), 20, 20); 
        }
      }
       for(int i = 0; i <= 20;i++){
        for (int j = 0; j <= 9; j++){
           if (p2B[j][i] == 0){
        g2d.setColor(Color.decode("#29C60D"));
      }else if (p2B[j][i] == 1){
        g2d.setColor(Color.decode("#F4FD1B"));
      }else if (p2B[j][i] == 2){
        g2d.setColor(Color.decode("#F66229"));
      }else if (p2B[j][i] == 3){
        g2d.setColor(Color.decode("#C42626"));
      }else{
        g2d.setColor(Color.decode("#7eafe0"));
      }
          g2d.fillRect(5+(i*25), 305+(j*25), 20, 20);
          //if 
        }
      }
     }
     }else{
       for(int i = 0; i <= 21;i++){
        for (int j = 0; j <= 9; j++){
           if (Win[j][i] == 0){
        g2d.setColor(Color.decode("#29C60D"));
      }else{
           g2d.setColor(Color.decode("#7eafe0"));
      }
          g2d.fillRect(5+(i*25), 305+(j*25)-off, 20, 20);
        }
       }
       /*
       for(int i = 0; i <= s;i++){
        for (int j = 0; j <= 9; j++){
           if (Win[j][i] == 0){
        g2d.setColor(Color.decode("#29C60D"));
      }else{
           g2d.setColor(Color.decode("#7eafe0"));
      }
          g2d.fillRect(5+(21-s*25), 305+(j*25), 20, 20);
        }
       }
       */
       
    }
   }


   @Override
   public void keyTyped(KeyEvent e) {
   }
   @Override
   public void keyPressed(KeyEvent e) {
     if(!win){
      if (e.getKeyCode() == keys[0] && p1[0] != 0){ 
        p1[0]--;
      }
     if (e.getKeyCode() == keys[1]&& p1[1] != 0) {
        p1[1]--;
      }
     if (e.getKeyCode() == keys[2] && p1[0] != 9) {
        p1[0]++;
      }
     if (e.getKeyCode() == keys[3]) {
        p1[1]++;
      }
     if (!on){
     if (e.getKeyCode() == keys[4]&& p2[1] != 0) {
        p2[1]--;
      }
     if (e.getKeyCode() == keys[5] && p2[0] != 9) {
        p2[0]++;
      }
     if (e.getKeyCode() == keys[6]) {
          p2[1]++;
      }
     if (e.getKeyCode() == keys[7] && p2[0] != 0) {
          p2[0]--;
      }
     }
     }
     if (e.getKeyCode() == KeyEvent.VK_K){
        win = true;
     }
   }
   @Override
   public void keyReleased(KeyEvent e) {
       if (e.getKeyCode() == keys[0]){ 
        
      }
     if (e.getKeyCode() == keys[1]) {
        
      }
     if (e.getKeyCode() == keys[2]) {
        
      }
     if (e.getKeyCode() == keys[3]) {
        
      }
     if (e.getKeyCode() == keys[4]) {
        
      }
     if (e.getKeyCode() == keys[5]) {
        
      }
     if (e.getKeyCode() == keys[6]) {
     }
          
     if (e.getKeyCode() == keys[7]) {
         
      }
     if (e.getKeyCode() == KeyEvent.VK_K){
       win = false;
     }
   }
   public void startTimer(){
       timer.restart();
   }
   public void start(){
       SwingUtilities.invokeLater(() -> {
            
           
           //frame.setVisible(true);
         JFrame Frame = new JFrame();
         JPanel P = new JPanel();
         JButton S = new JButton("Start");
         JButton R = new JButton("Rules");
         JButton A = new JButton("OFF");
         JLabel C = new JLabel("CPU difficulty", SwingConstants.CENTER);
         JLabel r = new JLabel("<html>The game of Mazesweeper is a combination of an invisible maze and the game minesweeper. Your goal is to get to the other side before the AI. The problem is, you can only detect the number of bombs around the player. You have to find the path and make it to the other side of the maze. If the tile you're on is green there are no bombs around you, if the tile you are on is yellow there is one bomb around you, if the tile you are on is orange there are two bombs around you, and if the tile you are on is red there are three bombs around you. Use WASD to control player 1 and arrow keys to control player 2. The arrow keys will not work if the AI is activated. Good luck and press start when you're ready! (If you get to angry you can press K to reveal the path while pressed game is paused)</html>", SwingConstants.CENTER);
         S.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              game.setTime(time, on);
              game.Start();
              frame.setVisible(true);
              Frame.hide();
            }
          });
         //System.out.println(time);
         R.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              if(y == 0){
              S.hide();
              A.hide();
              C.hide();
              r.show();
              R.setBounds(227,500,100,30);
              R.setText("Back");
                y++;
              }else{
                S.show();
              A.show();
              C.show();
              r.hide();
                y--;
              R.setBounds(227,180,100,30);
                R.setText("Rules");
              }
            }
          });
         A.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              diff++;
              if(diff > 4){
                diff = 0;
              }
              if (diff == 0){
                time = -1;
                on = false;
                A.setText("OFF");
              }else if (diff == 1){
                time = 25;
                A.setText("Easy");
                on = true;
              }else if (diff == 2){
                time = 20;
                A.setText("Medium");
              }else if (diff == 3){
                time = 15;
                A.setText("Hard");
              }else{
                time = 0;
                A.setText("Noob");
              }
              //System.out.println(time);
            }
          });
        P.setLayout(null);
         P.setBounds(0,0,555,575);
         Frame.add(P);
         P.setBounds(0,0,555,575);
         P.add(S);
         P.add(R);
         P.add(A);
         P.add(C);
         P.add(r);
         r.hide();
         C.setBounds(227,300,100,30);
         r.setBounds(27,40,500,500);
         S.setBounds(227,30,100,30);
         R.setBounds(227,180,100,30);
         A.setBounds(227,330,100,30);
         Frame.setSize(screenSize);
         Frame.requestFocus();
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
         //System.out.println(time);
    
         //frame.add(b);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           //frame.add(game);
          /*b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              win2 = true;
            }
          });
         b.setBounds(250,260,100,30);*/
        game = new Game(p1B,p2B,time, on);
         pan.setLayout(null);
         pan.setBounds(250,5,55,500);
         //pan.setVisible(false);
         frame.add(pan);
         frame.add(game);
        pan.add(b);
         b.setBounds(250,250,100,30);
           frame.pack();
         frame.setSize(screenSize);
      
            frame.requestFocus();
           frame.setLocationRelativeTo(null);
       });
     
   }
  public void AI(){
    int i = 0;
    try{
    if((ai[Pai[1]][Pai[0]+1] != 0)&&(Pai[1] == 9||ai[Pai[1]+1][Pai[0]] != 0)&&(ai[Pai[1]][Pai[0]-1] != 0)&&(Pai[1] == 0||ai[Pai[1]-1][Pai[0]] != 0)){
      ai[Pai[1]][Pai[0]] = 9;
      p2[1] = 0;
      p2[0] = 0;
      Pai[0]++;
      //for(int k = 0; k <= 21;k++){
        //for (int j = 0; j <= 9; j++){
          //System.out.print(ai[j][k]);
        //}
        //System.out.println("");
      //}
    }
   
    if((p2[0] == 0 && p2[1] == 0)&&(Pai[0]!=0&&Pai[0] != 0)){
      ai[Pai[1]][Pai[0]] = 2;
      Pai[0] = 0;
      Pai[1] = 0;
      clearm();
      
    }
    if (ai[Pai[1]][Pai[0]+1] == 0){
      p2[1]++;
      Pai[0]++;
    }else if(Pai[1] != 9&&ai[Pai[1]+1][Pai[0]] == 0 ){
      p2[0]++;
      Pai[1]++;
    }else if(Pai[1] != 0&&ai[Pai[1]-1][Pai[0]] == 0){
      p2[0]--;
      Pai[1]--;
    }else{
      p2[1]--;
      Pai[0]--;
    }
    ai[Pai[1]][Pai[0]] = 1;
       }catch(Exception e){}
  }
   public void clearm(){
      for(int i = 0; i <= 21;i++){
        for (int j = 0; j <= 9; j++){
            if (ai[j][i] == 1){
              ai[j][i] = 0;
            }
        }

      }
    }
  public void setTime(int t,boolean o){
    time = t;
    on = o;
  }
}