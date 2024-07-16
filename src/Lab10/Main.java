package Lab10;

import java.io.*;
import java.util.ArrayList;

class PopularName implements Serializable{
    String name;
    int count;
    int rank;

    public PopularName(String name, int count, int rank) {
        this.name = name;
        this.count = count;
        this.rank = rank;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<PopularName> malesNames = new ArrayList<>();
        ArrayList<PopularName> femaleNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("names.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                malesNames.add(new PopularName(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[0])));
                femaleNames.add(new PopularName(data[3], Integer.parseInt(data[4]), Integer.parseInt(data[0])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Top 10 Male Names: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(malesNames.get(i).name);
        }

        System.out.println("\nTop 10 Female Names: ");
        for (int i = 0; i < 10; i++) {
            System.out.println(femaleNames.get(i).name);
        }

        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("binarynames.dat"))){
            for(PopularName name : malesNames){
                write.writeObject(name);
            }
            for (PopularName femaleName : femaleNames){
                write.writeObject(femaleName);
            }
        } catch (IOException e) {
            System.out.println("Error writing in the file!");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }

        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream("binarynames.dat"))){
            for(int i = 0; i < malesNames.size(); i++){
                PopularName maleName = (PopularName) read.readObject();
                System.out.println("Male Name: " + maleName.name + ", Count: " + maleName.count + ", Rank: " + maleName.rank);
            }
            System.out.println("-".repeat(30));
            for(int i = 0; i < femaleNames.size(); i++){
                PopularName femaleName = (PopularName) read.readObject();
                System.out.println("Female Name: " + femaleName.name + ", Count: " + femaleName.count + ", Rank: " + femaleName.rank);
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }catch (IOException e){
            System.out.println("Error writing in the file");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
