package uottawa.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Company {
    public static class Employee1 {
        private final int id;
        private final String name;
        private List<Employee1> reports;

        public Employee1(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<Employee1>();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Employee1> getReports() {
            return reports;
        }

        public void addReport(Employee1 employee) {
            reports.add(employee);
        }
    }

    public static class Employee1Node {
        private Employee1 self;
        private Employee1Node parent;
        private int level;

        Employee1Node(Employee1 self, Employee1Node parent, int level) {
            this.self = self;
            this.parent = parent;
            this.level = level;
        }

        public Employee1 getSelf() {
            return self;
        }

        public void setSelf(Employee1 self) {
            this.self = self;
        }
        public Employee1Node getParent() {
            return parent;
        }

        public void setParent(Employee1Node parent) {
            this.parent = parent;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
    
    public static Employee1 getCommonAncestor(Employee1 ceo, Employee1 firstEmployee, Employee1 secondEmployee) {
        int level = 0;
        Employee1Node firstNode = null;
        Employee1Node secondNode = null;

        Employee1Node etn = new Employee1Node(ceo, null, level);

        Stack<Employee1Node> myTree = new Stack<Employee1Node>();
        myTree.add(etn);

        do {
            Employee1Node parent = myTree.pop();
            level++;

            for(Employee1 emp : parent.getSelf().getReports()) {
                Employee1Node child = new Employee1Node(emp, parent, level);
                myTree.push(child);
                
                if (child.getSelf().getId() == firstEmployee.getId()) {
                    firstNode = child;
                } else if (child.getSelf().getId() == secondEmployee.getId()) {
                    secondNode = child;
                }
            }
            
        }while(!myTree.isEmpty());

        return searchCommonEmployee(firstNode, secondNode);
    }

    private static Employee1 searchCommonEmployee(Employee1Node firstNode, Employee1Node secondNode) {
        if (firstNode.getParent().getSelf().getId() == secondNode.getSelf().getId()) {
            return secondNode.getSelf();
        } else if (secondNode.getParent().getSelf().getId() == firstNode.getSelf().getId()) {
            return firstNode.getSelf();
        }

        Employee1Node firstNodeParent = firstNode.getParent();
        Employee1Node secondNodeParent = secondNode.getParent();
        while(firstNodeParent.getSelf().getId() != secondNodeParent.getSelf().getId()) {
            if (firstNodeParent.getLevel() > secondNodeParent.getLevel()) {
                firstNodeParent = firstNodeParent.getParent();
            } else {
                secondNodeParent = secondNodeParent.getParent();
            }
        }

        return firstNodeParent.getSelf();
    }

    
};