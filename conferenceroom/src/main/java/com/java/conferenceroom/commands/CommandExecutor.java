package com.java.conferenceroom.commands;

import com.java.conferenceroom.exceptions.InvalidCommandException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;



@Component
@AllArgsConstructor
public class CommandExecutor {
    List<Command> commands=new ArrayList<>();


    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input)  {
        boolean flag=false;
        for(Command command : commands){
            if(command.matches(input)){
                command.execute(input);
                flag=true;
                break;
            }
        }
        if(!flag)
            throw new InvalidCommandException("Command not found");
    }

}
