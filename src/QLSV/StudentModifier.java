/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLSV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOANG NAM
 */
public class StudentModifier {

    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Statement state = null;

        Connection conn = null;
        try {
            // lay tất cả danh sách sinh viên
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=studenmanager", "sa", "123");
            //query
            String sql = "select * from student";
            state = conn.createStatement();

            ResultSet resultSet = state.executeQuery(sql);

            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("age"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return studentList;
    }

    public static List<Student> findByFullname(String fullname) {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement state = null;

        Connection conn = null;
        try {
            // lay tất cả danh sách sinh viên
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=studenmanager", "sa", "123");
            //query
            String sql = "select * from student where fullname like ?";
            state = conn.prepareCall(sql);
            state.setString(1, "%"+fullname+"%");

            ResultSet resultSet = state.executeQuery();

            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("age"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //ket thuc.
        return studentList;
    }       
    
    public static void insert(Student std) {
        PreparedStatement state = null;
        Connection conn = null;
        try {
            // lay tất cả danh sách sinh viên
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=studenmanager", "sa", "123");
            //query
            String sql = "insert into student(fullname, gender, age, email, phone_number) values(?, ?, ?, ?, ?)";
            state = conn.prepareCall(sql);

            state.setString(1, std.getFullname());
            state.setString(2, std.getGender());
            state.setInt(3, std.getAge());
            state.setString(4, std.getMail());
            state.setString(5, std.getPhone_number());

            state.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void update(Student std) {
        PreparedStatement state = null;
        Connection conn = null;
        try {
            // lay tất cả danh sách sinh viên
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=studenmanager", "sa", "123");
            //query
            String sql = "update student set fullname=?, gender=?, age=?, email=?, phone_number=? where id = ?";
            state = conn.prepareCall(sql);

            state.setString(1, std.getFullname());
            state.setString(2, std.getGender());
            state.setInt(3, std.getAge());
            state.setString(4, std.getMail());
            state.setString(5, std.getPhone_number());
            state.setInt(6, std.getId());

            state.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void delete(int id) {
        PreparedStatement state = null;
        Connection conn = null;
        try {
            // lay tất cả danh sách sinh viên
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=studenmanager", "sa", "123");
            //query
            String sql = "delete from student where id = ?";
            state = conn.prepareCall(sql);

            state.setInt(1, id);

            state.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModifier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
