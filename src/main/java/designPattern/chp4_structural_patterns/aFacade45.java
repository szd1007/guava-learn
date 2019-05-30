package designPattern.chp4_structural_patterns;

import java.beans.Expression;

/**
 * 外观模式
 * 1 意图  为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个借口使得这一子系统更加容易使用
   2 动机  为降低系统复杂性会讲系统划分成多个子系统。为师子系统间通信和相互依赖关系达到最小。  引入facade模式，为子系统
           提供一个单一而简单的界面(子系统原来可能存在多个接口类对外提供服务）
   3 适用性

   5 参与者
      Facade（Compiler）
         - 知道哪些子系统类负责处理请求
         - 将客户端请求代理给适当的子系统对象
      Subsytem classess （Scanner 、Parser、ProgramNode等）
         - 实现子系统的功能
         - 处理由Facade对象指派的任务
         - 没有facade的任何相关信息，即没有指向facade的指针
     7 效果
      1） 屏蔽client对子系统组件的可见性（仅通过facade访问的client。 该模式并不会改变原有对外暴露的子接口），使用更加方便
      2） 实现子系统和客户间的松耦合关系
      3） 不限制client直接使用子系统类。你可以在系统易用性和通用性之间加以选择。
     8 实现

     11 相关模式
      abstractFactory31 与facade一起使用，以子系统队里的方式创建子系统对象。
      Mediator55
      Facade对象唯一，通常也要使用Singleton模式

 */
public class aFacade45 {
}

/**
 * 外观模式为client提供一个易用的接口
 */
class CompilerFacade{
    void compile() {
        Scanner scanner = new Scanner() {
            @Override
            Token scan() {
                return null;
            }
        };
        new Parser().parse(scanner, new DefaultProBuilder());
        ProgramNode programNode = new DefaultProBuilder().getRootNode();
        programNode.traverse(new RSICCodeGenerator());
    }
}


abstract class Scanner{
    abstract Token scan();
}

 class Parser{
     void parse(Scanner scanner, ProgramNodeBuilder builder){}
}
class Token{

}
abstract class ProgramNodeBuilder{
    abstract ProgramNode newVariable(String variableName);

    abstract ProgramNode newAssignment(ProgramNode node, ProgramNode expression);

    abstract ProgramNode newReturnStatement(ProgramNode value);

    abstract ProgramNode newCondition(ProgramNode condition, ProgramNode truePart, ProgramNode falsePart);
    abstract ProgramNode getRootNode();
}

class DefaultProBuilder extends ProgramNodeBuilder {

    @Override
    ProgramNode newVariable(String variableName) {
        return null;
    }

    @Override
    ProgramNode newAssignment(ProgramNode node, ProgramNode expression) {
        return null;
    }

    @Override
    ProgramNode newReturnStatement(ProgramNode value) {
        return null;
    }

    @Override
    ProgramNode newCondition(ProgramNode condition, ProgramNode truePart, ProgramNode falsePart) {
        return null;
    }

    @Override
    ProgramNode getRootNode() {
        return null;
    }
}
/**
 *  使用composite模式
 */
abstract class ProgramNode{

    abstract void getSourcePosition(int line, int index);

    abstract void add(ProgramNode node);

    abstract void remove(ProgramNode node);

    //子类要重写这个类，来实现遍历
     void traverse(CodeGenerator generator) {
         //子类visit this  「」；； composite 遍历子类的traverse
//        提供遍历框架， 封装具体逻辑。
        //不同的generator提供不同的功能，比如产生不同硬件平台机器码
        //for i in list
//        generator.visit(statementNode);
//        generator.visit(expression);
    }
}

/**
 * visitor511 模式
 */
abstract class CodeGenerator{
    abstract void visit(StatementNode node);

    abstract void visit(Expression expression);
}

class RSICCodeGenerator extends CodeGenerator {

    @Override
    void visit(StatementNode node) {

    }

    @Override
    void visit(Expression expression) {

    }
}

class StatementNode extends ProgramNode {

    @Override
    void getSourcePosition(int line, int index) {

    }

    @Override
    void add(ProgramNode node) {

    }

    @Override
    void remove(ProgramNode node) {

    }

    @Override
    void traverse(CodeGenerator generator) {
        generator.visit(this);
    }
}