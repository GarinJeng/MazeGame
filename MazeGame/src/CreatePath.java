import java.lang.Math;

class CreatePath {
  private int P[] = {0,0};
  
  public int[][] createPath(int[][] array1){
    int[][] array = array1.clone();
    P[0] = (int)(Math.random() *10);
    while (P[1]!=21){
      int c = (int)(Math.random() *5);
      if (c == 0){
        if(P[0] != 9){
           P[0]++;
        }
      }else if(c == 1){
        if(P[0]>0){
          P[0]--;
        }
      }else if(c==2){
        if(P[1] >0){
          P[1]--;
        }
      }else{
        P[1]++;
      }
      //System.out.println(P[0] +" " + P[1]);
      array[P[0]][P[1]] = 0;
      
    }
    return array1;
  }
}