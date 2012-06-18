
package org.ymini.lukshica.dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Subject implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "subjectid")
    private int subjectid;    
    
    @OneToMany
    private Collection<Marks> students;
    
    @Column(name = "subjectname")
    private String subjectname;

    public Collection<Marks> getStudents() {
        return students;
    }

    public void setStudents(Collection<Marks> students) {
        this.students = students;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }


    
}
