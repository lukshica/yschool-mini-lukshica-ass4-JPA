
package org.ymini.lukshica.managedBean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.ymini.lukshica.dao.Subject;
import org.ymini.lukshica.dao.SubjectDAO;

@ManagedBean(name = "subjectManagedBean")
@RequestScoped
public class SubjectManagedBean {
    
    private static final Logger log = Logger.getLogger(SubjectManagedBean.class);
    
    private Subject createSubject;
    private Subject selectedSubject;
    private Subject searchedSubject;    
   
    private String subjectname;
    private List<Subject> Subject1;
    SubjectDAO subjectDAO;
    
   public SubjectManagedBean() {
        
        this.createSubject = new Subject();
        this.selectedSubject=new Subject();
        this.searchedSubject=new Subject();       
        
        this.subjectDAO = new  SubjectDAO();

        log.info("Initiated SubjectManagedBean");
    }

    public List<Subject> getSubjectList() {
        return this.subjectDAO.getSubjectList();
    }    
    
 
    public void updateSubject() {
        this.subjectDAO.updateSubject(this.searchedSubject);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Subject updated successfully ", null));

        log.info("Updated Subject");
    }    
    
   
    public void insertSubject() {
        this.subjectDAO.addSubject(createSubject);
        setSelectedSubject(createSubject);
        createSubject = new Subject();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Subject Registered successfully ", null));
        log.info("Added new Subject");
    }    
    
   
  
    public void deleteSubject() {
        this.subjectDAO.deleteSubject(this.searchedSubject);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Subject Deleted successfully ", null));
        this.searchedSubject=new Subject();
        log.info("Deleted Subject");
    }
    
  
    public List getSubjectIDs(){        
        List subIDs;        
        subIDs=this.subjectDAO.getSubjectListIDs();        
        return subIDs;        
    }

    public List<Subject> getSubject1() {
        return Subject1;
    }

    public void setSubject1(List<Subject> Subject1) {
        this.Subject1 = Subject1;
    }

    public Subject getCreateSubject() {
        return createSubject;
    }

    public void setCreateSubject(Subject createSubject) {
        this.createSubject = createSubject;
    }

    public Subject getSearchedSubject() {
        return searchedSubject;
    }

    public void setSearchedSubject(Subject searchedSubject) {
        this.searchedSubject = searchedSubject;
    }

    public Subject getSelectedSubject() {
        return selectedSubject;
    }

    public void setSelectedSubject(Subject selectedSubject) {
        this.selectedSubject = selectedSubject;
    }

    public SubjectDAO getSubjectDAO() {
        return subjectDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }
    

    
 }

