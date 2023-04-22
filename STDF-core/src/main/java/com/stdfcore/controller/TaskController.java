package com.stdfcore.controller;

import com.stdfcore.dao.UserAuthDao;
import com.stdfcore.entity.UserAuth;
import com.stdfcore.service.impl.UserDetailsServiceImpl;
import com.stdfcore.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    @GetMapping
    public String listTasks(){
        return "任务列表";
    }
    
    @PostMapping
    public String newTasks(){
        return "创建了一个新的任务";
    }
    
    @PutMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId")Integer id){
        return "更新了一下id为:"+id+"的任务";
    }
    
    @DeleteMapping("/{taskId}")
    public String deleteTasks(@PathVariable("taskId")Integer id){
        return "删除了id为:"+id+"的任务";
    }
}