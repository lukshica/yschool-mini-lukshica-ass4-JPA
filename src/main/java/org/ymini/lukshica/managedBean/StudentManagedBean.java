
package org.ymini.lukshica.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.ymini.lukshica.dao.Student;
import org.ymini.lukshica.dao.StudentDAO;


@ManagedBean(name = "studentManagedBean")
@SessionScoped
public class StudentManagedBean implements Serializable {
   
    
    private static final Logger log = Logger.getLogger(StudentManagedBean.class);
    
    private Student createStudent;
    private Student selectedStudent;
    private Student searchedStudent;
    StudentDAO studentDAO;
    private String message;

    private int grade;
   

    public StudentManagedBean() {
        this.createStudent = new Student();
        this.selectedStudent = new Student();
        this.searchedStudent = new Student();       
        this.studentDAO = new StudentDAO();
        
        log.info("Initiated studentManagedBean"); 
    }
    
    public List<Student> getStudentList() {
        return this.studentDAO.getStudentList();
    }
    
    
    public List<Student> getSearchStudent() {
        if(grade==0)
        {
            return this.studentDAO.searchStudentAll();
        }
        else{
            return this.studentDAO.searchStudentGrade(grade);
        }
       
    }
      
    
    public void prepareCreate() {
            this.studentDAO.insertStudent(createStudent);
            setSelectedStudent(createStudent);

            log.info("New Student Inserted :" + createStudent.getName());

            createStudent = new Student();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student added successfully ", null));

        }
    
    public void updateStudent() {
        this.studentDAO.updateStudent(this.selectedStudent);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student updated successfully ", null)); 
          
        log.info("Student Update Details" + selectedStudent.getName()+"");
    }

     public void deleteStudent() {
        this.studentDAO.deleteStudent(this.selectedStudent);
        this.selectedStudent = new Student();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student deleted successfully ", null));  
          log.info("Student Deleted ");
    }

        public List getStudentIDs(){        
        List stuIDs;        
        stuIDs=this.studentDAO.getStudentListIDs();        
        return stuIDs;        
    }  
    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public Student getCreateStudent() {
        return createStudent;
    }

    public void setCreateStudent(Student createStudent) {
        this.createStudent = createStudent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

 
    public Student getSearchedStudent() {
        return searchedStudent;
    }

    public void setSearchedStudent(Student searchedStudent) {
        this.searchedStudent = searchedStudent;
    }
 

}