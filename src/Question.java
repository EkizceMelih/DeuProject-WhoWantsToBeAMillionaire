public class Question {
	
//initializations
private String category, text, a, b, c, d, correct; String difficulty;

//constructing Question object
public Question(String input0,String input1,String input2, String input3, String input4, String input5, String input6, String input7) {
category = input0;
text = input1;
a = input2;
b = input3;
c = input4;
d = input5;
correct = input6;
difficulty = input7;
}

public Question(String[] temp) {
	// TODO Auto-generated constructor stub
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public String getA() {
	return a;
}

public void setA(String a) {
	this.a = a;
}

public String getB() {
	return b;
}

public void setB(String b) {
	this.b = b;
}

public String getC() {
	return c;
}

public void setC(String c) {
	this.c = c;
}

public String getD() {
	return d;
}

public void setD(String d) {
	this.d = d;
}

public String getCorrect() {
	return correct;
}

public int getCorrectInt() {
	switch (correct) {
	case "A":
		return 1;
	case "B":
		return 2;
	case "C":
		return 3;
	case "D":
		return 4;
	default: return 0;
	}
}

public void setCorrect(String correct) {
	this.correct = correct;
}

public String getDifficulty() {
	return difficulty;
}

public void setDifficulty(String difficulty) {
	this.difficulty = difficulty;
}



}

