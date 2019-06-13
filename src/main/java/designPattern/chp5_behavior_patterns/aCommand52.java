package designPattern.chp5_behavior_patterns;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 命令
 * 别名  动作Action  事物Transaction
 * 1 意图   将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或记录日志，
 *         以及支持可撤消的操作
 * 4 适用性
 *   - 支持撤销操作，每个command子类声明 unExecute 接口，并保存操作之前的状态，方便取消
 *   - 事物支持
 *
 *
 * ----------------------------------------------------------------------------------------
 *
 *  和职责链的区别。 命令模式将每一个请求用一个对象封装。这个对象包含的请求的状态和执行逻辑。
 *  而职责链 每个职责对象唯一，不能进行已执行的对象保存。将一个请求传递个多个对象执行
 *
 *  命令模式的优点就是 每个请求状态都得以保存，我们可以保存一个命令对象列表进行取消和重做。 将多个命令传递给一个对象执行
 *
 */
@SuppressWarnings("all")
public class aCommand52 {

    public static void main(String[] args) {
        List<Command> history = Lists.newArrayList();
        if (needExecutePaste()) {
            Command command = new PasteCommand();
            history.add(command);
            command.execute();
        }

    }

    private static boolean needExecutePaste() {
        return false;
    }
}

/**
 * 命令模式统一接口
 */
interface Command{

    void execute();
}

class OpenCommand implements Command {

    public static final AtomicInteger i = new AtomicInteger(0);
    @Override
    public void execute() {
        System.out.println("this is a open command " + i.incrementAndGet());
    }
}

class PasteCommand implements Command {

    @Override
    public void execute() {
        System.out.println("this is a paste command");
    }
}

/**
 * 对象组合命令， 一个功能由多个子命令组成
 */
class MacroCommand implements Command {

    List<Command> commands ;

    public MacroCommand() {
        this.commands = Lists.newArrayList();
    }

    public void add(Command command) {
        commands.add(command);
    }

    public void remove(Command command) {
        commands.remove(command);
    }


    @Override
    public void execute() {
        commands.forEach(Command::execute);
    }
}

