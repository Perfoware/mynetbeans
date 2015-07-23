/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pr.nb.csv.nodes;

import java.util.List;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.pr.nb.csv.nodes.data.CSVCell;
import org.pr.nb.csv.nodes.data.CSVRow;

/**
 *
 * @author Mahakaal
 */
public class CSVCellFactory extends ChildFactory.Detachable<CSVCell> {

    private final CSVRow key;
    public CSVCellFactory(CSVRow key) {
        this.key = key;
    }

    
    @Override
    protected boolean createKeys(List<CSVCell> toPopulate) {
        getCells(toPopulate);
        return true;
    }

    protected void getCells(List<CSVCell> toPopulate) {
        String [] datum = key.getRowData();
        for (int i = 0; i < datum.length; i++) {
            String data = datum[i];
            CSVCell cell = new CSVCell(data, i,key.getRowNumber());
            toPopulate.add(cell);
        }
    }
    protected void createChildren(List<CSVCellNode> toPopulate){
        String [] datum = key.getRowData();
        for (int i = 0; i < datum.length; i++) {
            String data = datum[i];
            CSVCell cell = new CSVCell(data, i,key.getRowNumber());
            CSVCellNode node = new CSVCellNode(cell);
            toPopulate.add(node);
        }
    }
    @Override
    protected Node createWaitNode() {
        Node waitNode = super.createWaitNode(); 
        waitNode.setDisplayName(Bundle.waitnode_text());
        return waitNode;
    }

    @Override
    protected Node createNodeForKey(CSVCell key) {
        return new CSVCellNode(key);
    }
    
    
}