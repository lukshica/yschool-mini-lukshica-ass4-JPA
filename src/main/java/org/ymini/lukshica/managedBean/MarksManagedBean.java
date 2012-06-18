
package org.ymini.lukshica.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.ymini.lukshica.dao.Marks;
import org.ymini.lukshica.dao.MarksDAO;

@ManagedBean(name = "marksManagedBean")
@RequestScoped
public class MarksManagedBean {

    private static final Logger log = Logger.getLogger(MarksManagedBean.class);
    private Marks insertedResult;
    MarksDAO marksDAO;
    
    public MarksManagedBean() {
        this.insertedResult=new Marks();
        this.marksDAO=new MarksDAO();
    }
    
  
    public void insertMarks() {
        this.marksDAO.addMarks(insertedResult);        
        log.info("Added marks to "+insertedResult.getAdmissionno());
        insertedResult = new Marks();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Marks entered successfully ", null));
    }

    public Marks getInsertedResult() {
        return insertedResult;
    }

    public void setInsertedResult(Marks insertedResult) {
        this.insertedResult = insertedResult;
    }
   
}
