package fexus.com.br.perguntasc.extras;

/**
 * Created by Fernando
 */
public class InformationQuestion1 {
    private String answer;
    private int number;
    private boolean isCorrect;

    public String getAnswer() {
        return answer;
    }

    public int getNumber() {
        return number;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
