package entities;

public class Bimester {
    
    private int number;
    private double grade;
    private double absence;
    
    public Bimester(int number, double grade, double absence) {
        this.number = number;
        this.grade = grade;
        this.absence = absence;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public double getAbsence() {
        return absence;
    }
    public void setAbsence(double absence) {
        this.absence = absence;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}
