package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Subject {

    private int codigo;
    private Bimester firstBimester;
    private Bimester secondBimester;
    private Bimester thridBimester;
    private Bimester fourthBimester;

    public Subject(int codigo){
        this.codigo = codigo;
        firstBimester = new Bimester(1, 0, 0);
        secondBimester = new Bimester(2, 0, 0);
        thridBimester = new Bimester(3, 0, 0);
        fourthBimester = new Bimester(4, 0, 0);
    }

    public void load(Connection conn) {
        String sqlSelect = "SELECT * FROM uni_subject WHERE id = ?";
        
        try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, this.getCodigo());
            
            try (ResultSet rs = stm.executeQuery();) {
                if(rs.next()) {
                    
                    this.getFirstBimester().setGrade(rs.getDouble(2));
                    this.getFirstBimester().setAbsence(rs.getInt(3));
                    this.getSecondBimester().setGrade(rs.getDouble(4));
                    this.getSecondBimester().setAbsence(rs.getInt(5));
                    this.getThridBimester().setGrade(rs.getDouble(6));
                    this.getThridBimester().setAbsence(rs.getInt(7));
                    this.getFourthBimester().setGrade(rs.getDouble(8));
                    this.getFourthBimester().setAbsence(rs.getInt(9));
                    
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    public void updateGrade(Bimester bimester, Connection conn) {
        String sqlUpdate = "UPDATE uni_subject SET n%s = ? WHERE id = ?";
        sqlUpdate = String.format(sqlUpdate, Integer.toString(bimester.getNumber()));

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setDouble(1, bimester.getGrade());
            stm.setInt(2, codigo);
        } catch(Exception ex) {
            try {
                conn.rollback();
            } catch(SQLException ex_sql) {
                System.out.println(ex_sql.getStackTrace());
            }
        }
    }

    public void updateAbsence(Bimester bimester, Connection conn) {
        String sqlUpdate = "UPDATE uni_subject SET f%s = ? WHERE id = ?";
        sqlUpdate = String.format(sqlUpdate, Integer.toString(bimester.getNumber()));

        try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setDouble(1, bimester.getAbsence());
            stm.setInt(2, codigo);
        } catch(Exception ex) {
            try {
                conn.rollback();
            } catch(SQLException ex_sql) {
                System.out.println(ex_sql.getStackTrace());
            }
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Bimester getFirstBimester() {
        return firstBimester;
    }

    public void setFirstBimester(Bimester firstBimester) {
        this.firstBimester = firstBimester;
    }

    public Bimester getSecondBimester() {
        return secondBimester;
    }

    public void setSecondBimester(Bimester secondBimester) {
        this.secondBimester = secondBimester;
    }

    public Bimester getThridBimester() {
        return thridBimester;
    }

    public void setThridBimester(Bimester thridBimester) {
        this.thridBimester = thridBimester;
    }

    public Bimester getFourthBimester() {
        return fourthBimester;
    }

    public void setFourthBimester(Bimester fourthBimester) {
        this.fourthBimester = fourthBimester;
    }

}
