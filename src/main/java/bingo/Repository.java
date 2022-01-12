package bingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public  String[] getCards(){
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\files\\card.txt"))) {
            String[] line = br.readLine().split(",");
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
    public long getBord(){
        try(BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\files\\data.txt"))) {
            List<Bord> list = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                long[][] matrix = new long[5][5];
                Bord bord =new Bord(matrix);
               for(int i=0;i<5;i++){
                   line= line.replaceAll("\\s{2,}", " ").trim();
                   String[] row = line.split(" ");
                   line =br.readLine();
                   for (int j=0;j<5;j++){
                       matrix[i][j] = Long.parseLong(row[j]);
                   }
               }
               list.add(bord);
                line = br.readLine();

            }
        //    System.out.println(list);

                for(int i=0;i<getCards().length;i++){
                    for(Bord bord:list){
                    bord.marked(Long.parseLong(getCards()[i]));
                    if( bord.win()){
                        return bord.scored(Integer.parseInt(getCards()[i]));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
