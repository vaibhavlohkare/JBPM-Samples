/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.plugtree.training.jbpm;

import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemHandler;
import org.drools.runtime.process.WorkItemManager;
import org.plugtree.training.jbpm.model.MultiplierOperation;

/**
 *
 * @author esteban
 */
public class MultiplierWorkItemHandler implements WorkItemHandler {

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        MultiplierOperation multiplierOperation = (MultiplierOperation) workItem.getParameter("internalMultiplierOperation");
        multiplierOperation.setResult(multiplierOperation.getOp1() * multiplierOperation.getOp2());
        
        //because we are not creating a new MultiplierOperation, but modyfing 
        //the existing one, we don't need to add any output parameter
        manager.completeWorkItem(workItem.getId(), null);
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
    }
    
}
