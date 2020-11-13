import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Swap {
   public void SwappingLines(ArrayList<List<String>> group,int index1,int index2){
       Collections.swap(group,index1,index2);
   }
   public void SwappingElements(ArrayList<List<String>> group,int line1,int row1,int line2,int row2){
       String temp=(group.get(line1).get(row1));
       group.get(line1).set(row1,group.get(line2).get(row2));
       group.get(line2).set(row2,temp);
   }
   public String Formatting(ArrayList<List<String>> group){
       StringBuilder strBuilder=new StringBuilder();
       for (int i = 0; i <group.size() ; i++) {
           strBuilder.append(group.get(i)).append(System.lineSeparator());
       }
       String str1=strBuilder.toString();
       return str1= str1.replaceAll("\\[","").replaceAll("\\]","").replaceAll("\\,","");
   }
}
