package com.example.demo22;

import model.entity.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoServlet", value = "/TodoServlet")
public class TodoServlet extends HttpServlet {
    public List<Task> list = new ArrayList<>();

    public void init() {
        list.add(new Task(1, "di hoc"));
        list.add(new Task(2, "di choi"));
        list.add(new Task(3, "di ngu"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action =  request.getParameter("action");
      if (action != null && action.equals("delete")){
          int id = Integer.parseInt(request.getParameter("id"));
          for (Task t:list) {
              if (t.getId() == id){
                  list.remove(t);
                  break;
              }
          }
      }else if (action != null && action.equals("edit")){
          int id = Integer.parseInt(request.getParameter("id"));
          for (Task t:list) {
              if (t.getId() == id){
                request.setAttribute("taskEdit",t);
                  break;
              }
          }
          request.getRequestDispatcher("view/updateList.jsp").forward(request,response);
      }
          showAllList(request, response);

    }

    public void showAllList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("list", list);
        request.getRequestDispatcher("view/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null &&action.equals("Add")){
        String newTask = request.getParameter("task");
        int id = list.size() == 0 ? 1 : list.get(list.size() - 1).getId() + 1;
        list.add(new Task(id, newTask));
        }else if (action != null &&action.equals("edit")){
            String task = request.getParameter("taskName");
            int id = Integer.parseInt(request.getParameter("id"));
            for (Task t:list) {
                if (t.getId()==id ){
                    t.setTaskName(task);
                    break;
                }
            }
        }
        showAllList(request,response);
    }
}
