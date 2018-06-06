package Code.Optimizer;

import Code.AST.Tools.Name;
import Code.IR.BasicBlock;
import Code.IR.CFGConstructor;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.PhysicalRegister;
import Code.IR.IRUnit.Oprands.Register;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphColoringAllocator
{
//    private String[] regNames = {"rbx"};
    private String[] regNames = {"rbx", "r10", "r11", "r12"};
    private String[] parameterRegNames = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
    private String[] calleeSaveNames = {"rbp", "rbx", "r12", "r13", "r14", "r15"};
    private List<BasicBlock> basicBlocks;
    private IRInstruction entry;
    private List<Function> functions;
    private List<PhysicalRegister> availableRegs;
    private List<PhysicalRegister> callerSaveRegs;
    private List<PhysicalRegister> calleeSaveRegs;
    private Function currentFunction;
    private Set<PhysicalRegister> usedRegs = new HashSet<>();
    private InterfereGraph interfereGraph = new InterfereGraph();
    private LivenessAnalyzer livenessAnalyzer;

    public GraphColoringAllocator(IRInstruction entry, List<Function> functions)
    {
        this.entry = entry;
        CFGConstructor cfgConstructor = new CFGConstructor(entry);
        basicBlocks = cfgConstructor.getBasicBlocks();
        livenessAnalyzer = new LivenessAnalyzer(entry);
        this.functions = functions;
        initRegisterList();
    }

    private void initRegisterList()
    {
        availableRegs = new ArrayList<>();
        for(String name : regNames)
            availableRegs.add(new PhysicalRegister(Name.getName(name)));
        calleeSaveRegs = new ArrayList<>();
        for(String name : calleeSaveNames)
        {
            PhysicalRegister pr = new PhysicalRegister(Name.getName(name));
            calleeSaveRegs.add(pr);
        }
    }

    public void process()
    {
        livenessAnalyzer.process();
        for(Function function : functions)
        {
            usedRegs.clear();
            currentFunction = function;
            interfereGraph.init(function); // x
            buildGraph(function);
            interfereGraph.simplify();
//            System.out.println(function.getName().toString());
            allocateRegister();

            function.usedRegs.add(calleeSaveRegs.get(0));
            function.usedRegs.addAll(usedRegs);
        }
    }

    public void buildGraph(Function function)
    {
        for (Parameter parameter : function.getParameter())
        {
            for (Parameter parameter1 : function.getParameter())
            {
                interfereGraph.addEdge(parameter.getAddress(), parameter1.getAddress());
            }
        }
        for (BasicBlock block : function.getBasicBlocks())
        {
            for (IRInstruction inst : block.getInstructions())
            {
                if (!(inst instanceof Assign)) continue;
                Assign assignInst = (Assign) inst;
                Address dest = assignInst.getDest();
                if(dest == null || dest.isPointer()) continue;
                if(dest.isGlobal()) continue;
                if(inst instanceof Store)
                {
                    for (Register register : inst.liveOut)
                    {
                        if(register != ((Store) inst).getData())
                            interfereGraph.addEdge(dest, register);
                    }
                }
                else
                {
                    for (Register register : inst.liveOut)
                    {
                        interfereGraph.addEdge(dest, register);
                    }
                }
            }
        }
        interfereGraph.updateDegree();
    }

    private void allocateRegister()
    {
        Set<PhysicalRegister> neighborReg = new HashSet<>();
        while (!interfereGraph.registerStack.isEmpty())
        {
            neighborReg.clear();
            Register register = interfereGraph.registerStack.pop();
            register.isDeleted = false;
            if(register instanceof Address && ((Address) register).isGlobal())
                continue;
            for (Register neighbor : register.neighbors)
            {
                if (!neighbor.isDeleted && neighbor.isAssigned)
                    neighborReg.add(neighbor.getPhysicalRegister());
            }
            for (PhysicalRegister pr : availableRegs)
            {
                if(register.isInStack())
                    System.out.println(1);
                if (!neighborReg.contains(pr))
                {
                    register.setPhysicalRegister(pr);
//                    register.isAssigned = true;
                    usedRegs.add(pr);
                    break;
                }
            }
            if (!register.isAssigned)
                register.setInStack(true);
        }
    }
}


