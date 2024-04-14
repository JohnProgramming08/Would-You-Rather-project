import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;


public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome to would you rather!\n2 options will appear on the screen.\nYou simply just have to choose the one that you would rather do!");
    Scanner sc = new Scanner(System.in);

    String[][] questions = {{"have a pet dog(0) or a pet cat(1)?", "question1.txt"},
                            {"be a karate master(0) or a boxing champion(1)?", "question2.txt"},
                            {"live forever(0) or die now(1)?", "question3.txt"}, 
                            {"kill your best friend(0) or kill 5 random people(1)?", "question4.txt"},
                            {"burn to death(0) or drown(1)?", "question5.txt"},
                            {"live 1000 years in the future(0) or 1000 years in the past(1)?", "question6.txt"},
                            {"have a million pound car(0) or a million pound house(1)?", "question7.txt"},
                            {"be the best football player(0) or the best basketball player(1)?", "question8.txt"},
                            {"have no hair(0) or no beard(1)?", "question9.txt"},
                            {"have no family(0) or no friends(1)?", "question10.txt"}};

    //asks the user all questions in the array
    for (int i = 0; i < questions.length; i++) {
      System.out.println("----------");
      System.out.println("Question " + (i + 1));
      System.out.println("Would you rather " + questions[i][0]);
      String choice = sc.nextLine();
      int percentage = (question(choice, questions[i][1]));
      System.out.println(percentage + "% of people agreed with you!");
    }
  }

  //stores choice in file and calculates the number of people that agreed with the user
  public static int question(String choice, String file) {
    ArrayList<String> answers = new ArrayList<String>();
    int yes = 0;
    int no = 0;

    //adds file contents to the answers array
    try{
      File file1 = new File(file);
      Scanner sc2 = new Scanner(file1);
      while(sc2.hasNextLine()) {
        String data = sc2.nextLine();
        answers.add(data);
      }

      //calculates how many people agree and disagree with the user
      for (int i = 0; i < answers.size(); i++) {
        if (answers.get(i).equals("1")) {
          yes++;
        }
        else {
          no++;
        }
      }

      FileWriter writer = new FileWriter(file, true);
      writer.write(choice + "\n");
      writer.close();

      //calculates percentage of people who agree with the user
      if (choice.equals("1")) {
        yes++;
        int total = yes + no;
        int percent = (yes * 100) / total;
        return percent;
      } 
      else {
        no++;
        int total = yes + no;
        int percent = (no * 100) / total;
        return percent;
      }
    }
    catch (Exception e) {
      return 101;
    }
  }
}