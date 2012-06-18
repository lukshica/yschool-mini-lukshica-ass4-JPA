
package org.ymini.lukshica.dao;

import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Marks implements Serializable {
    @Id    
    private int admissionno;
    
    @Id    
    private int subjectid;    
   
    @Column(name = "studentmarks")
    private int studentmarks;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="ADMISSIONNO",referencedColumnName="ADMISSIONNO")
    private Student student;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="SUBJECTID",referencedColumnName="SUBJECTID")
    private Subject subject;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAdmissionno() {
        return admissionno;
    }

    public void setAdmissionno(int admissionno) {
        this.admissionno = admissionno;
    }

   
    public int getStudentmarks() {
        return studentmarks;
    }

    public void setStudentmarks(int studentmarks) {
        this.studentmarks = studentmarks;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }
}
