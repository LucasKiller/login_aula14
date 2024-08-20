package utils;

import java.sql.Connection;

import entities.Subject;

public class FetchTableData {
    
    public static Object[][] loadTableData(int numberOfSubjects, Subject subject, Connection conn) {

        Object[][] aux = new Object[numberOfSubjects][10];

        while(numberOfSubjects > 0) {

            subject.load(conn);

            aux[subject.getCodigo() - 1][0] = subject.getCodigo() == 1 ? "Cálculo" : "Programação";
            aux[subject.getCodigo() - 1][1] = subject.getFirstBimester().getGrade();
            aux[subject.getCodigo() - 1][2] = subject.getFirstBimester().getAbsence();
            aux[subject.getCodigo() - 1][3] = subject.getSecondBimester().getGrade();
            aux[subject.getCodigo() - 1][4] = subject.getSecondBimester().getAbsence();
            aux[subject.getCodigo() - 1][5] = subject.getThridBimester().getGrade();
            aux[subject.getCodigo() - 1][6] = subject.getThridBimester().getAbsence();
            aux[subject.getCodigo() - 1][7] = subject.getFourthBimester().getGrade();
            aux[subject.getCodigo() - 1][8] = subject.getFourthBimester().getAbsence();

            subject.setCodigo(subject.getCodigo() + 1);

            numberOfSubjects--;

        }

        return aux;

    }

}
