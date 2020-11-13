import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, WrongCommandException {
        ArrayList<List<String>> group = new ArrayList<List<String>>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter path location:");
       String path=scanner.nextLine();
       try {
           File file=new File(path);
           Scanner scan=new Scanner(file);
           System.out.println("File:");
           while(scan.hasNextLine()){
               group.add(Arrays.asList(scan.nextLine().split("\\s+")));
           }

       }catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }
        for (List<String> list : group) {
            for (String i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        Swap item=new Swap();
        System.out.println("1.Switch two lines, command: Switch <first line index> <second line index>");
        System.out.println("2.Swap two elements at given indexes:, command Switch <first line index> <first line word index> <second line index> <second line word index");
        System.out.println("Type end when you have finished editing");
        String command= scanner.nextLine();
        while(!command.equalsIgnoreCase("end")){
            String[] commandArray=command.split(" ");

            if(commandArray[0].equals("Switch")){
                try {
                    int index1 = Integer.parseInt(commandArray[1]);
                    int index2 = Integer.parseInt(commandArray[2]);
                    item.SwappingLines(group,index1,index2);
                }catch (IndexOutOfBoundsException e){
                    System.out.println("Index out of bounds");
                    e.printStackTrace();
                }

            }
            else if(commandArray[0].equals("Swap")){
                int line1=Integer.parseInt(commandArray[1]);
                int row1=Integer.parseInt(commandArray[2]);
                int line2=Integer.parseInt(commandArray[3]);
                int row2=Integer.parseInt(commandArray[4]);
                item.SwappingElements(group,line1,row1,line2,row2);
            }
            else throw new WrongCommandException();
            for (List<String> list : group) {
                for (String i : list) {
                    System.out.print(i+" ");
                }
                System.out.println();
            }


            command=scanner.nextLine();
        }

       // String wordsToString=group.toString();
       String str1= item.Formatting(group);
        try {
            FileWriter writer=new FileWriter(path);
            writer.write(str1);
            writer.close();
        } catch (IOException e) {
            System.out.println("");
            e.printStackTrace();
        }
    }

}
