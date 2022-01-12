package bingo;

public class Bord {
    long[][] data;

    public Bord(long[][] data) {
        this.data = data;
    }
    public void marked(long card){
        for(int i=0;i <data.length;i++){
            for(int j=0;j<data.length;j++){
                if(data[i][j]==card){
                    data[i][j]=0;
                }
            }
        }
    }
    private Boolean winRow(){
        Boolean win=false;
        for(int i=0;i <data.length;i++){
            int count=0;
            for(int j=0;j<data[0].length;j++){
               count +=data[i][j];
            }
            if(count==0){
                return true;
            }
        }
        return win;
    }
    private Boolean winCol(){
        Boolean win=false;
        for(int i=0;i <data[0].length;i++){
            int count=0;
            for(int j=0;j<data.length;j++){
               count +=data[i][j];
            }
            if(count==0){
                return true;
            }
        }
        return win;
    }
    public Boolean win(){
        if(winCol() || winRow()){
            return  true;
        }
        return false;
    }
    public int scored(int called){
        int count=0;
        for(int i=0;i <data.length;i++){
            for(int j=0;j<data[0].length;j++){
                count +=data[i][j];
            }

        }
        System.out.println( count * called);
        return count * called;
    }
}
