import org.junit.Test;

import com.example.Model.Project;
import com.example.Model.Subproject;
import com.example.Model.Task;
import com.example.Model.User;
import com.example.Service.TrelloApp;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TrelloAppTest {

    @Test
    public void testPerson() {
        TrelloApp trelloApp = new TrelloApp();
        User user1 = new User(1, "ank");
        User user2 = new User(9, "hub");
        User user3 = new User(8, "ssd");
        User user4 = new User(4, "hgh");
        User user5 = new User(5, "wer");
        User user6 = new User(6, "jkjk");
        Task task1 = new Task(3, user1);
        Task task2 = new Task(1, user5);
        Task task3 = new Task(6, user5);
        Task task4 = new Task(4, user3);
        Task task5 = new Task(2, user4);
        Task task6 = new Task(5, user5);
        Task task7 = new Task(7, user5);
        
        Subproject subproject1 = new Subproject(1);
        subproject1.setTask(task4);
        subproject1.setTask(task2);
        subproject1.setTask(task1);
        Subproject subproject2 = new Subproject(2);
        subproject2.setTask(task3);
        subproject2.setTask(task5);
        subproject2.setTask(task6);
        Project project = new Project(1);
        project.setSubProject(subproject1);
        project.setSubProject(subproject2);
        trelloApp.addProject(project);
        ArrayList<Task> tasks =  new ArrayList<>();
        tasks.add(task3);
        tasks.add(task5);
        tasks.add(task6);
        assertEquals(project, trelloApp.getProject(1));
        trelloApp.addTasks(1, 2, task7);
        tasks.add(task7);
        assertEquals(tasks, trelloApp.getTasksByProjectIdSubProjectId(1, 2));
        trelloApp.addUser(1, 2, 7, user6);
        assertEquals(user6, trelloApp.getUser(1, 2, 7));
        trelloApp.printTasks(user6);
        ArrayList<Task> tasks1 =  new ArrayList<>();
        tasks1.add(task7);
        assertEquals(tasks1.get(0).getTaskId(), trelloApp.getTasksByUserId(6).get(0).getTaskId());
    }
}
