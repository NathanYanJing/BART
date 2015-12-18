package it.unibas.bartgui.egtaskdataobject.nodes;

import bart.model.EGTask;
import it.unibas.bartgui.egtaskdataobject.NodeResource;
import it.unibas.bartgui.egtaskdataobject.EGTaskDataObjectDataObject;
import it.unibas.bartgui.resources.R;
import javax.swing.Action;
import org.openide.actions.OpenLocalExplorerAction;
import org.openide.awt.Actions;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.NbBundle;
import org.openide.util.actions.SystemAction;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;

/**
 *
 * @author Grandinetti Giovanni <grandinetti.giovanni13@gmail.com>
 */
@NbBundle.Messages({
    "HINT_RandomErrorTableNode=Percentage is wrt attributes to dirty in the table"
})
public class RandomErrorTableNode extends AbstractNode  {

    private String tabName;
    
    public RandomErrorTableNode(EGTask egt,EGTaskDataObjectDataObject dto,String tableName) {
        super(Children.create(new RandomErrorAttributeFactory(egt,dto,tableName), true),
                new ProxyLookup(Lookups.fixed(egt,dto),dto.getAbstractLookup()));
        this.tabName=tableName;
        setName(NodeResource.NODE_RandomErrorTableNode);
        setShortDescription(Bundle.HINT_RandomErrorTableNode());
        setIconBaseWithExtension(R.IMAGE_NODE_ARROW); 
    }


    @Override
    public String getHtmlDisplayName() {
         EGTask task = getLookup().lookup (EGTask.class); 
         if (task != null) { 
             return "<font color='#000052'>table:  </font><font color='#880052'>"
                    +tabName
                    +"  ("+task.getConfiguration().getPercentageForRandomErrors(tabName)+"%) </font>"+
                    "<font color='#888888'><i>"
                    +" attributes ("+task.getConfiguration().getAttributesForRandomErrors(tabName).size()
                    +")"+"</i></font>";
         } else{
             return null; 
         }
    }
    
    

    @Override
    public Action getPreferredAction() {
       return super.getPreferredAction();
    }
    
    
    @Override
    public Action[] getActions(boolean context) {
       Action[] result = new Action[]{
            Actions.forID("RandomErrorsNode", "it.unibas.bartgui.controlegt.actions.node.randomError.EditToDO"),
        };
        return result;
    }

    @Override
    public boolean canCut() {
        return false;
    }
    
    @Override
    public boolean canCopy() {
        return false;
    }

    @Override
    public boolean canDestroy() {
        return false;
    }

    @Override
    public boolean canRename() {
        return false;
    }
 

}
