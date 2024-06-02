class Bnum{
  public int[][] bnum(int[][] Feild){
    for(int i = 0; i< 10; i++){
      for(int j = 0; j < 22; j++){
        int c = 0;
          if(Feild[i][j] == 0){
            if(i != 0){
              if(Feild[i-1][j] == 9 ){
                c++;
              }
            }
            if(i != 9){
              if(Feild[i+1][j] == 9){
                c++;
              }
            }
            if(j != 0){
              if(Feild[i][j-1] == 9){
                c++;
              }
            }
            if(j != 21){
              if(Feild[i][j+1] == 9){
                c++;
              }
            }
            Feild[i][j] = c;
          }

      }
    }
    return Feild;
  }
}