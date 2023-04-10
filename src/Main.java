import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.io.FileInputStream;
import java.util.Scanner; // Import the Scanner class to read text files
import enigma.core.Enigma;
public class Main {
    public static void random(Question exam,String answer,int questionNumber) {
        int temp = 0;
        System.out.print("Q"+questionNumber+"- ");
        System.out.println(exam.getText());
        if(answer.toUpperCase().contains("A")) {
            temp=1;
            System.out.println("A) "+exam.getA());
        }
        else if(answer.toUpperCase().contains("B")) {
            temp=2;
            System.out.println("B) "+exam.getB());
        }
        else if(answer.toUpperCase().contains("C")) {
            temp=3;
            System.out.println("C) "+exam.getC());
        }
        else if(answer.toUpperCase().contains("D")) {
            temp=4;
            System.out.println("D) "+exam.getD());
        }
        Random rand=new Random();
        int rand_int=0;
        for (int i = 0; i < 10; i++) {
            rand_int=rand.nextInt(1,5);
            if(rand_int!=temp) {
                break;
            }
        }
        if(rand_int==1) {
            System.out.println("A) "+exam.getA());
        }
        else if(rand_int==2) {
            System.out.println("B) "+exam.getB());
        }
        else if(rand_int==3) {
            System.out.println("C) "+exam.getC());
                }
        else if(rand_int==4) {
            System.out.println("D) "+exam.getD());
        }
    }
    public static String dStop(String temp) throws FileNotFoundException {
        File stopwords = new File("C:\\Users\\darkb\\eclipse-workspace\\projectdeneme\\src\\stop_words.txt");
        Scanner myReader0=new Scanner(stopwords);
        int index0=0;
        String []tempStop=new String[851];
        while (myReader0.hasNextLine()) {
            tempStop[index0] = myReader0.nextLine();
            index0++;
            }
        for (int i = 0; i < tempStop.length; i++) {
            if(temp.toLowerCase().equals(tempStop[i])) {
                temp="";
                return(temp);
            }
        }
        return(temp);
    }
    public static boolean [] percent50(Question temp10,boolean doubleDip,boolean percent50,int money,int questionNumber) {
        while(true){
            System.out.println();
            boolean [] temp=new boolean[2];
            random(temp10,temp10.getCorrect(),questionNumber);
            System.out.print("What is your answer:");
            Scanner input=new Scanner(System.in);
            String userQuestions=input.next();
            if(userQuestions.toUpperCase().equals(temp10.getCorrect())) {
                temp[0]=true;
                temp[1]=doubleDip;
                return temp;
            }
            else if(userQuestions.toUpperCase().equals("DP")) {
                if(doubleDip) {
                    doubleDip=false;
                    temp=dp(temp10,doubleDip, percent50, money, questionNumber);
                    temp[0]=true;
                    temp[1]=doubleDip;
                    return temp;
                }
                else {
                    System.out.println("you used your doubledip right please choose right option");
                }
            }
            else {
                temp[0]=false;
                temp[1]=doubleDip;
                return temp;
            }
        }
        
    }
    public static boolean [] dp(Question temp,boolean doubleDip,boolean percent50,int money,int questionNumber) {
        while(true) {
            Scanner input=new Scanner(System.in);
            boolean[] returner=new boolean[2];
            System.out.println("First Chance: ");
            String userQuestions=input.next();
            if(userQuestions.toUpperCase().equals(temp.getCorrect())) {
                returner[0]=true;
                returner[1]=percent50;
                return(returner);
            }
            else if(userQuestions.toUpperCase().equals("50")) {


            }
            else {
                System.out.println("Wrong!!");
                System.out.println("Second Chance: ");
                userQuestions=input.next();
                if(userQuestions.toUpperCase().equals(temp.getCorrect())) {
                    returner[0]=true;
                    returner[1]=percent50;
                    return(returner);
                }
                else if(userQuestions.toUpperCase().equals("50")) {
                    if(percent50) {
                        percent50=false;
                        random(temp,temp.getCorrect(),questionNumber);
                        userQuestions=input.next();
                        if(userQuestions.toUpperCase().equals(temp.getCorrect())) {
                            returner[0]=true;
                            returner[1]=percent50;
                            return(returner);
                        }
                        else {
                                returner[0]=false;
                                returner[1]=percent50;
                                return(returner);
                        }
                    }
                    else {
                        System.out.println("you used your 50% right choose right option");
                    }
                }
                else {
                    returner[0]=false;
                    returner[1]=percent50;
                    return(returner);
                }
            }
        }
    }
    
	public static String Splch(String word) throws FileNotFoundException{
        File myObj3 = new File("C:\\Users\\darkb\\eclipse-workspace\\projectdeneme\\src\\dictionary.txt"); /*we have to take input from user for file name*/
        Scanner myReader3=new Scanner(myObj3);
        String [] temp=new String[370104];
        int i1=0;
        while(myReader3.hasNextLine()) {
            String data = myReader3.nextLine();
            temp[i1] = data;
            i1++;
        }
        myReader3.close();
		
        for (int i = 0; i < temp.length;i++) {
			int counter = 0;
			for (int j = 0; j < temp[i].length(); j++) {				
				for (int j2 = 0; j2 < word.length(); j2++) {					
					if (j2 == j && temp[i].length() == word.length() 
							&& word.toLowerCase().charAt(j) == temp[i].toLowerCase().charAt(j)) 
						counter++;					
				}
			}
			if ((counter == word.length() - 1 || counter == word.length() - 2)
					&& temp[i].length() == word.length()) {         
				return(temp[i]);
			}
			else return word;
		}
        return("abx");
    }
    public static String Punc(String str) {
    	while(str.contains("!") || str.contains(",") || str.contains(".") || str.contains("\"")|| str.contains("?")||str.contains("_")){
            str=str.replace("!", "").replace(",", "").replace(".", "").replace("\"", "").replace("?", "").replace("_", "");
       }
     return str;
	}
    public static Question search(String word,Question [] arr) throws FileNotFoundException {
        
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].getText().toLowerCase().contains(word.toLowerCase())) {
                return arr[i];
            }
        }
        return null;
    }
    public static void questionWriter(Question temp10,boolean doubleDip,boolean percent50,int money,String UserQuestions,int questionNumber) throws FileNotFoundException {
        System.out.println();
        System.out.print("Q"+questionNumber+"- ");
        System.out.println(temp10.getText());
        System.out.println("A) "+temp10.getA()+"                            Money: "+money);
        System.out.println("B) "+temp10.getB()+"                        Remaining Time: ");
        if(doubleDip) {
            System.out.println("C) "+temp10.getC()+"                        DoubleDip");
        }
        else {
            System.out.println("C) "+temp10.getC()+"                        -");
        }
        if(percent50) {
            System.out.println("D) "+temp10.getD()+"                        50%");
        }
        else {
            System.out.println("D) "+temp10.getD()+"                        -");
        }
        System.out.print("What is your answer:");
    }
    public static void main(String []args) throws FileNotFoundException {
        Locale ENG = Locale.forLanguageTag("en");
        enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
        Scanner input=new Scanner(System.in);
        String[] wordCloud1=new String[100];
        String[] wordCloud2=new String[100];
        String[] wordCloud3=new String[100];
        String[] wordCloud4=new String[100];
        String[] wordCloud5=new String[100];
        int index=-1;
        File myObj2 = new File("C:\\Users\\darkb\\eclipse-workspace\\projectdeneme\\src\\questions.txt"); /*we have to take input from user for file name*/
        Scanner myReader2=new Scanner(myObj2);
        int whileCounter=0;
        while(myReader2.hasNextLine()) {
            String data2 = myReader2.nextLine();
            whileCounter++;
        }
        Question[] questionsMap=new Question[18];
        String[] categories = new String[whileCounter];
        int[] categoriesCount = new int[whileCounter];
        for (int i = 0; i < categoriesCount.length; i++) {
            categoriesCount[i]=1;
        }
        
        boolean flag1=false,flag2=false,flag3=true,doubleDip=true,percent50=true,flag4=false;
        boolean[] doubleDip1=new boolean[2];
        boolean[] bPercent50=new boolean[2];
        while(true) {
            int level1Counter=0,level2Counter=0,level3Counter=0,level4Counter=0,level5Counter=0;
            String Keeper="";
            int questionNumber=1;
            int i1=0,i2=0,i3=0,i4=0,i5=0;
        System.out.println("***** Menu *****");
        System.out.println("1.Load questions");
        System.out.println("2.Load participants");
        System.out.println("3.Start competition");
        System.out.println("4.Show statistics");
        System.out.println("5.Exit");
        System.out.print("Enter your choice: ");
        String userInput=input.next();
        if(userInput.equals("1")) {
            System.out.print("Enter file name to load: ");
            String questionsFileName = input.next();
            File myObj1 = new File("C:\\Users\\darkb\\eclipse-workspace\\projectdeneme\\src\\questions.txt"); /*we have to take input from user for file name*/
            Scanner myReader1=new Scanner(myObj1);
            int index1=0;
            while (myReader1.hasNextLine()) {
                String data = myReader1.nextLine();
                String[] temp = data.split("#");
                if(temp[temp.length-1].equals("1")) {
                    level1Counter++;
                }
                else if(temp[temp.length-1].equals("2")) {
                    level2Counter++;
                }
                else if(temp[temp.length-1].equals("3")) {
                    level3Counter++;                
                }
                else if(temp[temp.length-1].equals("4")) {
                    level4Counter++;
                }
                else if(temp[temp.length-1].equals("5")) {
                    level5Counter++;
                }
                if(!Keeper.equals(temp[0])) {
                    index++;
                    Keeper=temp[0];
                }
                else {
                    categories[index]=Keeper;
                    categoriesCount[index]++;
                }
                Question qst=new Question(temp);
                questionsMap[index1]=qst;
                index1++;
            }
            System.out.println("Category     "+"The Number Of Questions");
            System.out.println("--------     "+"-----------------------");
            for (int i = 0; i < categoriesCount.length; i++) {
                if(categories[i]==null || categoriesCount[i]==1) {
                    break;
                }
                System.out.println(categories[i]+"            "+categoriesCount[i]);
            }
            System.out.println();
            System.out.println();
            System.out.println("Difficulty level        "+"The Number Of Questions");
            System.out.println("----------------        "+"-----------------------");
            System.out.println("       1                            "+level1Counter);
            System.out.println("       2                            "+level2Counter);
            System.out.println("       3                            "+level3Counter);
            System.out.println("       4                            "+level4Counter);
            System.out.println("       5                            "+level5Counter);
            flag1=true;
            String wC="";
            for (int i = 0; i < questionsMap.length; i++) {
                String temp=Punc(questionsMap[i].getText());
                String []tempText=temp.split(" ");
                temp="";
                for (int j = 0; j < tempText.length; j++) {
                    wC= spellCheck123(tempText[j], dictReader());
                    if(wC!=null &&wC!="") {
                        temp=temp+" "+wC;
                    }
                    wC=dStop(wC);
                    if(questionsMap[i].getDifficulty().equals("1")) {
                        if(wC!=null &&wC!="") {
                            wordCloud1[i1]=wC.substring(0,1).toUpperCase()+wC.substring(1).toLowerCase();
                            i1++;
                        }
                    }
                    else if(questionsMap[i].getDifficulty().equals("2")) {
                        if(wC!=null &&wC!="") {
                            wordCloud2[i2]=wC.substring(0,1).toUpperCase()+wC.substring(1).toLowerCase();
                            i2++;
                        }
                    }
                    else if(questionsMap[i].getDifficulty().equals("3")) {
                        if(wC!=null &&wC!="") {
                            wordCloud3[i3]=wC.substring(0,1).toUpperCase()+wC.substring(1).toLowerCase();
                            i3++;
                        }
                                        }
                    else if(questionsMap[i].getDifficulty().equals("4")) {
                        if(wC!=null &&wC!="") {
                            wordCloud4[i4]=wC.substring(0,1).toUpperCase()+wC.substring(1).toLowerCase();
                            i4++;
                        }
                    }
                    else if(questionsMap[i].getDifficulty().equals("5")) {
                        if(wC!=null &&wC!="") {
                            wordCloud5[i5]=wC.substring(0,1).toUpperCase()+wC.substring(1).toLowerCase();
                            i5++;
                        }
                    }
                }
                questionsMap[i].setText(temp);
            }
        }
        else if(userInput.equals("2") && flag1) {
                    System.out.print("Enter file name to load: ");
                    String participants=input.next();
                    File myPart = new File("C:\\Users\\darkb\\eclipse-workspace\\projectdeneme\\src\\participants.txt"); /*we have to take input from user for file name*/
                    flag2=true;
        }
        else if(userInput.equals("3")&&flag2&&flag1) {
            doubleDip=true;
            percent50=true;
            int money=0;
            String userQuestions="";
            for (int i = 0; i < wordCloud1.length; i++) {
                if(wordCloud1[i]!=null) {
                    System.out.print(wordCloud1[i]+"  ");
                }
                if(i==wordCloud1.length) {
                    System.out.println();
                }
            }
            System.out.println();
                System.out.println("Choose Your category");
                userQuestions=input.next();
                Question exam=search(userQuestions,questionsMap);
                if(search(userQuestions,questionsMap)!=null) {
                    flag4=true;
                }
                else {
                    System.out.println("Please choose your category correctly");
                }
                while(flag4) {
                    flag4=false;
                    questionWriter(exam,doubleDip,percent50,money,userQuestions,questionNumber);
                    userQuestions=input.next();
                    if(userQuestions.toUpperCase().equals(exam.getCorrect())){
                        System.out.println("Correct!!");
                        flag4=true;
                        money=20000;
                        questionNumber++;
                        break;
                    }
                    else if(userQuestions.toUpperCase().equals("DP")){
                        if(doubleDip) {
                            doubleDip=false;
                            doubleDip1=dp(exam,doubleDip, percent50,money,questionNumber);
                            percent50=doubleDip1[1];
                            if(doubleDip1[0]) {
                                System.out.println("Correct!!");
                                money=20000;
                                flag4=true;
                                questionNumber++;
                            }
                            else {
                                System.out.println("Wrong!!");
                                money=20000;
                            }
                            break;
                        }
                        else {
                            flag4=true;
                            System.out.println("you used your doubleDip right");
                        }
                    }
                    else if(userQuestions.toUpperCase().equals("50")) {
                        if(percent50) {
                            percent50=false;
                            bPercent50=percent50(exam,doubleDip,percent50,money,questionNumber);
                            doubleDip=bPercent50[1];
                            if(bPercent50[0]) {
                                System.out.println("Correct!!");
                                flag4=true;
                                money=100000;
                                questionNumber++;
                            }
                            else {
                                System.out.println("Wrong!!");
                                money=20000;
                            }
                            break;
                        }
                        else {
                            flag4=true;
                            System.out.println("you used your 50% right");
                        }
                    }
                    else {
                        flag4=false;
                        System.out.println("Wrong!!");
                        money=0;
                    }
                }
            if(flag4) {
                for (int i = 0; i < wordCloud2.length; i++) {
                    if(wordCloud2[i]!=null) {
                        System.out.print(wordCloud2[i]+"  ");
                    }
                    if(i==wordCloud2.length) {
                        System.out.println();
                    }
                }
                System.out.println();
                    System.out.println("Choose Your category");
                    userQuestions=input.next();
                    exam=search(userQuestions,questionsMap);
                    if(search(userQuestions,questionsMap)!=null) {
                        flag4=true;
                    }
                    else {
                        System.out.println("Please choose your category correctly");
                    }
            }
            while(flag4) {
                flag4=false;
                questionWriter(exam,doubleDip,percent50,money,userQuestions,questionNumber);
                userQuestions=input.next();
                if(userQuestions.toUpperCase().equals(exam.getCorrect())){
                    System.out.println("Correct!!");
                    flag4=true;
                    money=100000;
                    questionNumber++;
                    break;
                }
                else if(userQuestions.toUpperCase().equals("DP")){
                    if(doubleDip) {
                        doubleDip=false;
                        doubleDip1=dp(exam,doubleDip, percent50,money,questionNumber);
                        percent50=doubleDip1[1];
                        if(doubleDip1[0]) {
                            System.out.println("Correct!!");
                            money=100000;
                            questionNumber++;
                            flag4=true;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your doubleDip right");
                    }
                }
                else if(userQuestions.toUpperCase().equals("50")) {
                    if(percent50) {
                        percent50=false;
                        bPercent50=percent50(exam,doubleDip,percent50,money,questionNumber);
                        doubleDip=bPercent50[1];
                        if(bPercent50[0]) {
                            System.out.println("Correct!!");
                            flag4=true;
                            money=100000;
                            questionNumber++;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your  50% right");
                    }
                }
                else {
                    flag4=false;
                    System.out.println("Wrong!!");
                    money=20000;
                }
            }
            if(flag4) {
                for (int i = 0; i < wordCloud3.length; i++) {
                    if(wordCloud3[i]!=null) {
                        System.out.print(wordCloud3[i]+"  ");
                    }
                    if(i==wordCloud3.length) {
                        System.out.println();
                    }
                }
                System.out.println();
                    System.out.println("Choose Your category");
                    userQuestions=input.next();
                    exam=search(userQuestions,questionsMap);
                    if(search(userQuestions,questionsMap)!=null) {
                        flag4=true;
                    }
                    else {
                        System.out.println("Please choose your category correctly");
                    }
            }
            while(flag4) {
                flag4=false;
                questionWriter(exam,doubleDip,percent50,money,userQuestions,questionNumber);
                userQuestions=input.next();
                if(userQuestions.toUpperCase().equals(exam.getCorrect())){
                    System.out.println("Correct!!");
                    questionNumber++;
                    flag4=true;
                    money=250000;
                    break;
                }
                else if(userQuestions.toUpperCase().equals("DP")){
                    if(doubleDip) {
                        doubleDip=false;
                        doubleDip1=dp(exam,doubleDip, percent50,money,questionNumber);
                        percent50=doubleDip1[1];
                        if(doubleDip1[0]) {
                            System.out.println("Correct!!");
                            questionNumber++;
                            money=100000;
                            flag4=true;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your doubleDip right");
                    }
                }
                else if(userQuestions.toUpperCase().equals("50")) {
                    if(percent50) {
                        percent50=false;
                        bPercent50=percent50(exam,doubleDip,percent50,money,questionNumber);
                        doubleDip=bPercent50[1];
                        if(bPercent50[0]) {
                            System.out.println("Correct!!");
                            questionNumber++;
                            flag4=true;
                            money=100000;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your 50% right");
                    }
                }
                else {
                    flag4=false;
                    System.out.println("Wrong!!");
                    money=20000;
                }
            }
            if(flag4) {
                for (int i = 0; i < wordCloud4.length; i++) {
                    if(wordCloud4[i]!=null) {
                        System.out.print(wordCloud4[i]+"  ");
                    }
                    if(i==wordCloud4.length) {
                        System.out.println();
                    }
                }
                System.out.println();
                    System.out.println("Choose Your category");
                    userQuestions=input.next();
                    exam=search(userQuestions,questionsMap);
                    if(search(userQuestions,questionsMap)!=null) {
                        flag4=true;
                    }
                    else {
                        System.out.println("Please choose your category correctly");
                    }
            }
            while(flag4) {
                flag4=false;
                questionWriter(exam,doubleDip,percent50,money,userQuestions,questionNumber);
                userQuestions=input.next();
                if(userQuestions.toUpperCase().equals(exam.getCorrect())){
                    System.out.println("Correct!!");
                    questionNumber++;
                    flag4=true;
                    money=500000;
                    break;
                }
                else if(userQuestions.toUpperCase().equals("DP")){
                    if(doubleDip) {
                        doubleDip=false;
                        doubleDip1=dp(exam,doubleDip, percent50,money,questionNumber);
                        percent50=doubleDip1[1];
                        if(doubleDip1[0]) {
                            System.out.println("Correct!!");
                            questionNumber++;
                            money=100000;
                            flag4=true;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your doubleDip right");
                    }
                }
                else if(userQuestions.toUpperCase().equals("50")) {
                    if(percent50) {
                        percent50=false;
                        bPercent50=percent50(exam,doubleDip,percent50,money,questionNumber);
                        doubleDip=bPercent50[1];
                        if(bPercent50[0]) {
                            System.out.println("Correct!!");
                            flag4=true;
                            questionNumber++;
                            money=100000;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your 50% right");
                    }
                }
                else {
                    flag4=false;
                    System.out.println("Wrong!!");
                    money=250000;
                }
            }
            if(flag4) {
                for (int i = 0; i < wordCloud5.length; i++) {
                    if(wordCloud5[i]!=null) {
                        System.out.print(wordCloud5[i]+"  ");
                    }
                    if(i==wordCloud5.length) {
                        System.out.println();
                    }
                }
                System.out.println();
                    System.out.println("Choose Your category");
                    userQuestions=input.next();
                    exam=search(userQuestions,questionsMap);
                    if(search(userQuestions,questionsMap)!=null) {
                        flag4=true;
                    }
                    else {
                        System.out.println("Please choose your category correctly");
                    }
            }
            while(flag4) {
                flag4=false;
                questionWriter(exam,doubleDip,percent50,money,userQuestions,questionNumber);
                userQuestions=input.next();
                if(userQuestions.toUpperCase().equals(exam.getCorrect())){
                    System.out.println("Correct!!");
                    questionNumber++;
                    flag4=true;
                    money=1000000;
                    break;
                }
                else if(userQuestions.toUpperCase().equals("DP")){
                    if(doubleDip) {
                        doubleDip=false;
                        doubleDip1=dp(exam,doubleDip, percent50,money,questionNumber);
                        percent50=doubleDip1[1];
                        if(doubleDip1[0]) {
                            System.out.println("Correct!!");
                            questionNumber++;
                            money=100000;
                            flag4=true;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your 50% right");
                    }
                }
                else if(userQuestions.toUpperCase().equals("50")&&percent50) {
                    if(percent50) {
                        percent50=false;
                        bPercent50=percent50(exam,doubleDip,percent50,money,questionNumber);
                        doubleDip=bPercent50[1];
                        if(bPercent50[0]) {
                            System.out.println("Correct!!");
                            questionNumber++;
                            flag4=true;
                            money=100000;
                        }
                        else {
                            System.out.println("Wrong!!");
                            money=20000;
                        }
                        break;
                    }
                    else {
                        flag4=true;
                        System.out.println("you used your doubleDip right");
                    }
                }
                else {
                    flag4=false;
                    System.out.println("Wrong!!");
                    money=250000;
                }
            }
                System.out.println("you earned "+money+" dollars");
        }
        else if(userInput.equals("4")) {
            
        }
        else if(userInput.equals("5")) {
            
        }
        else if (flag1==true && flag2==false){
            System.out.println("You have to choose 2.option first ");
        }
        else if (flag1==false && flag2==false){
            System.out.println("You have to choose 1.option first ");
        }
        else {
            System.out.println("You entered wrong input. Please enter between 0-6");
        }
        }
    }
    public static String spellCheck123(String str ,String[] dict) {
		String suggestion = str;
		boolean flag = false;
		for(String correct : dict) {
			if (correct.equalsIgnoreCase(str)) {
				flag = true;
				break;
			}
		}
		boolean isSuggested = false; 
		if (!flag) {
			for(String correct : dict) {
				int counter = 0;
				if (correct.length() == str.length()) {
					for (int i = 0; i < correct.length(); i++) {
						for (int j = 0; j < str.length(); j++) {
							if (i == j && correct.toLowerCase().charAt(i) == str.toLowerCase().charAt(i)) {
								counter++;
							}
						}
					}
				}
				if (counter == str.length() -1) {
					suggestion = correct;
					isSuggested = true;
					break;
				}
				/*else if (counter == str.length() -2) {
					suggestion = correct;
					break;
				}*/
				
			}
			if (!isSuggested) {
				for(String correct : dict) {
					int counter = 0;
					if (correct.length() == str.length()) {
						for (int i = 0; i < correct.length(); i++) {
							for (int j = 0; j < str.length(); j++) {
								if (i == j && correct.toLowerCase().charAt(i) == str.toLowerCase().charAt(i)) {
									counter++;
								}
							}
						}
					}
					if (counter == str.length() -2) {
						suggestion = correct;
						break;
					}
					/*else if (counter == str.length() -2) {
						suggestion = correct;
						break;
					}*/
					
				}
			}
			
		}
		return suggestion;
	}
	public static String[] dictReader() throws FileNotFoundException {
		int whileCounter = 0;
		File mydict = new File("C:\\Users\\darkb\\eclipse-workspace\\projectdeneme\\src\\dictionary.txt");
		// List<String> list=new ArrayList<String>();
		Scanner mydictreader = new Scanner(mydict);
		String[] array_dict = new String[370103];
		int a = 0;
		while (mydictreader.hasNextLine()) {
			array_dict[a] = mydictreader.nextLine();
			a++;
			whileCounter++;
		}
		return array_dict;
	}
}
