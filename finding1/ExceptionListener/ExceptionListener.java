import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.JPFConfigException;
import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.jvm.bytecode.JVMInvokeInstruction;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.Types;
import gov.nasa.jpf.search.SearchListener;
import gov.nasa.jpf.vm.*;
import gov.nasa.jpf.search.*;
import java.util.*;

public class ExceptionListener extends ListenerAdapter implements
SearchListener, VMListener {

    private Map<String, ArrayList<String>> exceptions;

    public ExceptionListener() {
    this.exceptions = new HashMap<String, ArrayList<String>>();
    }


    public void exceptionThrown(VM vm, ThreadInfo currentThread, ElementInfo thrownException){
        ArrayList<String> list;
        if(this.exceptions.containsKey(currentThread.getTopFrameMethodInfo().getName())){
            list = this.exceptions.get(currentThread.getTopFrameMethodInfo().getName());
            if(!list.contains(thrownException.getClassInfo().getName())){
                list.add(thrownException.getClassInfo().getName());
            }
            this.exceptions.put(currentThread.getTopFrameMethodInfo().getName(), list);
        }else{
            list = new ArrayList<>();
            list.add(thrownException.getClassInfo().getName());
            this.exceptions.put(currentThread.getTopFrameMethodInfo().getName(), list);
        }
    }


    public void searchFinished(Search search) {

    Map<String, ArrayList<String>> sorted = new TreeMap<String, ArrayList<String>>(this.exceptions);

    for (String key : sorted.keySet()) {
        System.out.println("In method " + key + ", exceptions of the following types are thrown:");
        for(int i=0;i<sorted.get(key).size();i++){
            System.out.println("\t" + sorted.get(key).get(i));
        }
    }
    }
}