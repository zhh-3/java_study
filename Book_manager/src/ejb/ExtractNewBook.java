/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 天王李靖小锟锟
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/demo6")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ExtractNewBook implements MessageListener {

    @PersistenceContext(unitName = "demo6PU")
    private EntityManager em;
    
    public ExtractNewBook() {
        
    }
    
    @Override
    public void onMessage(Message message) {
        try{
        if(message instanceof ObjectMessage){
            ObjectMessage om = (ObjectMessage)message;
            Book bk=(Book)om.getObject();
            em.persist(bk);
        }
        }catch(JMSException ex){
            ex.printStackTrace();
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
}
